package pages;

import net.serenitybdd.core.pages.PageObject;
import utils.WebElementWaiter;


public class WebDriverPage extends PageObject {

    WebElementWaiter waiter;

    public WebDriverPage() {
        waiter = new WebElementWaiter(this.getDriver());
    }

    public void navigateToSite(String url) {
        this.getDriver().navigate().to(url);
    }
}
