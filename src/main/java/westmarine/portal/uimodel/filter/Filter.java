package westmarine.portal.uimodel.filter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import westmarine.portal.common.Brand;
import westmarine.portal.uimodel.BasePageObject;

public class Filter extends BasePageObject {

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
    public Filter by(Brand brand) {
        WebElement checkbox = driver.findElement(By.linkText(brand.text));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
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
