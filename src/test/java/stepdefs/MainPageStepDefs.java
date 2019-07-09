package stepdefs;

import static org.junit.Assert.assertEquals;
import static utils.PropertiesReader.properties;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.MainPage;

public class MainPageStepDefs {

    @Steps
    private MainPage mainPage;

    @Then("Main page is displayed")
    public void checkMainPageDisplaying() {
        mainPage.checkMainPageDisplaying();
    }

    @When("User presses logout button")
    public void pressLogoutButton() {
        mainPage.pressLogoutButton();
    }

    @Then("User is on Main page")
    public void checkCurrentPageHaveMainPageURL() {
        assertEquals(mainPage.getPageUrl(), properties().getProperty("site.url") + "/dictionary");
    }

    @When("^User enters (.*) english word$")
    public void enterEnglishWord(String word) {
        mainPage.enterEnglishWord(word);
    }

    @And("^User enters (.*) transcription$")
    public void enterTranscription(String transcription) {
        mainPage.enterTranscription(transcription);
    }

    @And("^User enters (.*) russian translation$")
    public void enterRussianTranslation(String russianTranslation) {
        mainPage.enterRussianTranslation(russianTranslation);
    }

    @And("^User enters (.*) example on english$")
    public void enterEnglishExample(String englishExample) {
        mainPage.enterEnglishExample(englishExample);
    }

    @And("^User enters (.*) example`s translation in russian$")
    public void enterExampleRussianTranslation(String exampleRussianTranslation) {
        mainPage.enterExampleRussianTranslation(exampleRussianTranslation);
    }

    @And("^User presses 'Add word' button$")
    public void pressAddWordButton() {
        mainPage.pressAddWordButton();
    }

    @Then("^(.*) word with (.*), (.*), (.*) and (.*) is displayed as first word in list of words$")
    public void checkThatWordIsDisplayedInList(String englishWord, String transcription, String translation, String example, String exampleTranslation) {

    }
}
