package myapp.pages.us_20_last_part;

import myapp.pages.US_08.Locators;
import myapp.pages.us11_us20.US20Page;
import myapp.utilities.Driver;
import myapp.utilities.JSUtils;
import myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_08 {
    US20Page us20Page = new US20Page();
    Locators locators = new Locators();

    @Test
    public void testCase8(){
        Driver.getDriver().get("https://allovercommerce.com/");
        US20Page.getSignIn.click();
        us20Page.usernameInput.sendKeys("gulbulozoktem@gmail.com");
        WaitUtils.waitFor(2);
        us20Page.passwordInput.sendKeys("nsngl2023@");
        WaitUtils.waitFor(2);
        us20Page.signInSubmitButton.click();
        JSUtils.JSscrollAllHorizVertical();
        JSUtils.JSclickWithTimeout(locators.myOrders);
        WaitUtils.waitFor(2);
        Assert.assertTrue(locators.orderList.size()>0);
        locators.orderListView.get(0).click();
        WaitUtils.waitFor(2);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("view-order"));

        Driver.closeDriver();
    }
}
