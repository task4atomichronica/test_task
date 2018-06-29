package base;

import org.openqa.selenium.WebDriver;

/**
 * BaseService class is used as base for each service
 */
public class BaseService {

    protected WebDriver driver;

    public BaseService(WebDriver driver) {
        this.driver = driver;
    }
}
