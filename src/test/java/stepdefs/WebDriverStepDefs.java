package stepdefs;

import static utils.PropertiesReader.properties;

import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import pages.WebDriverPage;

public class WebDriverStepDefs {

    private WebDriverPage webDriverPage;

    @Before
    public void setUp() {
        webDriverPage = new WebDriverPage();
    }

    @When("User navigates to site")
    public void navigateToSite() {
        webDriverPage.navigateToSite(properties().getProperty("site.url"));
    }
}
