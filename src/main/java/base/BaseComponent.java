package base;

import org.openqa.selenium.WebDriver;

/**
 * BaseComponent class is used as base for each page component
 */
public class BaseComponent {

    protected WebDriver driver;

    public BaseComponent(WebDriver driver) {
        this.driver = driver;
    }
}
