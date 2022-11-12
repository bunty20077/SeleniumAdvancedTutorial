package driver;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public final class DriverFactory {


    private static String username = "XXXXXXX";
    private static String accesskey = "XXXXXXxxxxxXXXXXXxxxxxxXXXX";
    private static String gridURL = "@hub.lambdatest.com/wd/hub";

    /*
     * Factory method for getting driver and browsers
     * WebDriverManager is an open-source Java library that carries out the management
     * (i.e., download, setup, and maintenance) of the drivers required by Selenium WebDriver.
     */

    //Private Constructor so that not to inherit by other classes
    private DriverFactory() {

    }


    public static WebDriver getDriver() {
        String browserName = System.getProperty("browser");
        String service = System.getProperty("service");

        if (browserName == null || service == null) {
            browserName = "chrome";
            service = "local";
        }

        WebDriver driver = null;
        if (service.equalsIgnoreCase("local")) {
            switch (browserName) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    System.out.println("I am at FF");
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    System.out.println("I am at Edge");
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
            }
        } else if (service.equalsIgnoreCase("docker")) {

        } else if (service.equalsIgnoreCase("cloud")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "chrome");
            // capabilities.setCapability("version", "70.0");
            capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get the any available one
            capabilities.setCapability("build", "LambdaTestSampleApp");
            capabilities.setCapability("name", "LambdaTestJavaSample");
            try {
                driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
            } catch (MalformedURLException e) {
                System.out.println("Invalid grid URL");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return driver;
    }

}