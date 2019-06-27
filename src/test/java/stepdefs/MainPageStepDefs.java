package stepdefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.MainPage;

public class MainPageStepDefs {

    private MainPage mainPage = new MainPage();

    @Then("Main page is displayed")
    public void checkMainPageDisplaying() {
        mainPage.getPageUrl();
        mainPage.checkMainPageDisplaying();
    }

    @When("User presses logout button")
    public void pressLogoutButton() {
        mainPage.pressLogoutButton();
    }
}
