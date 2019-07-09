package pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import utils.TestManager;

public class MainPage extends PageObject {

    private final TestManager manager;

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
    }

    @Step
    public String getPageUrl() {
        return this.getDriver().getCurrentUrl();
    }

    @Step
    public void checkMainPageDisplaying() {
        manager.waiter(this.getDriver()).waitUntilElementIsVisible(wordInputField);
        manager.waiter(this.getDriver()).waitUntilElementIsVisible(transcriptionInputField);
        manager.waiter(this.getDriver()).waitUntilElementIsVisible(translationInputField);
        manager.waiter(this.getDriver()).waitUntilElementIsVisible(exampleInputField);
        manager.waiter(this.getDriver()).waitUntilElementIsVisible(exampleTranslationInputField);
        manager.waiter(this.getDriver()).waitUntilElementIsClickable(autofillButton);
        manager.waiter(this.getDriver()).waitUntilElementIsClickable(submitWordAddingButton);
        manager.waiter(this.getDriver()).waitUntilElementIsClickable(logoutButton);
    }

    @Step
    public void pressLogoutButton() {
        manager.waiter(this.getDriver()).waitUntilElementIsClickable(logoutButton);
        logoutButton.click();
    }

    @Step
    public void enterEnglishWord(String word) {
        manager.waiter(this.getDriver()).waitUntilElementIsClickable(wordInputField);
        wordInputField.clear();
        wordInputField.sendKeys(word);
    }

    @Step
    public void enterTranscription(String transcription) {
        manager.waiter(this.getDriver()).waitUntilElementIsClickable(transcriptionInputField);
        transcriptionInputField.clear();
        transcriptionInputField.sendKeys(transcription);
    }

    @Step
    public void enterRussianTranslation(String russianTranslation) {
        manager.waiter(this.getDriver()).waitUntilElementIsClickable(translationInputField);
        transcriptionInputField.clear();
        translationInputField.sendKeys(russianTranslation);
    }

    @Step
    public void enterEnglishExample(String englishExample) {
        manager.waiter(this.getDriver()).waitUntilElementIsClickable(exampleInputField);
        exampleInputField.clear();
        exampleInputField.sendKeys(englishExample);
    }

    @Step
    public void enterExampleRussianTranslation(String exampleRussianTranslation) {
        manager.waiter(this.getDriver()).waitUntilElementIsClickable(exampleTranslationInputField);
        exampleTranslationInputField.clear();
        exampleTranslationInputField.sendKeys(exampleRussianTranslation);
    }

    @Step
    public void pressAddWordButton() {
        manager.waiter(this.getDriver()).waitUntilElementIsClickable(submitWordAddingButton);
        submitWordAddingButton.click();
    }
}
