package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class FirefoxDriverManager extends DriverManager{


    @Override
    protected void startService() throws IOException {

    }

    @Override
    protected void stopService() {

    }

    @Override
    protected void createDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
}
