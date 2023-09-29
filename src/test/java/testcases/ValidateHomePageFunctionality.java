package testcases;

import base.TestBase;
import com.aventstack.extentreports.Status;
import extentlisteners.ExtentListeners;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestUtilities;

import java.lang.reflect.Method;
import java.util.Hashtable;

public class ValidateHomePageFunctionality extends TestBase {

    @Test(enabled=false)
    public void validateSearchButtonClick() throws InterruptedException
    {
        SoftAssert softAssert=new SoftAssert();
        //using custom isElementPresent method
        softAssert.assertTrue(isElementPresent(By.xpath(OR.getProperty("searchButton"))),"Element is present");
        driver.findElement(By.xpath(OR.getProperty("searchButton"))).click();
        Thread.sleep(3000);
        System.out.println(driver.getTitle());
        softAssert.assertEquals(driver.getTitle(),
                "New Cars in India 2023 | New Car Information | Best New Cars - CarWale");
        softAssert.assertAll();
    }

    @Test(dataProviderClass = TestUtilities.class,dataProvider ="getData")
    public void carWaleHomePageLoginVerify(Hashtable<String, String> data) throws InterruptedException
    {
        //Without Keyword use
            /*driver.findElement(By.xpath(OR.getProperty("loginButton"))).click();*/
        // With Keyword use
            click("loginButton");
            Thread.sleep(2000);
        //Without Keyword use
            /*driver.findElement(By.xpath(OR.getProperty("userName_xpath"))).sendKeys(data.get("username"));*/
        // With Keyword use
            type("userName_xpath",data.get("username"));
        Thread.sleep(2000);
            ExtentListeners.test.log(Status.INFO,"Entered Username "+data.get("username"));
            System.out.println(data.get("username"));
    }


}
