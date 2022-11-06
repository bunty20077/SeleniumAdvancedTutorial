package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class launchWebsiteTest {

    WebDriver driver;
    private static String url = "https://www.saucedemo.com/";

    public launchWebsiteTest( WebDriver driver )
    {
        PageFactory.initElements( driver, this);
        this.driver = driver;
    }


    public void launchUrl(){

        driver.get(url);
    }
}
