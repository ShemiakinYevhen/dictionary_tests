import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementWaiter {

    private static final int DEFAULT_WAIT_DURATION = 30;
    private static final int DEFAULT_SLEEP_DURATION = 1000;

    private final WebDriver driver;

    public WebElementWaiter(WebDriver webDriver) {
        driver = webDriver;
        driver.manage().timeouts();
    }

    public WebElement waitUntilElementIsVisible(WebElement targetElement) {
        try {
            return createWebDriverWait().until(visibilityOf(targetElement));
        } catch (Exception e) {
            throw new AssertionError("Element not found: " + targetElement);
        }
    }

    public WebElement waitUntilElementIsVisibleBy(By by) {
        try {
            return createWebDriverWait().until(visibilityOfElementLocated(by));
        } catch (Exception e) {
            throw new AssertionError("Element not found: " + by);
        }
    }

    public void waitUntilElementIsInvisibleBy(By by) {
        try {
            createWebDriverWait().until(invisibilityOfElementLocated(by));
        } catch (Exception e) {
            throw new AssertionError("Element is visible: " + by);
        }
    }

    public WebElement waitUntilElementIsClickable(WebElement targetElement) {
        try {
            return createWebDriverWait().until(elementToBeClickable(targetElement));
        } catch (Exception e) {
            throw new AssertionError("Element is not clickable: " + targetElement);
        }
    }

    private Wait<WebDriver> createWebDriverWait() {
        return new WebDriverWait(driver, DEFAULT_WAIT_DURATION, DEFAULT_SLEEP_DURATION).ignoring(StaleElementReferenceException.class, WebDriverException.class);
    }
}
