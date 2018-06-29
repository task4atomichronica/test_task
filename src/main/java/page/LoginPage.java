package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Waiters;

/**
 * LoginPage representing gmail login page
 */
public class LoginPage extends BasePage {

    /* Element identifiers */
    private static final By EMAILTEXTFIELDBY = By.cssSelector("[type = 'email']");
    private static final By PASSWORDTEXTFIELDBY = By.cssSelector("[type = 'password']");
    private static final By NEXTTOPASSWORDBUTTONBY = By.id("identifierNext");
    private static final By NEXTTOLOGINBUTTONBY = By.id("passwordNext");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Sets login
     *
     * @param login
     *          string representing login to be used
     *
     */
    public void setLogin(String login) {
        driver.findElement(EMAILTEXTFIELDBY).sendKeys(login);
    }

    /**
     * Submits login entry
     */
    public void submitEnteredEmail() {
        driver.findElement(NEXTTOPASSWORDBUTTONBY).click();
        Waiters.getWaiter(driver, 10).until(ExpectedConditions.
                visibilityOf(driver.findElement(NEXTTOLOGINBUTTONBY)));
    }

    /**
     * Sets password
     *
     * @param password
     *              string representing password to be used
     */
    public void setPassword(String password) {
        driver.findElement(PASSWORDTEXTFIELDBY).sendKeys(password);
    }

    /**
     * Submits password entry
     *
     * @return HomePage - the resulting page
     */
    public HomePage submitEnteredPassword() {
        driver.findElement(NEXTTOLOGINBUTTONBY).click();
        Waiters.getWaiter(driver, 10).until(ExpectedConditions.
                invisibilityOf(driver.findElement(NEXTTOLOGINBUTTONBY)));
        return new HomePage(driver);
    }
}
