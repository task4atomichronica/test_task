package enums;

import org.openqa.selenium.By;

/**
 * NavigationLinkItem representing navigation link items available on navigation component on home page
 */
public enum NavigationLinkItem {

    INBOX("Inbox", By.cssSelector("[title^='Inbox']")),
    COMPOSE("Compose", By.xpath("//div[@role='navigation']/preceding-sibling::div//div[@role='button']")),
    SENT_MAIL("Sent Mail", By.cssSelector("[title^='Sent Mail']"));

    private String name;
    private By locator;

    NavigationLinkItem(String name, By locator) {
        this.name = name;
        this.locator = locator;
    }

    public String getName() {
        return name;
    }

    public By getLocator() {
        return locator;
    }
}
