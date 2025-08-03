package Test_Cases;

import Pages.HomePage;
import org.testng.annotations.Test;

public class SanityTest extends BaseTestClass{

    @Test
    public void SanityCheck()
    {
        HomePage homePage = new HomePage(driver);
        homePage.LaunchApp();

    }
}
