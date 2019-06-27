package pages;


import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import utils.TestManager;


public class WebDriverPage extends PageObject {

    private final TestManager manager;

    public WebDriverPage() {
        manager = new TestManager();
    }

    @Step
    public void navigateToSite(String url) {
        this.getDriver().manage().window().maximize();
        this.getDriver().get(url);
    }
}
