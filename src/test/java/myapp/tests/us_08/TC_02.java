package myapp.tests.us_08;

import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_02 {

    Locators locators = new Locators();

    @Test
    public void testCase2() {
        Driver.getDriver().get("https://allovercommerce.com/");
        WaitUtils.waitFor(5);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://allovercommerce.com/");
        locators.signIn.click();
        locators.userName.sendKeys("Sara");
        locators.password.sendKeys("12345lndn");
        locators.signInButton.click();
        WaitUtils.waitFor(5);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://allovercommerce.com/");
        locators.catalogItems.get(0).click();
        locators.catalogProduct.get(1).click();
        WaitUtils.waitFor(5);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("https://allovercommerce.com/urun/"));
        locators.productInWishlists.click();
        WaitUtils.waitFor(5);
        locators.wishlistButton.click();
        WaitUtils.waitFor(5);
        Assert.assertNotNull(locators.productInWishlist);

        Driver.getDriver().quit();
    }

}
