package westmarine.portal.uimodel.portal;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import westmarine.portal.uimodel.BasePageObject;

public class ProductDetail extends BasePageObject {

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
    public ProductDetail addCart() {
        driver.findElement(By.id("addToCartButton")).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("add-to-cart-colorbox")));
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
