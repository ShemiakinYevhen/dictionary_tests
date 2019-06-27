package stepdefs;

import static utils.PropertiesReader.properties;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.WebDriverPage;

public class WebDriverStepDefs {

    @Steps
    private WebDriverPage webDriverPage;

    @When("User navigates to site")
    public void navigateToSite() {
        webDriverPage.navigateToSite(properties().getProperty("site.url"));
    }
}
