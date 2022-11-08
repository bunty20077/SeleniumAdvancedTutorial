package driver;

import java.util.Objects;

public final class Driver {

    private Driver() {
    }

    static String url = "https://www.saucedemo.com/";

    public static void setupDriver() {
        if (Objects.isNull(DriverManager.getDr())) {
            try {
                DriverManager.setDr(DriverFactory.getDriver());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            DriverManager.getDr().get(url);
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDr())) {
            try {
                DriverManager.getDr().quit();
                DriverManager.removeDriver();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
