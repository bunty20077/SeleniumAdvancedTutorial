package testcase;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import reportmanager.ExtentTestManager;

@Test(priority = 1,groups = {"SanityTest"})
public class loginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();

    public void sampleTest001() {

        test.log(Status.INFO, "Start of Login Test ");
        String actualInventoryPageTitle =
                loginPage
                        .enterUsername("standard_user")
                        .enterPassword("secret_sauce")
                        .submitLogin()
                        .getInventoryPageTitle();
        test.log(Status.INFO, "Assert");
        Assert.assertEquals(actualInventoryPageTitle, "PRO", "Title didnot match.TC failed");

    }
}
