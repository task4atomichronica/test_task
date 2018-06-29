import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.EmailUtils;
import utils.SettingsHelper;
import utils.StringUtils;

/**
 * GmailTests contains test to verify emails delivery
 */
public class GmailTests extends BaseTest {

    @Test(groups = {"gmail"})
    public void emailSendingTest() {

        /* Test data*/
        final String SUBJECT = "Test subj";
        final String BODY = "Hello, world!";
        final String LOGIN = SettingsHelper.getLogin();
        final String PASS = SettingsHelper.getPass();
        final String FOLDER = SettingsHelper.getFolder();

        /* Test steps */
        mailServeces.login(LOGIN, PASS);
        mailServeces.sendEmail(LOGIN, SUBJECT, BODY);
        Assert.assertEquals(StringUtils.removeHTMLTags(EmailUtils.getEmailBody(FOLDER, LOGIN)), BODY);
    }
}
