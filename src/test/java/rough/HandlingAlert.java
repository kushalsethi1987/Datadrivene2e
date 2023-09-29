package rough;

import base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HandlingAlert extends TestBase {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("");
        Alert alert =wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        alert.getText();
        alert.dismiss();
        alert.sendKeys("");
    }
}
