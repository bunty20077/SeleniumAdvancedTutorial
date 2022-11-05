package test;

import driver.DriverManager;
import driver.DriverType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.loginPage;
import driver.DriverManagerFactory;
import org.testng.annotations.Test;
import java.io.IOException;

public class addProductToCartTest extends BaseTest{

    @Test
    public void sampleTest001() throws IOException {


        loginPage loginPage = new loginPage(driver);
        driver.get("https://www.saucedemo.com/");

        loginPage.enterLoginDetails("standard_user","secret_sauce");

        String actualText = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(actualText,"PRODUCTS");


    }
}
