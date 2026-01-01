package pages;

import com.microsoft.playwright.Page;
import locators.LoginPageLocators;

public class LoginPage {

    private Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public void navigate() {
        page.navigate("https://www.saucedemo.com/");
    }

    public void login(String username, String password) {
        page.fill(LoginPageLocators.USERNAME_INPUT, username);
        page.fill(LoginPageLocators.PASSWORD_INPUT, password);
        page.click(LoginPageLocators.LOGIN_BUTTON);
    }
    
    public boolean isLoginPageLoaded() {
        return page.isVisible(LoginPageLocators.LOGIN_BUTTON);
    }

}
