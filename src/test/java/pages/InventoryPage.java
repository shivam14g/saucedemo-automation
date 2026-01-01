package pages;

import com.microsoft.playwright.Page;
import locators.InventoryPageLocators;

public class InventoryPage {

    private final Page page;

    public InventoryPage(Page page) {
        this.page = page;
    }

    // Validate inventory page loaded
    public boolean isInventoryPageLoaded() {
        return page.url().contains("inventory");
    }

    // Add product to cart by product name
    public void addProductToCartByName(String productName) {
        page.locator(
                "//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button"
        ).click();
    }

    // Get cart item count from cart badge
    public int getCartItemCount() {
        if (page.isVisible(InventoryPageLocators.CART_BADGE)) {
            String count = page.textContent(InventoryPageLocators.CART_BADGE);
            return Integer.parseInt(count.trim());
        }
        return 0;
    }

    // Navigate to cart page
    public void goToCart() {
        page.click(InventoryPageLocators.CART_ICON);
    }
}
