package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.safari.SafariDriverService;

import java.io.IOException;

public class SafariDriverManager extends DriverManager{

    private SafariDriverService chService;

    @Override
    protected void startService() throws IOException {

        chService = new SafariDriverService.Builder()
                .usingAnyFreePort()
                .build();
        chService.start();
    }

    @Override
    protected void stopService() {
        if (null != chService && chService.isRunning())
            chService.stop();
    }

    @Override
    protected void createDriver() {
        WebDriverManager.safaridriver().setup();
        driver = new ChromeDriver();
    }
}
