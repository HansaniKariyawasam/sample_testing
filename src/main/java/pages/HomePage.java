package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    //Locators
    private static final By ADD_TO_CART_FIRST_BUTTON_LOCATOR = By.id("add-to-cart-sauce-labs-backpack");
    private static final By REMOVE_FIRST_BUTTON_LOCATOR = By.id("remove-sauce-labs-backpack");
    private static final By SHOPPING_CART_BADGE_LOCATOR = By.className("shopping_cart_badge");

    //Methods
    public void addOneItemToCart(){
        clickElement(ADD_TO_CART_FIRST_BUTTON_LOCATOR);
    }

    public void removeOneItemFromCart(){
        clickElement(REMOVE_FIRST_BUTTON_LOCATOR);
    }

    public String getAvailableNoItemsInCart(){
        return getText(SHOPPING_CART_BADGE_LOCATOR);
    }
}
