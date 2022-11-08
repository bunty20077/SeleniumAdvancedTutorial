package driver;

import io.github.bonigarcia.wdm.managers.SafariDriverManager;
import org.openqa.selenium.WebDriver;


public class DriverManagerFactory {

    private static WebDriver driver;
    protected static DriverManager driverManager = null;
    /*
     * Factory method for getting driver and browsers
     * WebDriverManager is an open-source Java library that carries out the management
     * (i.e., download, setup, and maintenance) of the drivers required by Selenium WebDriver.
     */


    public static DriverManager getManger(String browserName) {

        switch (browserName) {
            case "chrome":
                driverManager = new ChromeDriverManager();
                break;
            case "firefox":
                driverManager = new FirefoxDriverManager();
                break;
            case "edge":
                driverManager = new EdgeDriverManager();
                break;
        }
        return driverManager;
    }


    public static void closeAllDriver() {
        driverManager.quitDriver();
    }
}