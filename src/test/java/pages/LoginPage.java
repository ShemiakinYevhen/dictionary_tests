package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.TestManager;

public class LoginPage {

    private TestManager manager;

    @FindBy(how = How.XPATH, using = "//h1[text()='Please sign in']")
    private WebElement loginPageHeader;

    @FindBy(how = How.ID, using = "inputEmail")
    private WebElement userNameInputField;

    @FindBy(how = How.ID, using = "inputPassword")
    private WebElement passwordInputField;

    @FindBy(how = How.XPATH, using = "//button[text()='Sign in']")
    private WebElement submitLoginButton;

    public LoginPage() {
        manager = new TestManager();
        PageFactory.initElements(manager.driver(), this);
    }

    public void checkLoginPageUrl() {
        manager.driver().getCurrentUrl().equals(manager.properties().getProperty("sute.url") + "/login");
    }

    public void checkLoginPageDisplaying() {
        manager.waiter().waitUntilElementIsVisible(loginPageHeader);
        manager.waiter().waitUntilElementIsVisible(userNameInputField);
        manager.waiter().waitUntilElementIsVisible(passwordInputField);
        manager.waiter().waitUntilElementIsClickable(submitLoginButton);
    }

    public void enterUserName() {
        manager.waiter().waitUntilElementIsClickable(userNameInputField);
        userNameInputField.clear();
        userNameInputField.sendKeys(manager.properties().getProperty("user.name"));
    }

    public void enterUserPassword() {
        manager.waiter().waitUntilElementIsClickable(passwordInputField);
        passwordInputField.clear();
        passwordInputField.sendKeys(manager.properties().getProperty("user.password"));
    }

    public void pressSignInButton() {
        manager.waiter().waitUntilElementIsClickable(submitLoginButton);
        submitLoginButton.click();
    }
}
