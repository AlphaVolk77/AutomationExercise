package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePageObject
{
    protected WebDriver driver;
    //protected WebDriverWait wait;

    public BasePageObject(WebDriver driver)
    {
        this.driver = driver;
    }

    public void impWait()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void expwait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForElementToBeClickable()
    {

    }
}
