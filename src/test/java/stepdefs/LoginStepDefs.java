package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginPage;

public class LoginStepDefs {

    private LoginPage loginPage = new LoginPage();

    @Then("Login page is displayed")
    public void checkLoginPageDisplaying() {
        loginPage.checkLoginPageUrl();
        loginPage.checkLoginPageDisplaying();
    }

    @When("User enters user`s name")
    public void enterUserName() {
        loginPage.enterUserName();
    }

    @And("User enters password")
    public void enterPassword() {
        loginPage.enterUserPassword();
    }

    @And("User presses 'Sign in' button")
    public void pressSignInButton() {
        loginPage.pressSignInButton();
    }
}
