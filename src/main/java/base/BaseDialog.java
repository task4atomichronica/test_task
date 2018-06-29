package base;

import org.openqa.selenium.WebDriver;

/**
 * BaseDialog class is used as base for each dialog on the page
 */
public class BaseDialog {

    protected WebDriver driver;

    public BaseDialog(WebDriver driver) {
        this.driver = driver;
    }
}
