package rough;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class ExtentReportThreadLocalParallel {

    public static ExtentSparkReporter htmlReporter; // Create Html file and add configurations
    public static ExtentReports extent;

    public static ExtentTest test;

    public static ThreadLocal<ExtentTest> classLevelLogger=new ThreadLocal<ExtentTest>();
    public static ThreadLocal<ExtentTest> testLevelLogger=new ThreadLocal<ExtentTest>();

    @BeforeTest
    public void setReport()
    {
        htmlReporter=new ExtentSparkReporter
                (System.getProperty("user.dir")+"\\src\\test\\resources\\testreports\\extent.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Kushal Extent Reports");
        htmlReporter.config().setReportName("Automation Experts");
        htmlReporter.config().setTheme(Theme.STANDARD);


        extent= new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Build Number","1024");
        extent.setSystemInfo("org","AutomationExpertsKushal");
    }


    @AfterTest
    public void endReportPrint()
    {
        extent.flush();
    }

    @BeforeMethod
    public static void testLevelLogging(Method method)
    {
       ExtentTest test=classLevelLogger.get().createNode(method.getName().toUpperCase());
       testLevelLogger.set(test);
    }

    @AfterMethod
    public void updateResult(ITestResult result)
    {
        if (result.getStatus()==ITestResult.FAILURE)
        {
            Markup helper= MarkupHelper.createLabel
                    ("Test Case Failed "+result.getName()+""+ result.getMethod().getMethodName(), ExtentColor.RED);

            //---Without Markup--//
            /*test.fail("Test Case Failed"); */

            //---With Markup--//
            testLevelLogger.get().fail(helper);

        }
        else if (result.getStatus()==ITestResult.SUCCESS)
        {
            Markup helper=MarkupHelper.createLabel("Test Case Passed", ExtentColor.GREEN);

            //---Without Markup--//
            /*test.fail("Test Case Passed"); */

            //---With Markup--//
            testLevelLogger.get().pass(helper);
        }
        else if (result.getStatus()==ITestResult.SKIP)
        {
            Markup helper=MarkupHelper.createLabel("Test Case Skipped", ExtentColor.AMBER);

            //---Without Markup--//
            /*test.fail("Test Case Skipped"); */

            //---With Markup--//
            testLevelLogger.get().skip(helper);
        }
    }

    @BeforeClass
    public void settingClassLevelReport()
    {
        ExtentTest test=extent.createTest(getClass().getName());
        classLevelLogger.set(test);
    }

    @Test
    public void testCasePass()
    {

        testLevelLogger.get().log(Status.INFO,"Entered Username");
        testLevelLogger.get().log(Status.INFO,"Entered Password ");
    }

    @Test
    public void testCaseFail()
    {

        testLevelLogger.get().log(Status.INFO,"Entered Username");
        testLevelLogger.get().log(Status.INFO,"Entered Password ");
        Assert.fail();
    }
    @Test
    public void testCaseSkip()
    {

        testLevelLogger.get().log(Status.INFO,"Entered Username");
        testLevelLogger.get().log(Status.INFO,"Entered Password ");
        throw new SkipException("Skipping the test case");
    }



}
