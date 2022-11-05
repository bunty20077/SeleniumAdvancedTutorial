package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static WebDriver driver;
    /*
     * Factory method for getting driver and browsers
     * WebDriverManager is an open-source Java library that carries out the management
     * (i.e., download, setup, and maintenance) of the drivers required by Selenium WebDriver.
     */


    public static WebDriver getBrowser(String browserName) {

        String runMode = "LocalDesktop";

        if(runMode.equalsIgnoreCase("Docker")){
            switch (browserName) {
                case "Firefox":
                    if (driver == null) {
                        WebDriverManager.firefoxdriver().browserInDocker().create();
                        driver = new FirefoxDriver();
                    }
                    break;
                case "IE":
                    if (driver == null) {
                        WebDriverManager.iedriver().browserInDocker().create();
                        driver = new InternetExplorerDriver();
                    }
                    break;
                case "Chrome":
                    if (driver == null) {
                        WebDriverManager.chromedriver().browserInDocker().create();
                        driver = new ChromeDriver();
                    }
                    break;
            }
        }else if(runMode.equalsIgnoreCase("LocalDesktop")){
            switch (browserName) {
                case "Firefox":
                    if (driver == null) {
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                    }
                    break;
                case "IE":
                    if (driver == null) {
                        WebDriverManager.iedriver().setup();
                        driver = new InternetExplorerDriver();
                    }
                    break;
                case "Chrome":
                    if (driver == null) {
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                    }
                    break;
             }
        }else{
            System.out.println("RunMode is not Set");
        }
        return driver;
    }
    /*
     * CloseAllDriver is used to quit and close the driver instance.
     */
    public static void closeAllDriver() {
        driver.close();
        driver.quit();
    }
}