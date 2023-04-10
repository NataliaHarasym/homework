package email;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelTest {
    private WebDriver driver;
    private final String URL = "https://demo.opencart.com/";

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void beforeClass() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(URL);
    }

        @Test
    public void checkPrice()
    {
        driver.findElement(By.xpath("//*[@href='#']")).click();
        driver.findElement(By.xpath("//a[@href='EUR']")).click();
        driver.findElement(By.xpath("//a[text()='Desktops']")).click();
        driver.findElement(By.xpath("(//*[@class='list-unstyled']//*[contains(text(), 'Mac')])[1]")).click();
        WebElement price = driver.findElement(By.xpath("//a[text()='iMac']/../following-sibling::div[@class='price']"));
        Assert.assertTrue(price.getText().contains("111.55€"));
    }
}
