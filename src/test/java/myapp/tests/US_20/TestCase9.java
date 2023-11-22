package myapp.tests.US_20;

import myapp.pages.US11_US20.US20Page;
import myapp.tests.us_08.Locators;
import myapp.utilities.Driver;
import myapp.utilities.JSUtils;
import myapp.utilities.WaitUtils;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class TestCase9 {

    US20Page us20Page = new US20Page();
    Locators locators = new Locators();

    @Test
    public void testCase9() {
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
        locators.viewCart.click();
        locators.couponCode.sendKeys("3589345kjr");
        locators.applyCoupon.click();

        Driver.closeDriver();

    }
}
