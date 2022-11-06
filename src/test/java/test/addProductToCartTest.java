package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import org.testng.annotations.Test;
import java.io.IOException;

public class addProductToCartTest extends BaseTest{

    @Test
    public void sampleTest001() throws IOException, InterruptedException {


        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage ;
        launchWebsiteTest launchWebsiteTest = new launchWebsiteTest(driver);

        launchWebsiteTest.launchUrl();
        loginPage.enterUsername("standard_user")
                 .enterPassword("secret_sauce");
        homePage = loginPage.submitLogin();

        String actualText = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(actualText,"PRODUCTS");
        homePage.clickProduct();
        String productDesc = driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[2]")).getText();
        System.out.println(productDesc);




    }
}
