
package pages;

import base.BasePage;
import com.microsoft.playwright.Page;
import locators.CheckoutPageLocators;

public class CheckoutPage extends BasePage {

    public CheckoutPage(Page page) {
        super(page);
    }

    public void enterUserDetails(String firstName, String lastName, String postalCode) {
        page.fill(CheckoutPageLocators.FIRST_NAME_INPUT, firstName);
        page.fill(CheckoutPageLocators.LAST_NAME_INPUT, lastName);
        page.fill(CheckoutPageLocators.POSTAL_CODE_INPUT, postalCode);
        page.click(CheckoutPageLocators.CONTINUE_BUTTON);
    }

    public void finishCheckout() {
        page.click(CheckoutPageLocators.FINISH_BUTTON);
    }
    
    public boolean isCheckoutPageLoaded() {
        return page.url().contains("checkout-step-one");
    }

}
