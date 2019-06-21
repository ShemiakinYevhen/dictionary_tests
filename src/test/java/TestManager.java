import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class TestManager {

    private WebDriver driver;
    private final Properties properties;
    private WebElementWaiter waiter;

    public TestManager() {
        properties = PropertiesReader.getProperties();
        String browser;
        try {
            browser = System.getProperty("browser");
        } catch (NullPointerException ex) {
            browser = "chrome";
        }
        switch(browser) {
            case("chrome"):
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case("opera"):
                System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + "\\resources\\drivers\\operadriver.exe");
                driver = new OperaDriver();
                break;
            case("ie"):
                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\resources\\drivers\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
            case("firefox"):
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\resources\\drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
        }
    }

    public WebElementWaiter waiter() {
        if (waiter == null) {
            waiter = new WebElementWaiter(driver);
        }
        return waiter;
    }
}
