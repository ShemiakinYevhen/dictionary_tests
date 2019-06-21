package pages;

import utils.TestManager;

public class WebDriverPage {

    private TestManager manager;

    public WebDriverPage() {
        manager = new TestManager();
    }

    public void navigateToSite() {
        manager.driver().navigate().to(manager.properties().getProperty("site.url"));
    }
}
