package Test_Cases;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.slf4j.*;

public class TC01_RegisterUser extends BaseTestClass {

    private static Logger logger = LoggerFactory.getLogger(TC01_RegisterUser.class);
@Test
    public void TC01_RegisterUser()
    {
        try {
            logger.info("Test Case 1: Register User started");
            HomePage homePage = new HomePage(driver);
            homePage.LaunchApp();
            Assert.assertTrue(driver.getTitle().equals("Automation Exercise"),"Home Page is not visible");
            Assert.assertTrue(homePage.signUpTab(),"'New User Signup!' message is not visible");
            LoginPage loginPage = new LoginPage(driver);
            Assert.assertTrue(loginPage.signUp("abc","abc123@def.com"),"'ENTER ACCOUNT INFORMATION' message is not visible");
            SignUpPage signUpPage = new SignUpPage(driver);
            Assert.assertTrue(signUpPage.fillAccountInfo("Mr","abc","abc123@def","25","July","2001"),"Account information is not entered successfully");
            Assert.assertTrue(signUpPage.fillAddressinfoandCreateAccount("abc","ABC","def","abc","def","India","Sikkim","Gangtok","123456","9876543210"),"ACCOUNT CREATED! message is not visible");
            Assert.assertTrue(signUpPage.accountCreatedVerification("abc"),"Logged in username is not correct");
            Assert.assertTrue(homePage.deleteAccount(),"'ACCOUNT DELETED!' message is not displayed");
            logger.info("Test case Passed.");
        }

        catch (Exception e)
        {
            logger.error("Test case Failed due to " + e);
        }

    }
}
