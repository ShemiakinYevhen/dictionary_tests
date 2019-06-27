package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import net.serenitybdd.core.pages.PageObject;
import utils.WebElementWaiter;

public class LoginPage extends PageObject {

    private WebElementWaiter waiter;

    @FindBy(how = How.XPATH, using = "//h1[text()='Please sign in']")
    private WebElement loginPageHeader;

    @FindBy(how = How.ID, using = "inputEmail")
    private WebElement userNameInputField;

    @FindBy(how = How.ID, using = "inputPassword")
    private WebElement passwordInputField;

    @FindBy(how = How.XPATH, using = "//button[text()='Sign in']")
    private WebElement submitLoginButton;

    public LoginPage() {
        waiter = new WebElementWaiter(this.getDriver());
    }

    public String getPageUrl() {
        return this.getDriver().getCurrentUrl();
    }

    public void checkLoginPageDisplaying() {
        waiter.waitUntilElementIsVisible(loginPageHeader);
        waiter.waitUntilElementIsVisible(userNameInputField);
        waiter.waitUntilElementIsVisible(passwordInputField);
        waiter.waitUntilElementIsClickable(submitLoginButton);
    }

    public void enterUserName(String userName) {
        waiter.waitUntilElementIsClickable(userNameInputField);
        userNameInputField.clear();
        userNameInputField.sendKeys(userName);
    }

    public void enterUserPassword(String userPassword) {
        waiter.waitUntilElementIsClickable(passwordInputField);
        passwordInputField.clear();
        passwordInputField.sendKeys(userPassword);
    }

    public void pressSignInButton() {
        waiter.waitUntilElementIsClickable(submitLoginButton);
        submitLoginButton.click();
    }
}
