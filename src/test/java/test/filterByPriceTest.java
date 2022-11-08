package test;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class filterByPriceTest extends BaseTest{


    ProductPage productPage = new ProductPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void filterByPriceTest(){

        loginPage.enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .submitLogin()
                .getInventoryPageTitle();

        productPage.filterByPrice("lohi");


    }


}
