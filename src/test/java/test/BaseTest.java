package test;

import driver.DriverManager;
import driver.DriverManagerFactory;
import driver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseTest {


    DriverManager driverManager;
    WebDriver driver;


    @BeforeMethod
    public void preSetup() throws IOException {
        driverManager = DriverManagerFactory.getManger(DriverType.CHROME);
        driver = driverManager.getDriver();

    }

    @AfterMethod
    public void tearDown(){

        driverManager.quitDriver();

    }

}
