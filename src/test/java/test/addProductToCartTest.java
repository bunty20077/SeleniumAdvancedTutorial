package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.loginPage;
import utilities.DriverFactory;
import org.testng.annotations.Test;

public class addProductToCartTest {

    @Test
    public void sampleTest001()
    {
        WebDriver driver = DriverFactory.getBrowser("Chrome");
        loginPage loginPage = new loginPage(driver);
        driver.get("https://www.saucedemo.com/");

        loginPage.enterLoginDetails("standard_user","secret_sauce");

        String actualText = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(actualText,"PRODUCTS");
    }
}
