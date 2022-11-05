package driver;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

public abstract class DriverManager {

    protected WebDriver driver;
    protected abstract void startService() throws IOException;
    protected abstract void stopService();
    protected abstract void createDriver();

    public void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }

    }

    public WebDriver getDriver() throws IOException {
        if (null == driver) {
            //startService();
            createDriver();
        }
        return driver;
    }
}
