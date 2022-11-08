package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;

import java.io.IOException;

public class EdgeDriverManager extends DriverManager{

    private EdgeDriverService chService;

    @Override
    protected void startService() throws IOException {
        chService = new EdgeDriverService.Builder()
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
        System.setProperty("webdriver.edge.driver", "/Users/sayantan.tarafdar/Desktop/Codebase/SeleniumAdvancedTutorial/src/test/resources/exec/msedgedriver");
        driver = new EdgeDriver();
    }
}