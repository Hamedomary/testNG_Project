package myapp.tests.US_20_FirstPart;


import myapp.pages.US20Page;
import myapp.utilities.Driver;
import myapp.utilities.JSUtils;
import myapp.utilities.WaitUtils;

import org.openqa.selenium.Keys;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_01 {

    @Test
    public void TC01Test() throws InterruptedException {

        Driver.getDriver().get("https://allovercommerce.com");

        US20Page us20Page = new US20Page();

        US20Page.getSignIn.click();

        us20Page.usernameInput.sendKeys("gulbulozoktem@gmail.com");
        WaitUtils.waitFor(2);


        us20Page.passwordInput.sendKeys("nsngl2023@");
        WaitUtils.waitFor(2);

        us20Page.signInSubmitButton.click();
        WaitUtils.waitFor(2);


        us20Page.searchButton.sendKeys("Chess", Keys.ENTER);
        JSUtils.JSclickWithTimeout(us20Page.addToCartButton);

        us20Page.searchButton.sendKeys("Computer", Keys.ENTER);
        JSUtils.JSclickWithTimeout(us20Page.addToCartButton);

        JSUtils.JSclickWithTimeout(us20Page.cartButton);
        WaitUtils.waitFor(3);

        JSUtils.JSclickWithTimeout(us20Page.viewCartButton);
        WaitUtils.waitFor(3);



        Assert.assertTrue(us20Page.quantityInput.isDisplayed());

        Driver.closeDriver();

























    }


}

