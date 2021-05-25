package westmarine.portal.uimodel.portal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import westmarine.portal.uimodel.BasePageObject;

import java.util.List;

public class Catalog extends BasePageObject {

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
    public Catalog clickByPrice(String price) {
        List<WebElement> results = driver.findElements(
                By.cssSelector("#searchGrid > .results-block.last > .lazyload > .row"));
        results.stream().filter(e -> e.getText().contains(price)).findFirst().orElse(null).click();
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
