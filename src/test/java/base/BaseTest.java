package base;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import pages.*;
import reporting.ExtentManager;
import com.aventstack.extentreports.ExtentTest;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected ExtentTest test;

    // Page Objects
    protected LoginPage loginPage;
    protected InventoryPage inventoryPage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;
    protected CheckoutCompletePage checkoutCompletePage;

    @BeforeAll
    void setupClass() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );

        context = browser.newContext();
        page = context.newPage();

        // Initialize Page Objects ONCE per test class
        loginPage = new LoginPage(page);
        inventoryPage = new InventoryPage(page);
        cartPage = new CartPage(page);
        checkoutPage = new CheckoutPage(page);
        checkoutCompletePage = new CheckoutCompletePage(page);

        ExtentManager.initReport();
    }

    @BeforeEach
    void setupTest(TestInfo testInfo) {
        test = ExtentManager.createTest(testInfo.getDisplayName());
    }

    @AfterAll
    void tearDownClass() {
        context.close();
        browser.close();
        playwright.close();
        ExtentManager.flushReport();
    }
}
