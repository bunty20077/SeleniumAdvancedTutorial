package driver;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class DriverFactory {



    /*
     * Factory method for getting driver and browsers
     * WebDriverManager is an open-source Java library that carries out the management
     * (i.e., download, setup, and maintenance) of the drivers required by Selenium WebDriver.
     */

    //Private Constructor so that not to inherit by other classes
    private DriverFactory(){

    }


    public static WebDriver getDriver() {
        String browserName = System.getProperty("browser");
        //String browserName = "chrome";
        WebDriver driver = null;
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
        return driver;
    }

}