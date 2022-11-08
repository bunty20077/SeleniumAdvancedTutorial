package test;

import pages.CartPage;
import pages.LoginPage;
import org.testng.annotations.Test;
import pages.ProductItemPage;
import pages.ProductPage;
import java.io.IOException;

public class addProductToCartTest extends BaseTest{

/*    LoginPage loginPage ;
    ProductPage productPage ;
    ProductItemPage productItemPage;
    CartPage cartPage;*/

    @Test
    public void sampleTest001() throws IOException, InterruptedException {

        LoginPage loginPage= new LoginPage(driver);
        loginPage.openUrl();
        loginPage.enterUsername("standard_user")
                 .enterPassword("secret_sauce");

        productPage = loginPage.submitLogin();
        productPage.isInventoryPage();

        productItemPage = productPage.clickProduct();
        productItemPage.checkProductDescription();

        cartPage = productItemPage.addtoCart();
        cartPage.verifyItemCountInCart();



    }
}
