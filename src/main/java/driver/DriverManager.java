package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public final class DriverManager {

   // static WebDriver driver = null;

    private DriverManager() {
    }

    private static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static WebDriver getDr() {
        return dr.get();
    }

    public static void setDr(WebDriver driverRef) {
        if (Objects.nonNull(driverRef)) {
            dr.set(driverRef);
        }
    }

    public static void removeDriver() {
            dr.remove();

    }
}
