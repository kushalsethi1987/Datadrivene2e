package rough;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class ClickingSVGElement {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        Map<String,Object> prefs= new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications",2);
        prefs.put("credentials_enable_service",false);
        prefs.put("profile.password_manager_enabled",false);
        ChromeOptions options=new ChromeOptions();
        options.setExperimentalOption("prefs",prefs);
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.carwale.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,3000)", "");
        WebElement element = driver.findElement(By.xpath("//a[@title='CarTrade']//*[name()='svg']//*[name()='path'and contains(@fill,'rgba(255, ')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        /*driver.findElement(By.xpath
                        ("//a[@title='CarTrade']//*[name()='svg']//*[name()='path'and contains(@fill,'rgba(255, ')]"))
                .click();*/


    }
}
