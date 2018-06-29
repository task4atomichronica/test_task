package page;

import base.BasePage;
import component.NavigationComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * HomePage representing gmail home page displayed right after login
 */
public class HomePage extends BasePage {

    /* Components */
    public final NavigationComponent navigationComponent;

    public HomePage(WebDriver driver) {
        super(driver);
        navigationComponent = new NavigationComponent(driver);
    }
}
