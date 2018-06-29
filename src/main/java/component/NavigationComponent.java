package component;

import base.BaseComponent;
import dialog.NewEmailDialog;
import enums.NavigationLinkItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Waiters;

/**
 * NavigationComponent representing part of the home gmail page with links to mailbox folders and 'new email' button
 */
public class NavigationComponent extends BaseComponent {

    /* Constants */
    private static final String TABINDEXATTRIBUTE = "tabIndex";
    private static final String TABINDEXATTRIBUTEVALUE = "0";

    /* Element identifiers */
    private static final By NEWMESSAGEDIALOGCONTAINERBY = By.cssSelector("div[role='dialog']");

    public NavigationComponent(WebDriver driver) {
        super(driver);
    }

    /**
     * Initiates new email creation
     *
     * @return NewEmailDialog - resulting dialog
     */
    public NewEmailDialog initiateNewEmailCreation() {
        driver.findElement(NavigationLinkItem.COMPOSE.getLocator()).click();
        Waiters.getWaiter(driver, 10).until(ExpectedConditions.
                visibilityOf(driver.findElement(NEWMESSAGEDIALOGCONTAINERBY)));
        return new NewEmailDialog(driver);
    }

    /**
     * Selects specified mailbox folder
     *
     * @param folder
     *          folder to be used
     */
    public void selectTab(NavigationLinkItem folder) {
        driver.findElement(folder.getLocator()).click();
        Waiters.getWaiter(driver, 10).until(ExpectedConditions.attributeContains
                (folder.getLocator(), TABINDEXATTRIBUTE, TABINDEXATTRIBUTEVALUE));
    }
}
