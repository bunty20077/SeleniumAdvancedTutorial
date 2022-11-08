package test;

import org.testng.Assert;
import pages.CartPage;
import pages.LoginPage;
import org.testng.annotations.Test;
import pages.ProductItemPage;
import pages.ProductPage;

import java.io.IOException;

public class addProductToCartTest extends BaseTest {


    ProductItemPage productItemPage = new ProductItemPage();
    CartPage cartPage = new CartPage();
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();

    @Test(priority = 1)
    public void sampleTest001() {

        String actualInventoryPageTitle =
                loginPage
                        .enterUsername("standard_user")
                        .enterPassword("secret_sauce")
                        .submitLogin()
                        .getInventoryPageTitle();
        Assert.assertEquals(actualInventoryPageTitle, "PRODUCTS", "Title didnot match.TC failed");

    }

    @Test(priority = 2)
    public void sampleTest002() {
        String expectedDescText = "unequaled laptop and tablet";
        String actualProductDescription =
                loginPage
                        .enterUsername("standard_user")
                        .enterPassword("secret_sauce")
                        .submitLogin()
                        .clickProduct()
                        .checkProductDescription();

        Assert.assertTrue(actualProductDescription.contains((expectedDescText)));

        // cartPage = productItemPage.addtoCart();
        // cartPage.verifyItemCountInCart();

    }

   /* @Test(priority=3)
    public void sampleTest003(){
        loginPage
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .submitLogin()
                .clickProduct();

    }*/

}
