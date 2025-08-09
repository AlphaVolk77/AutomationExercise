package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.*;

public class HomePage extends BasePageObject {

    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

    public HomePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//ul[@class='nav navbar-nav']//a[@href='/login']")
    WebElement loginTab;

    @FindBy(xpath = "//section[@id='form']//div[@class='login-form']/h2")
    WebElement loginToAccountmsg;

    @FindBy(xpath = "//section[@id='form']//div[@class='signup-form']/h2")
    WebElement newUserSignUpmsg;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//a[@href='/delete_account']")
    WebElement deletedAccountbtn;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//a[@href='/logout']")
    WebElement logOutbtn;

    @FindBy(xpath = "//section[@id='form']/div/div/div/h2[@data-qa='account-deleted']")
    WebElement accountDeletedmsg;

    @FindBy(xpath = "//div[@class='pull-right']/a")
    WebElement continueBtn;

    public void LaunchApp()
    {
        String url= "https://automationexercise.com/";
        driver.get(url);
        driver.manage().window().maximize();
        logger.info("AutomationExercise website launched");
    }

    public boolean loginTab()
    {
        //expwait();
        loginTab.click();
        logger.info("Login tab is clicked");
        return loginToAccountmsg.isDisplayed();
    }

    public boolean signUpTab()
    {
        //expwait();
        loginTab.click();
        logger.info("Login tab is clicked");
        return newUserSignUpmsg.isDisplayed();
    }

    public boolean deleteAccount()
    {
        try {
            deletedAccountbtn.click();
            logger.info("Account deleted button is clicked");
        }
        catch (Exception e)
        {
            logger.debug("Exception Caught: " + e);
        }
        return accountDeletedmsg.isDisplayed();
    }

    public boolean logoutUser()
    {
        try {
            logOutbtn.click();
        }
        catch (Exception e)
        {
            logger.debug("Exception Caught: " + e);
        }
        return loginTab.isDisplayed();
    }
}
