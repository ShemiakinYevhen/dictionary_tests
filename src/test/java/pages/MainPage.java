package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import net.serenitybdd.core.pages.PageObject;
import utils.WebElementWaiter;


public class MainPage extends PageObject {

    private WebElementWaiter waiter;

    @FindBy(how = How.ID, using = "word-input")
    private WebElement wordInputField;

    @FindBy(how = How.ID, using = "transcription-input")
    private WebElement transcriptionInputField;

    @FindBy(how = How.ID, using = "translation-input")
    private WebElement translationInputField;

    @FindBy(how = How.ID, using = "example-input")
    private WebElement exampleInputField;

    @FindBy(how = How.ID, using = "exampleTranslation-input")
    private WebElement exampleTranslationInputField;

    @FindBy(how = How.ID, using = "go-to-api-button")
    private WebElement autofillButton;

    @FindBy(how = How.XPATH, using = "//button[text()='Add word']")
    private WebElement submitWordAddingButton;

    @FindBy(how = How.ID, using = "logout-link")
    private WebElement logoutButton;

    public MainPage() {
        waiter = new WebElementWaiter(this.getDriver());
    }

    public String getPageUrl() {
        return this.getDriver().getCurrentUrl();
    }

    public void checkMainPageDisplaying() {
        waiter.waitUntilElementIsVisible(wordInputField);
        waiter.waitUntilElementIsVisible(transcriptionInputField);
        waiter.waitUntilElementIsVisible(translationInputField);
        waiter.waitUntilElementIsVisible(exampleInputField);
        waiter.waitUntilElementIsVisible(exampleTranslationInputField);
        waiter.waitUntilElementIsClickable(autofillButton);
        waiter.waitUntilElementIsClickable(submitWordAddingButton);
        waiter.waitUntilElementIsClickable(logoutButton);

    }

    public void pressLogoutButton() {
        waiter.waitUntilElementIsClickable(logoutButton);
        logoutButton.click();
    }
}
