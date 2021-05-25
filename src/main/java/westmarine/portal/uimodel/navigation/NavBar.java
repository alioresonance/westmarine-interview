package westmarine.portal.uimodel.navigation;

import westmarine.portal.common.ShopByCategory;
import westmarine.portal.uimodel.BasePageObject;

public class NavBar extends BasePageObject {

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
    public NavBar gotoMenu(ShopByCategory menu) {
        driver.get(parseHostUrl(driver.getCurrentUrl()) + menu.subpage);
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
