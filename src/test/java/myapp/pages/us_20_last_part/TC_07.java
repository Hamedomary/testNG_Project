package myapp.pages.us_20_last_part;

import myapp.pages.US_08.Locators;
import myapp.pages.us11_us20.US20Page;
import myapp.utilities.Driver;
import myapp.utilities.JSUtils;
import myapp.utilities.WaitUtils;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_07 {
    US20Page us20Page = new US20Page();
    Locators locators = new Locators();

    @Test
    public void testCase7(){
        Driver.getDriver().get("https://allovercommerce.com/");
        US20Page.getSignIn.click();
        us20Page.usernameInput.sendKeys("gulbulozoktem@gmail.com");
        WaitUtils.waitFor(2);
        us20Page.passwordInput.sendKeys("nsngl2023@");
        WaitUtils.waitFor(2);
        us20Page.signInSubmitButton.click();
        WaitUtils.waitFor(2);
        us20Page.searchButton.sendKeys("Chess", Keys.ENTER);
        JSUtils.JSclickWithTimeout(us20Page.addToCartButton);
        JSUtils.JSclickWithTimeout(us20Page.cartButton);
        WaitUtils.waitFor(3);
        locators.clickCheckout.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("checkout"));
        JSUtils.JSscrollAllHorizVertical();
        WaitUtils.waitFor(5);
        locators.placeOrder.click();
        WaitUtils.waitFor(5);
        Assert.assertTrue(locators.orderComplete.getText().contains("Your order has been received"));

        Driver.closeDriver();
    }
}
