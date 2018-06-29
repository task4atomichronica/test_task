package services;

import base.BaseService;
import dialog.NewEmailDialog;
import org.openqa.selenium.WebDriver;
import page.HomePage;
import page.LoginPage;

/**
 * MailServeces class contains service methods to use as complete buisness steps
 */
public class MailServeces extends BaseService {

    /* Pages */
    private final LoginPage loginPage;
    private final HomePage homePage;

    public MailServeces(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    /**
     * Performs login operation
     *
     * @param login
     *          login to be used
     *
     * @param password
     *          password to be used
     *
     * @return HomePage - the resulting page
     */
    public HomePage login(String login, String password) {
        loginPage.setLogin(login);
        loginPage.submitEnteredEmail();
        loginPage.setPassword(password);
        return loginPage.submitEnteredPassword();
    }

    /**
     * Performs ne wemail creation and sending to specified To recipient
     *
     * @param to
     *         email to be used as recipient
     *
     * @param subj
     *          email subject
     *
     * @param body
     *          email body
     *
     * @return HomePage - the resulting page
     */
    public HomePage sendEmail(String to, String subj, String body) {
        final NewEmailDialog newEmailDialog = homePage.navigationComponent.initiateNewEmailCreation();
        newEmailDialog.setTo(to);
        newEmailDialog.setSubject(subj);
        newEmailDialog.setBody(body);
        return newEmailDialog.sendEmail();
    }
}
