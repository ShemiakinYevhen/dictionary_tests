package utils;

import org.openqa.selenium.WebDriver;

public class TestManager {

    private WebElementWaiter waiter;

    public TestManager() {
    }

    public WebElementWaiter waiter(WebDriver driver) {
        if (waiter == null) {
            waiter = new WebElementWaiter(driver);
        }
        return waiter;
    }
}
