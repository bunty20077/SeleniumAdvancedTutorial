package testcase;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductItemPage;


@Test(priority = 4,groups = {"SmokeTest"})
public class addItemToCartTest extends BaseTest {

    ProductItemPage productItemPage = new ProductItemPage();
    CartPage cartPage = new CartPage();
    LoginPage loginPage = new LoginPage();


    public void addItemToCart() {

        loginPage
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .submitLogin();

        String itemCountInCart = productItemPage
                .addtoCart()
                .verifyItemCountInCart();
        Assert.assertEquals(itemCountInCart,"1");
        test.log(Status.INFO, "End of Product Description ");


    }
}
