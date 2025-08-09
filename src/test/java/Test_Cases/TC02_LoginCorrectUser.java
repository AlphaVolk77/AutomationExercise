package Test_Cases;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignUpPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC02_LoginCorrectUser extends BaseTestClass{

    private static final Logger logger = LoggerFactory.getLogger(TC02_LoginCorrectUser.class);

    @BeforeClass
    public void SignupUser()
    {
        HomePage homePage = new HomePage(driver);
        homePage.LaunchApp();
        Assert.assertTrue(driver.getTitle().equals("Automation Exercise"),"Home Page is not visible");
        Assert.assertTrue(homePage.signUpTab(),"'New User Signup!' message is not visible");
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.signUp("xyz","xyz123@def.com"),"'ENTER ACCOUNT INFORMATION' message is not visible");
        SignUpPage signUpPage = new SignUpPage(driver);
        Assert.assertTrue(signUpPage.fillAccountInfo("Mr","xyz","xyz123@def","25","July","2001"),"Account information is not entered successfully");
        Assert.assertTrue(signUpPage.fillAddressinfoandCreateAccount("xyz","XYZ","def","abc","def","India","Sikkim","Gangtok","123456","9876543210"),"ACCOUNT CREATED! message is not visible");
        Assert.assertTrue(signUpPage.accountCreatedVerification("xyz"),"Logged in username is not correct");
        Assert.assertTrue(homePage.logoutUser(),"Current user was not logged out");
    }

    @Test
    public void TC02_LoginCorrectUser()
    {
        try {
            logger.info("Test Case 2: Login with correct user started");
            HomePage homePage = new HomePage(driver);
            homePage.LaunchApp();
            Assert.assertTrue(driver.getTitle().equals("Automation Exercise"),"Home Page is not visible");
            Assert.assertTrue(homePage.loginTab(),"'Login to your account' message is not visible");
            LoginPage loginPage = new LoginPage(driver);
            Assert.assertTrue(loginPage.login("xyz123@def.com","xyz","xyz123@def"),"Logged in with incorrect user");
            SignUpPage signUpPage = new SignUpPage(driver);
            Assert.assertTrue(signUpPage.accountCreatedVerification("xyz"),"Logged in username is not correct");
            Assert.assertTrue(homePage.deleteAccount(),"'ACCOUNT DELETED!' message is not displayed");
            logger.info("Test case Passed.");
        }

        catch (Exception e)
        {
            logger.error("Test case Failed due to" + e);
        }
    }

}
