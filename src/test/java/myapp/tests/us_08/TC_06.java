package myapp.tests.us_08;

import myapp.pages.US_08.Locators;
import myapp.utilities.Driver;
import myapp.utilities.JSUtils;
import myapp.utilities.WaitUtils;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_06 {
    Locators locators = new Locators();

    @Test
    public void testCase6() {
        Driver.getDriver().get("https://allovercommerce.com/");
        WaitUtils.waitFor(5);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://allovercommerce.com/");
        Assert.assertNotNull(locators.catalogItems);
        locators.catalogItems.get(0).click();
        locators.catalogProduct.get(1).click();
        WaitUtils.waitFor(5);
        locators.productInWishlistss.click();
        WaitUtils.waitFor(5);
        locators.wishlistButton.click();
        locators.addProductCard.click();
        WaitUtils.waitFor(5);
        locators.openCart.click();
        WaitUtils.waitFor(5);
        locators.clickCheckout.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("checkout"));
        locators.firstName.sendKeys("Sara");
        locators.lastName.sendKeys("Saras");
        Select selectCountry = new Select(locators.country1);
        selectCountry.selectByVisibleText("United Kingdom (UK)");
        locators.streetAddress.sendKeys("Sara Avenue");
        locators.townCity.sendKeys("London");
        locators.zipCode.sendKeys("E467PU");
        locators.phone.sendKeys("0918278374");
        locators.email.sendKeys("erfag@erfa.com");
        JSUtils.JSscrollAllHorizVertical();
        WaitUtils.waitFor(5);
        locators.placeOrder.click();
        WaitUtils.waitFor(5);
        Assert.assertTrue(locators.orderComplete.getText().contains("Your order has been received"));

        Driver.closeDriver();
    }
}
