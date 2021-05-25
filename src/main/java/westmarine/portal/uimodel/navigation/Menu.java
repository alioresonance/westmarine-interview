package westmarine.portal.uimodel.navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import westmarine.portal.uimodel.BasePageObject;

public class Menu extends BasePageObject {

    /*
     * locators
     */
            // <PLACEHOLDER>

    /*
     * elements
     */
    public WebElement menu(String text) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(String.format("//*[@id='header-nav']//*[contains(text(), '%s')]", text))));
    }

    /*
     * actions
     */
    public Menu clickMenu(String sidebarText) {
        menu(sidebarText).click();
        return this;
    }

    /*
     * verify
     */
            // <PLACEHOLDER>

    /*
     * keywords
     */
            // <PLACEHOLDER>

}
