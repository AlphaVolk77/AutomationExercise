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

    @FindBy(xpath = "//form[@action='/login']/input[@name='email']")
    WebElement loginEmail;

    @FindBy(xpath = "//form[@action='/login']/input[@name='password']")
    WebElement loginPassword;

    @FindBy(xpath = "//form[@action='/login']/button[@class='btn btn-default']")
    WebElement loginbtn;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//i[@class='fa fa-user']/following::b")
    WebElement loggedinUsername;

    public void enterSignUpUsername(String uname)
    {
        signUpName.sendKeys(uname);
    }

    public void enterSignUpEmail(String mail) {signUpemail.sendKeys(mail);}

    public void enterLoginEmail(String mail) {loginEmail.sendKeys(mail);}

    public void enterPassword(String pass) {loginPassword.sendKeys(pass);}

    public boolean signUp(String username,String email)
    {
        try {
            logger.info("Login page is opened");
            enterSignUpUsername(username);
            enterSignUpEmail(email);
            signUpbtn.click();
            logger.info("Signup button is clicked");
            expwait();
        }

        catch (Exception e)
        {
            logger.debug("Exception Caught: " + e);
        }

        return enterAccDetailsMsg.isDisplayed();
    }

    public boolean login(String usermail, String username, String password)
    {
        try {
            logger.info("Login page is opened");
            enterLoginEmail(usermail);
            enterPassword(password);
            logger.info("Email and Password entered");
            loginbtn.click();
            logger.info("Login button is clicked");
            expwait();
        }
        catch (Exception e)
        {
            logger.debug("Exception Caught: " + e);
        }
        return loggedinUsername.getText().equalsIgnoreCase(username);
    }



}
