package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.*;

public class LoginPage extends BasePageObject {

    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//section[@id='form']//div[@class='signup-form']/h2")
    WebElement signUpTitle;

    @FindBy(xpath = "//div[@class='login-form']/h2/b")
    WebElement enterAccDetailsMsg;

    @FindBy(xpath = "//form[@action='/signup']/input[@name='name']")
    WebElement signUpName;

    @FindBy(xpath = "//form[@action='/signup']/input[@name='email']")
    WebElement signUpemail;

    @FindBy(xpath = "//form[@action='/signup']/button[@class='btn btn-default']")
    WebElement signUpbtn;

    public void enterSignUpUsername(String uname)
    {
        signUpName.sendKeys(uname);
    }

    public void enterSignUpEmail(String mail)
    {
        signUpemail.sendKeys(mail);
    }

    public boolean signUp(String username,String email)
    {
        logger.info("Login page is opened");
        enterSignUpUsername(username);
        enterSignUpEmail(email);
        signUpbtn.click();
        logger.info("Signup button is clicked");
        expwait();
        return enterAccDetailsMsg.isDisplayed();
    }



}
