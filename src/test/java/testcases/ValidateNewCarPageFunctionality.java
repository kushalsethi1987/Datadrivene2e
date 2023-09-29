package testcases;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class ValidateNewCarPageFunctionality extends TestBase {

    @Test(enabled=false)
    public void goToCarTradePage()
    {
        driver.findElement(By.xpath(OR.getProperty("carWaleLogo"))).click();
        log.info("Clicked carwalelogo");
        driver.findElement(By.xpath(OR.getProperty("searchButton"))).click();
        log.info("Clicked searchbutton");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,3000)", "");
        driver.findElement(By.xpath(OR.getProperty("carTradeLogo"))).click();
        log.info("Clicked cartradelink");
        System.out.println(driver.getWindowHandles());

    }


}
