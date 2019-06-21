package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.reporters.jq.Main;

import utils.TestManager;

public class MainPage {

    private TestManager manager;

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
        manager = new TestManager();
        PageFactory.initElements(manager.driver(), this);
    }

    public void checkMainPageUrl() {
        manager.driver().getCurrentUrl().equals(manager.properties().getProperty("sute.url") + "/login");
    }

    public void checkMainPageDisplaying() {
        manager.waiter().waitUntilElementIsVisible(wordInputField);
        manager.waiter().waitUntilElementIsVisible(transcriptionInputField);
        manager.waiter().waitUntilElementIsVisible(translationInputField);
        manager.waiter().waitUntilElementIsVisible(exampleInputField);
        manager.waiter().waitUntilElementIsVisible(exampleTranslationInputField);
        manager.waiter().waitUntilElementIsClickable(autofillButton);
        manager.waiter().waitUntilElementIsClickable(submitWordAddingButton);
        manager.waiter().waitUntilElementIsClickable(logoutButton);

    }

    public void pressLogoutButton() {
        manager.waiter().waitUntilElementIsClickable(logoutButton);
        logoutButton.click();
    }
}
