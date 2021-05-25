package westmarine.portal.application;

import westmarine.portal.BaseTest;
import westmarine.portal.common.Brand;
import westmarine.portal.common.Protection;
import westmarine.portal.common.ShopByCategory;
import westmarine.portal.uimodel.portal.WestMarine;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CardTests extends BaseTest {

    @BeforeClass
    public void initBS() {
        //startBrowserStackLocal();
    }
    @AfterClass
    public void resetBS() {
        //stopBrowserStackLocal();
    }

    @Test
    public void tryAddingInvalidCardNumber() {
        new WestMarine()
                .openBrowser()
                .navigate(ShopByCategory.FISHING_FISHFINDERS)
                .filterByBrand(Brand.GARMIN)
                .selectByPriceDisplayed("$749.99")
                .addWarranty(Protection.YEAR_1)
                .addToCart()
                //.verifyWarrantyAdded("Thanks for adding a 1 Year PLUS Product Protection Plan.");
                .goToCart()
                .checkout();
                //.closeBrowser();
    }

}
