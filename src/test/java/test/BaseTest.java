package test;

import driver.DriverManager;
import driver.DriverManagerFactory;
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

    DriverManager driverManager;
    WebDriver driver;
    //String BROWSER = System.getenv("browser");
    String BROWSER = "chrome";

    LoginPage loginPage ;
    ProductPage productPage ;
    ProductItemPage productItemPage;
    CartPage cartPage;

    @BeforeMethod
    public void preSetup() throws IOException {
        Logger logger = Logger.getLogger("log");
        System.out.println("Browser ::::: "+BROWSER);
        driverManager = DriverManagerFactory.getManger(BROWSER);
        driver = driverManager.getDriver();
    }

    @AfterMethod
    public void tearDown(){
        driverManager.quitDriver();
    }
}
