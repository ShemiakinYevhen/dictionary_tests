package utils;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import cucumber.api.java.After;

public class TestManager {

    private static WebDriver driver;
    private final Properties properties;
    private WebElementWaiter waiter;

    public TestManager() {
        properties = PropertiesReader.getProperties();
    }

    public WebElementWaiter waiter() {
        if (waiter == null) {
            waiter = new WebElementWaiter(driver);
        }
        return waiter;
    }

    public Properties properties() {
        return properties;
    }

    public WebDriver driver() {
        if (driver == null) {
            String browser;
            browser = System.getProperty("browser");
            if (browser == null) {
                browser = "chrome";
            }
            switch(browser) {
                case("chrome"):
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
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
            driver.manage().window().maximize();
        }
        return driver;
    }

    @After
    public void tearDown() {
        driver().quit();
    }
}
