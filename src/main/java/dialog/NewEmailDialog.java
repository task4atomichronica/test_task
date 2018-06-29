package dialog;

import base.BaseDialog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.HomePage;

/**
 * NewEmailDialog representing new email creation dialog
 */
public class NewEmailDialog extends BaseDialog {

    /* Element identifiers */
    private static final By TOFIELDBY = By.cssSelector("textarea[role='combobox']");
    private static final By SUBJECTFIELDBY = By.cssSelector("[name='subjectbox']");
    private static final By BODYFIELDBY = By.cssSelector("div[role='textbox']");
    private static final By SENDBUTTONBY = By.cssSelector("[role='button'][aria-label^='Send']");

    public NewEmailDialog(WebDriver driver) {
        super(driver);
    }

    /**
     * Sets 'To' field
     *
     * @param email
     *            string representing email to be used
     */
    public void setTo(String email) {
        driver.findElement(TOFIELDBY).sendKeys(email);
    }

    /**
     * Sets 'Subject' field
     *
     * @param subj
     *            string representing subject to be entered
     */
    public void setSubject(String subj) {
        driver.findElement(SUBJECTFIELDBY).sendKeys(subj);
    }

    /**
     * Sets email body
     *
     * @param body
     *            string representing body to be entered
     */
    public void setBody(String body) {
        driver.findElement(BODYFIELDBY).sendKeys(body);
    }

    /**
     * Sends new email
     *
     * @return HomePage - the resulting page
     */
    public HomePage sendEmail() {
        driver.findElement(SENDBUTTONBY).click();
        return new HomePage(driver);
    }
}
