package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;

public class ChromeDriverManager extends DriverManager{

    private ChromeDriverService chService;

    @Override
    protected void startService() throws IOException {

        chService = new ChromeDriverService.Builder()
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
       // DesiredCapabilities capabilities = DesiredCapabilities.chrome();
       // ChromeOptions options = new ChromeOptions();
       // options.addArguments("test-type");
       // capabilities.setCapability(ChromeOptions.CAPABILITY, options);
       // driver = new ChromeDriver(chService, capabilities);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
}
