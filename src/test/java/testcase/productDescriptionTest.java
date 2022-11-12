package testcase;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import pages.CartPage;
import pages.LoginPage;
import org.testng.annotations.Test;
import pages.ProductItemPage;
import pages.ProductPage;

@Test(priority = 3)
public class productDescriptionTest extends BaseTest {

    ProductItemPage productItemPage = new ProductItemPage();
    CartPage cartPage = new CartPage();
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();

    public void productDescription() {

        String expectedDescText = "unequaled laptop and tablet";
        String actualProductDescription =
                loginPage
                        .enterUsername("standard_user")
                        .enterPassword("secret_sauce")
                        .submitLogin()
                        .clickProduct()
                        .checkProductDescription();

        Assert.assertTrue(actualProductDescription.contains((expectedDescText)));
        test.log(Status.INFO,"End of Product Description ");
    }
}
