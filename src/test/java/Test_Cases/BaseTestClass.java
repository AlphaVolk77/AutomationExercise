package Test_Cases;

import org.openqa.selenium.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.slf4j.*;

/**
 * Unit test for simple BasePageObject.
 */
public class BaseTestClass
{
    public WebDriver driver;

    private static final Logger logger = LoggerFactory.getLogger(BaseTestClass.class);

    @Parameters("browser")
    @BeforeClass
    public void DriverManager(String browser)
    {
        if (browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        else if (browser.equalsIgnoreCase("edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        logger.info("Driver initiated");
    }

    @AfterClass
    public void tearDown()
    {
        if(driver != null)
            driver.quit();
        logger.info("Driver closed");
    }
}
