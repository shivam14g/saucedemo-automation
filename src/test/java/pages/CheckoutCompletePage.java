package pages;

import com.microsoft.playwright.Page;
import locators.CheckoutCompleteLocators;

public class CheckoutCompletePage {

    private final Page page;

    public CheckoutCompletePage(Page page) {
        this.page = page;
    }

    // Validate order completion
    public boolean isOrderComplete() {
        return page.isVisible(CheckoutCompleteLocators.SUCCESS_HEADER);
    }

    // Fetch success message text
    public String getSuccessMessage() {
        return page.textContent(CheckoutCompleteLocators.SUCCESS_HEADER);
    }
}
