package myapp.tests.us_08;

import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.junit.Test;
import org.testng.Assert;

public class TC_03 {

    Locators locators = new Locators();

    @Test
    public void testCase3() {
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
        locators.clickMyWishlist.click();
        Assert.assertNotNull(locators.productInWishlist);

        Driver.getDriver().quit();

    }

}
