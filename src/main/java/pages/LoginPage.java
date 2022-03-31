package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends BasePage {
    //Locators
    private static final By USERNAME_INPUT_LOCATOR = By.id("user-name");
    private static final By PASSWORD_INPUT_LOCATOR = By.id("password");
    private static final By LOGIN_BUTTON_LOCATOR = By.id("login-button");
    private static final By HOME_PAGE_LOCATOR = By.className("peek");
    private static final By ERROR_MESSAGE_LOCATOR = By.className("error-message-container");

    //Methods
    private void isLoginPageLoaded(){
        Assert.assertTrue(isVisible(USERNAME_INPUT_LOCATOR));
    }

    private void enterUsername(String username){
        typeText(USERNAME_INPUT_LOCATOR,username);
    }

    private void enterPassword(String password){
        typeText(PASSWORD_INPUT_LOCATOR,password);
    }

    private void clickLogin(){
        clickElement(LOGIN_BUTTON_LOCATOR);
    }

    public void loginAsUser(String username, String password) {
        isLoginPageLoaded();
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public boolean isHomePageLoaded(){
        return isVisible(HOME_PAGE_LOCATOR);
    }

    public String getErrorMessage(){
        return getText(ERROR_MESSAGE_LOCATOR);
    }
}
