package rough;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Rough {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.carwale.com/");
        driver.findElement(By.xpath("//div[@class='o-fzptZU o-cONQOm']//*[name()='svg']")).click();
        driver.findElement(By.xpath("//div[@class='o-brXWGL']/input[@placeholder='Enter Your Email Id']"))
                .sendKeys("kushal.sethi.nkaps@gmail.com");
    }
}
