package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Waiters class is used to add web driver explicit wait in more fluent manner
 */
public class Waiters {

    public static WebDriverWait getWaiter(WebDriver driver, long timeOut) {
        return new WebDriverWait(driver, timeOut);
    }
}
