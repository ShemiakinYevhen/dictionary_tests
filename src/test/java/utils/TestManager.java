package utils;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public class TestManager {

    private WebElementWaiter waiter;
    private SoftAssertions softAssertions;

    public TestManager() {
    }

    public WebElementWaiter waiter(WebDriver driver) {
        if (waiter == null) {
            waiter = new WebElementWaiter(driver);
        }
        return waiter;
    }

    public SoftAssertions softAssert() {
        if (softAssertions == null) {
            softAssertions = new SoftAssertions();
        }
        return softAssertions;
    }
}
