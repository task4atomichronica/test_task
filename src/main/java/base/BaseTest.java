package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.LoginPage;
import services.MailServeces;
import utils.DriverUtils;

import java.util.concurrent.TimeUnit;

/**
 * BaseTest contains logic common for all tests
 */
public class BaseTest {

    protected LoginPage loginPage;
    protected MailServeces mailServeces;
    private static final String URL = "https://gmail.com";

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        WebDriver driver = DriverUtils.getInstance().getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
        loginPage = new LoginPage(driver);

        initializeServices(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        DriverUtils.getInstance().removeDriver();
    }

    private void initializeServices(WebDriver driver) {
        mailServeces = new MailServeces(driver);
    }
}
