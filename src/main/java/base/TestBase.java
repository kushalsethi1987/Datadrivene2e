package base;

import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.*;
import utilities.ExcelReader;
import utilities.TestUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import static extentlisteners.ExtentListeners.test;
import static java.lang.Boolean.TRUE;

public class TestBase {

    public static WebDriver driver;
    public static Properties config;
    public static Properties OR;
    public static FileInputStream fis;
    public static Logger log=Logger.getLogger(TestBase.class.getName());
    Date currentDate=new Date();
    public static ExcelReader excelReader=new ExcelReader
            (System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testData.xlsx");
    public static WebDriverWait wait;
    public static String browser;

    @BeforeSuite
    public void setUp() throws IOException {

        System.setProperty("current.date",currentDate.toString().replace(":","_").replace(" ","_"));
        PropertyConfigurator.configure
                (System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\log4j.properties");

        if(driver==null)
        {
            config= new Properties();
            fis= new FileInputStream
                    (System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
            config.load(fis);
            OR= new Properties();
            fis=new FileInputStream
                    (System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
            OR.load(fis);
            log.info("OR property file loaded");
            Reporter.log("OR property file loaded");
        }

        // IMPORTANT : Filter used in jenkins would work on the below logic
        /*if(System.getenv("browser").isEmpty() && System.getenv("browser").isBlank())
        {
            browser=System.getenv("browser");
        }
        else
        {
            browser= config.getProperty("browser");
        }
        config.setProperty("browser", browser);*/

        // IMPORTANT : Based on config property browser this would work
        if(config.getProperty("browser").equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else if(config.getProperty("browser").equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        driver.get(config.getProperty("siteUrl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait
                (Duration.ofSeconds(Integer.parseInt(config.getProperty("implicitwait"))));
    }
    @AfterSuite
    public void tearDown() {

        driver.quit();
        Reporter.log("Chrome Closed");
    }
    public Boolean isElementPresent(By by)
    {

        try
        {
            driver.findElement(by);
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }

    /*@BeforeMethod

    public void checkIsTestRunnable(ITestResult iTestResult)
    {
        if(!TestUtilities.isTestRunnable(iTestResult.getName(), excelReader))
        {
            throw new SkipException("Skipping the test case");
        }
    }*/

    public void click(String locator)
    {
        driver.findElement(By.xpath(OR.getProperty(locator))).click();
        test.log(Status.INFO, "Clicking on locator "+locator);
    }

    public void type(String locator, String value)
    {
        driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
        test.log(Status.INFO, "Typing in the "+locator+" the value "+value);
    }

    public static WebElement dropDown;

    public void select(String locator,String value)
    {
        dropDown=driver.findElement(By.xpath(OR.getProperty(locator)));
        Select select=new Select(dropDown);
        select.selectByVisibleText(value);
        test.log(Status.INFO, "Selecting from dropdown "+locator+" value as "+value);
    }

    public static Boolean isTestRunnable(String testName,ExcelReader excelReader)
    {
        String sheetName="test suite";
        int rows=excelReader.getRowCount(sheetName);

        for(int rNum=2;rNum<=rows;rNum++)
        {
            String testCase=excelReader.getCellData(sheetName,"TCID",rNum);

            if(testCase.equalsIgnoreCase("testName"))
            {
             String runMode=excelReader.getCellData(sheetName,"RunMode",rNum);
             if(runMode.equalsIgnoreCase("Y"))
             {
                 return true;
             }
             else
             {
                 return false;
             }
            }
        }
        return false;
    }


}
