package westmarine.portal.uimodel.portal;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import westmarine.portal.common.Brand;
import westmarine.portal.common.Protection;
import westmarine.portal.common.ShopByCategory;
import westmarine.portal.uimodel.BasePageObject;
import westmarine.portal.uimodel.Cart;
import westmarine.portal.uimodel.filter.Filter;
import westmarine.portal.uimodel.navigation.NavBar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WestMarine extends BasePageObject {

    public final static String HOST = "https://www.westmarine.com/";

    public WestMarine openBrowser() {
        super.createDriver();
        driver.get(HOST);

        List<WebElement> disclaimer = driver.findElements(
                By.cssSelector("#privacyDisclaimer > a.btn.btn-secondary.secondary.privacy-disclaimer-accept"));
        if (!disclaimer.isEmpty()) {
            disclaimer.get(0).click();
            }
        return this;
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void closeBrowser() {
        driver.quit();
    }

    /**
     * super keywords
     */
    public WestMarine navigate(ShopByCategory menu) {
        new NavBar().gotoMenu(menu);
        return this;
    }

    public WestMarine filterByBrand(Brand brand) {
        new Filter().by(brand);
        return this;
    }

    public WestMarine selectByPriceDisplayed(String price) {
        new Catalog().clickByPrice(price);
        return this;
    }

    public WestMarine addToCart() {
        new ProductDetail().addCart();
        return this;
    }

    public WestMarine addWarranty(Protection text) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".custom-control-label")));

        List<WebElement> list = driver.findElements(By.cssSelector(".custom-control-label"));

        for (WebElement e: list) {
            if (e.getText().contains(text.type))
                e.click();
        }
//        driver.findElements(By.cssSelector("#productDetailUpdateable > .row > .product-info-details.productDescription.col-6 > .mb-2 > ul > li"))
        return this;
    }

    public WestMarine verifyWarrantyAdded(String expectedMessage) {
        WebElement actual = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("plusplan_minicart_action")));
        assertThat(actual.getText()).as("Invalid selection message when adding warranty from the cart")
                .isEqualTo(expectedMessage);
        return this;
    }

    public Cart goToCart() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Go To Cart"))).click();

//        By radio = By.className("shipping-option-sts");
//        new WebDriverWait(driver, 20)
//                .until(ExpectedConditions.elementToBeClickable(radio)).click();

        By link = By.linkText("Calculate");
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(link)).click();

        driver.findElement(By.name("postalCode")).sendKeys("95035" + Keys.ENTER);
        By byTax = By.cssSelector("#order_totals_container .tax-calculator-container > span");
        String actualTax = new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(byTax)).getText();
        assertThat(actualTax).as("Invalid Tax").isEqualTo("$69.37");
        return new Cart();
    }

}
