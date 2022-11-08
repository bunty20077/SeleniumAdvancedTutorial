package test;

import driver.Driver;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductItemPage;
import pages.ProductPage;

import java.io.IOException;
import java.util.logging.Logger;

public class BaseTest {



    // eto thik noy
    @BeforeMethod(alwaysRun = true)
    protected void preSetup() throws IOException {
        Logger logger = Logger.getLogger("log");
        System.out.println("::::  Browser ::::: ");
        Driver.setupDriver();

    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown() {
        Driver.quitDriver();
    }
}
