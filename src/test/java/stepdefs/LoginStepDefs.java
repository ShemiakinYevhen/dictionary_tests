package stepdefs;

import static org.junit.Assert.assertEquals;
import static utils.PropertiesReader.properties;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.LoginPage;

public class LoginStepDefs {

    @Steps
    private LoginPage loginPage;

    @Then("Login page is displayed")
    public void checkLoginPageDisplaying() {
        loginPage.checkLoginPageDisplaying();
    }

    @When("User enters user`s name")
    public void enterUserName() {
        loginPage.enterUserName(properties().getProperty("user.name"));
    }

    @And("User enters password")
    public void enterPassword() {
        loginPage.enterUserPassword(properties().getProperty("user.password"));
    }

    @And("User presses 'Sign in' button")
    public void pressSignInButton() {
        loginPage.pressSignInButton();
    }

    @Then("User is on Login page")
    public void checkCurrentPageHaveLoginPageURL() {
        assertEquals(loginPage.getPageUrl(), properties().getProperty("site.url") + "/login");
    }
}
