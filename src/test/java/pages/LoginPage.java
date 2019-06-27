package pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import utils.TestManager;

public class LoginPage extends PageObject {

    private final TestManager manager;

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
    }

    @Step
    public String getPageUrl() {
        return this.getDriver().getCurrentUrl();
    }

    @Step
    public void checkLoginPageDisplaying() {
        manager.waiter(this.getDriver()).waitUntilElementIsVisible(loginPageHeader);
        manager.waiter(this.getDriver()).waitUntilElementIsVisible(userNameInputField);
        manager.waiter(this.getDriver()).waitUntilElementIsVisible(passwordInputField);
        manager.waiter(this.getDriver()).waitUntilElementIsClickable(submitLoginButton);
    }

    @Step
    public void enterUserName(String userName) {
        manager.waiter(this.getDriver()).waitUntilElementIsClickable(userNameInputField);
        userNameInputField.clear();
        userNameInputField.sendKeys(userName);
    }

    @Step
    public void enterUserPassword(String userPassword) {
        manager.waiter(this.getDriver()).waitUntilElementIsClickable(passwordInputField);
        passwordInputField.clear();
        passwordInputField.sendKeys(userPassword);
    }

    @Step
    public void pressSignInButton() {
        manager.waiter(this.getDriver()).waitUntilElementIsClickable(submitLoginButton);
        submitLoginButton.click();
    }
}
