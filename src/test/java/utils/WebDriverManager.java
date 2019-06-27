package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import net.thucydides.core.webdriver.DriverSource;

public class WebDriverManager implements DriverSource {

    @Override
    public WebDriver newDriver() {
        WebDriver driver = null;
        String browser;
        browser = System.getProperty("browser", "chrome");
        switch (browser) {
            case ("chrome"):
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case ("firefox"):
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case ("ie"):
                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}