package tests;

import base.BaseTest;
import config.TestData;
import constants.ProductConstants;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SauceDemoE2ETest extends BaseTest {

    private List<String> selectedProducts;

    @Test
    @Order(1)
    void shouldLoadLoginPage() {
        loginPage.navigate();
        assertTrue(loginPage.isLoginPageLoaded(),
                "Login page not loaded");
        test.pass("Login page loaded successfully");
    }

    @Test
    @Order(2)
    void shouldLoginSuccessfully() {
        loginPage.login(TestData.USERNAME, TestData.PASSWORD);
        assertTrue(inventoryPage.isInventoryPageLoaded(),
                "Login failed");
        test.pass("User logged in successfully");
    }

    @Test
    @Order(3)
    void shouldAddThreeProductsToCart() {

        selectedProducts = new ArrayList<>(ProductConstants.PRODUCTS);
        test.info("Selected products: " + selectedProducts);

        for (String product : selectedProducts) {
            inventoryPage.addProductToCartByName(product);
        }

        assertEquals(3, inventoryPage.getCartItemCount(),
                "Cart count mismatch");
        test.pass("Three products added to cart");
    }

    @Test
    @Order(4)
    void shouldProceedToCheckout() {
        inventoryPage.goToCart();
        assertTrue(cartPage.isCartPageLoaded(),
                "Cart page not loaded");

        cartPage.proceedToCheckout();
        assertTrue(checkoutPage.isCheckoutPageLoaded(),
                "Checkout page not loaded");

        test.pass("Checkout initiated successfully");
    }

    @Test
    @Order(5)
    void shouldCompleteOrderSuccessfully() {
        checkoutPage.enterUserDetails(
                TestData.FIRST_NAME,
                TestData.LAST_NAME,
                TestData.ZIP_CODE
        );

        checkoutPage.finishCheckout();

        assertTrue(checkoutCompletePage.isOrderComplete(),
                "Order completion failed");

        assertEquals(
                "THANK YOU FOR YOUR ORDER",
                checkoutCompletePage.getSuccessMessage()
        );

        test.pass("Order completed successfully");
    }
}
