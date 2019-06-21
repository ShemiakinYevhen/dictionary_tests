package stepdefs;

import cucumber.api.java.en.When;
import pages.WebDriverPage;

public class WebDriverStepDefs {

    private WebDriverPage webDriverPage =  new WebDriverPage();

    @When("User navigates to site")
    public void navigateToSite() {
        webDriverPage.navigateToSite();
    }
}
