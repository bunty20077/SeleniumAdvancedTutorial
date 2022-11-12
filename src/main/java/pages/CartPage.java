package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends BasePage{

    private final By itemCountLocator = By.className("shopping_cart_badge");

    public String verifyItemCountInCart(){

       String itemCount = getTextElement(itemCountLocator);;
       return itemCount;
    }


}
