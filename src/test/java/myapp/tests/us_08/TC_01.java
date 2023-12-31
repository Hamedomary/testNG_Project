package myapp.tests.us_08;

import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_01 {
    Locators locators = new Locators();

    @Test
    public void testcase1() {
        Driver.getDriver().get("https://allovercommerce.com/");
        WaitUtils.waitFor(5);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://allovercommerce.com/");
        locators.signIn.click();
        locators.userName.sendKeys("Sara");
        locators.password.sendKeys("12345lndn");
        locators.signInButton.click();
        WaitUtils.waitFor(5);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://allovercommerce.com/");
        WaitUtils.waitFor(5);
        locators.searchBox.sendKeys("home");
        locators.searchEnter.click();
        locators.selectProduct.click();
        WaitUtils.waitFor(5);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("/home-sofa/"), "the product is not selected");
        WaitUtils.waitFor(5);
        locators.productInWishlists.click();
        WaitUtils.waitFor(5);
        locators.wishlistButton.click();
        Assert.assertNotNull(locators.productInWishlist);

        Driver.getDriver().quit();

    }

}
