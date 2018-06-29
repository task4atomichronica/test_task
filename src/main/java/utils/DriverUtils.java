package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * DriveUtils is used to initialize Web Driver
 */
public class DriverUtils {

    private static DriverUtils instance = new DriverUtils();

    private DriverUtils() {}

    public static DriverUtils getInstance() {
        return instance;
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() {

        @Override
        protected WebDriver initialValue() {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            return new ChromeDriver();
//            String browser = System.getProperty("browser").toLowerCase();
//            switch (browser) {
//                case "chrome":
//                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//                    return new ChromeDriver();
//                case "firefox":
//                default:
//                    System.setProperty("webdriver.gecko.driver", "src/main/recources/geckodriverS.exe");
//                    return new FirefoxDriver();
//            }
        }
    };

    public WebDriver getDriver() {
        return driver.get();
    }

    public void removeDriver() {
        driver.get().quit();
        driver.remove();
    }
}
