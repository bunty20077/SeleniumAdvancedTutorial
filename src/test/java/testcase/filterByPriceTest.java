package testcase;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import java.util.List;


@Test(priority = 2)
public class filterByPriceTest extends BaseTest{

    ProductPage productPage = new ProductPage();
    LoginPage loginPage = new LoginPage();

    public void filterByPriceTest(){
       test.log(Status.INFO,"Start of FilterTest");
        loginPage.enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .submitLogin()
                .getInventoryPageTitle();

        List<String> actualList = productPage.filterByPrice("lohi")
                .checkfilteredItemByPrice();

        Assert.assertEquals(productPage.assertFlteredItemByPrice(),actualList);
        test.log(Status.INFO,"End of TC "+this.getClass().getCanonicalName());
    }
}
