package stepdefs;

import static utils.PropertiesReader.properties;

import org.testng.asserts.SoftAssert;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginPage;

public class LoginStepDefs {

    private LoginPage loginPage;
    private SoftAssert softAssert;

    @Before
    public void setUp() {
        loginPage = new LoginPage();
        softAssert = new SoftAssert();
    }

    @Then("Login page is displayed")
    public void checkLoginPageDisplaying() {
        softAssert.assertEquals(loginPage.getPageUrl(), properties().getProperty("site.url") + "/login");
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
}
