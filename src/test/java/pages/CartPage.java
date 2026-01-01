package pages;

import base.BasePage;
import com.microsoft.playwright.Page;
import locators.CartPageLocators;

public class CartPage extends BasePage {

    public CartPage(Page page) {
        super(page);
    }

    public void proceedToCheckout() {
        page.click(CartPageLocators.CHECKOUT_BUTTON);
    }
    
    public boolean isCartPageLoaded() {
        return page.url().contains("cart");
    }

}
