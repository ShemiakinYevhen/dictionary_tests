package stepdefs;

import static org.junit.Assert.assertEquals;
import static utils.PropertiesReader.properties;

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
}
