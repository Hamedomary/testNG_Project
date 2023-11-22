package myapp.tests.us_08;

import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_05 {
    Locators locators = new Locators();

    @Test
    public void testcase5() {
        Driver.getDriver().get("https://allovercommerce.com/");
        WaitUtils.waitFor(5);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://allovercommerce.com/");
        locators.signIn.click();
        locators.userName.sendKeys("Sara");
        locators.password.sendKeys("12345lndn");
        locators.signInButton.click();
        WaitUtils.waitFor(5);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://allovercommerce.com/");
        Assert.assertNotNull(locators.catalogItems);
        locators.catalogItems.get(0).click();
        locators.catalogProduct.get(1).click();
        WaitUtils.waitFor(5);
        locators.productInWishlists.click();
        WaitUtils.waitFor(3);
        locators.clickMyWishlist.click();
        WaitUtils.waitFor(5);
        locators.addProductCard.click();
        locators.openCart.click();
        WaitUtils.waitFor(5);
        locators.clickCheckout.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("checkout"));

        Driver.getDriver().quit();

    }

}
