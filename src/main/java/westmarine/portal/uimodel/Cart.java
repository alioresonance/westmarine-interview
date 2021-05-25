package westmarine.portal.uimodel;

import org.openqa.selenium.By;

public class Cart extends BasePageObject {

    /*
     * locators
     */
            // <PLACEHOLDER>

    /*
     * elements
     */
            // <PLACEHOLDER>

    /*
     * actions
     */
    public Cart checkout() {
        driver.findElement(By.id("checkoutButtonTop")).click();
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
