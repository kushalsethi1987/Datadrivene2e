package rough;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ScrollingInAPage {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.carwale.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();

        //----Scrolling feature
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,3000)", "");
        //---End of scrolling feature

        WebElement element = driver.findElement(By.xpath
                ("//a[@title='CarTrade']//*[name()='svg']//*[name()='path'and contains(@fill,'rgba(255, ')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        /*driver.findElement(By.xpath("//a[@title='CarTrade']//*[name()='svg']//*[name()='path'and contains(@fill,'rgba(255, ')]")).click();
        System.out.println(driver.getWindowHandles());*/
    }
}
