package Pages;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.*;

import java.io.Console;

public class SignUpPage extends BasePageObject{
    public SignUpPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
        impWait();
    }

    private static Logger logger = LoggerFactory.getLogger(SignUpPage.class);



    @FindBy(xpath = "//div[@class='login-form']/h2/b")
    WebElement newAccInfoTxt;

    @FindBy(xpath = "//div[@class='login-form']/form[@action='/signup']/div[1]/div[1]/label/div[1]/span/input[@value='Mr']")
    WebElement radiobtnMr;

    @FindBy(xpath = "//div[@class='login-form']/form[@action='/signup']/div[1]/div[2]/label/div[1]/span/input[@value='Mrs']")
    WebElement radiobtnMrs;

    @FindBy(xpath = "//div[@class='login-form']/form[@action='/signup']/div[@class='required form-group'][1]/input")
    WebElement nameBox;

    @FindBy(xpath = "//div[@class='login-form']/form[@action='/signup']/div[@class='required form-group'][3]/input")
    WebElement passwordBox;

    @FindBy(xpath = "//div[@class='login-form']/form[@action='/signup']/div[@class='form-group']/div/div[1]/div/select[@id='days']")
    WebElement daySelect;

    @FindBy(xpath = "//div[@class='login-form']/form[@action='/signup']/div[@class='form-group']/div/div[2]/div/select[@id='months']")
    WebElement monthSelect;

    @FindBy(xpath = "//div[@class='login-form']/form[@action='/signup']/div[@class='form-group']/div/div[3]/div/select[@id='years']")
    WebElement yearSelect;

    @FindBy(xpath = "//div[@class='login-form']/form[@action='/signup']/div[@class='checkbox'][1]/div/span/input")
    WebElement newsletterCheckbox;

    @FindBy(xpath = "//div[@class='login-form']/form[@action='/signup']/div[@class='checkbox'][2]/div/span/input")
    WebElement offerCheckbox;

    @FindBy(css = "input[id='first_name']")
    WebElement firstNameTxtBox;

    @FindBy(css = "input[id='last_name']")
    WebElement lastNameTxtBox;

    @FindBy(css = "input[id='company']")
    WebElement companyTxtBox;

    @FindBy(css = "input[id='address1']")
    WebElement addressbox1;

    @FindBy(css = "input[id='address2']")
    WebElement addressbox2;

    @FindBy(css = "select[id='country']")
    WebElement countrySelect;

    @FindBy(css = "input[id='state']")
    WebElement stateTxtbox;

    @FindBy(css = "input[id='city']")
    WebElement cityTxtbox;

    @FindBy(css = "input[id='zipcode']")
    WebElement zipcodeTxtbox;

    @FindBy(css = "input[id='mobile_number']")
    WebElement mobilenumberTxtbox;

    @FindBy(xpath = "//input[@value='create_account']/following-sibling::button")
    WebElement createAccountBtn;

    @FindBy(xpath = "//section[@id='form']/div/div/div/h2")
    WebElement accountCreatedmsg;

    @FindBy(xpath = "//div[@class='pull-right']/a")
    WebElement continueBtn;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//i[@class='fa fa-user']/following::b")
    WebElement loggedinUsername;



    JavascriptExecutor js = (JavascriptExecutor) driver;

    public boolean fillAccountInfo(String title,String name, String password, String day, String month, String year)
    {
        //expwait();
        logger.info("Signup page is opened");
        try {
        if (title.equalsIgnoreCase("mr"))
        {
            radiobtnMr.click();
        }

        else if (title.equalsIgnoreCase("mrs"))
        {
            radiobtnMrs.click();
        }

        if(nameBox.getText() != name)
        {
            nameBox.clear();
            nameBox.sendKeys(name);
        }
        passwordBox.sendKeys(password);
        Select dayDropdown = new Select(daySelect);
        dayDropdown.selectByValue(day);
        Select monthDropdown = new Select(monthSelect);
        monthDropdown.selectByContainsVisibleText(month);
        Select yearDropdown = new Select(yearSelect);
        yearDropdown.selectByValue(year);
        logger.info("Account information like Title, Name, Email, Password, Date of birth entered successfully");
        js.executeScript("arguments[0].scrollIntoView(true)",newsletterCheckbox);
        newsletterCheckbox.click();
        logger.info("'Sign up for our newsletter!' checkbox is checked");
        offerCheckbox.click();
        logger.info("'Receive special offers from our partners!' checkbox is checked");
        }
        catch (Exception e)
        {
            logger.debug("Exception Caught: " + e);
        }
        return offerCheckbox.isSelected();
    }

    public boolean fillAddressinfoandCreateAccount(String FirstName,String LastName, String Company, String Address1, String Address2, String Country, String State, String City, String ZipCode, String MobileNumber)
    {
        try {
        firstNameTxtBox.sendKeys(FirstName);
        lastNameTxtBox.sendKeys(LastName);
        companyTxtBox.sendKeys(Company);
        addressbox1.sendKeys(Address1);
        addressbox2.sendKeys(Address2);
        Select countryDropdown = new Select(countrySelect);
        countryDropdown.selectByValue(Country);
        stateTxtbox.sendKeys(State);
        cityTxtbox.sendKeys(City);
        zipcodeTxtbox.sendKeys(ZipCode);
        mobilenumberTxtbox.sendKeys(MobileNumber);
        js.executeScript("arguments[0].scrollIntoView(true)",createAccountBtn);
        logger.info("Address information entered successfully");
        createAccountBtn.click();
        logger.info("Account Create button clicked");
        }
        catch (Exception e)
        {
            logger.debug("Exception Caught: " + e);
        }

        return accountCreatedmsg.isDisplayed();
    }

    public boolean accountCreatedVerification(String username)
    {
        try {
            if (continueBtn.isDisplayed())
            {continueBtn.click();}
            else{logger.info(loggedinUsername.getText());}
        }
        catch (Exception e)
        {
            logger.debug("Exception Caught: " + e);
        }
        return loggedinUsername.getText().equals(username);
    }

}
