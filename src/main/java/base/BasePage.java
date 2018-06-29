package base;

import org.openqa.selenium.WebDriver;

/**
 * BasePage class is used as base for each page
 */
public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
