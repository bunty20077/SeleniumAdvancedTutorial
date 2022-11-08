package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By itemCountLocator = By.className("shopping_cart_badge");

    public void verifyItemCountInCart(){
       String itemCount = getTextElement(itemCountLocator);;
       System.out.println("Number of item in Cart is "+itemCount);
       Assert.assertEquals(itemCount,"1");
    }


}
