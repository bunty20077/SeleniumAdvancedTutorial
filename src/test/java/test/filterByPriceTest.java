package test;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class filterByPriceTest extends BaseTest{

  /*  LoginPage loginPage ;
    ProductPage productPage ;*/

    @Test
    public void filterByPriceTest(){

        loginPage = new LoginPage(driver);
        loginPage.openUrl();
        loginPage.enterUsername("standard_user")
                .enterPassword("secret_sauce");

        productPage = loginPage.submitLogin();
        productPage.isInventoryPage();

        productPage.filterByPrice("lohi");


    }


}
