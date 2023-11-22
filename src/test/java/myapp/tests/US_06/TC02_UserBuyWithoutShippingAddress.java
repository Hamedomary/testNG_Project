package myapp.tests.US_06;

import com.github.javafaker.Faker;
import myapp.pages.US_06.Billing_Page;
import myapp.pages.US_06.Buying_Page;
import myapp.pages.US_06.HomePage;
import myapp.utilities.Driver;
import myapp.utilities.JSUtils;
import myapp.utilities.MediaUtils;
import myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC02_UserBuyWithoutShippingAddress {

    Faker faker = new Faker();

    Buying_Page buyingPage = new Buying_Page();

    HomePage homePage = new HomePage();
    Billing_Page billingPage = new Billing_Page();



    @Test
    public void signInTest() throws IOException {
//    Given user sign in to the application
//    And user goes to my account page


        Driver.getDriver().get("https://allovercommerce.com/");

        WaitUtils.waitFor(2);


        homePage.signInButton.click();
        homePage.userName.sendKeys("Arife");
        homePage.password.sendKeys("12345");

        JSUtils.JSclickWithTimeout(homePage.signInButtonInPopUp);


        // search a product from searchbox

        buyingPage.searchBox.sendKeys("Bag");

        buyingPage.searchResultBag.click();

        buyingPage.addToCartButton.click();

        // Verify that the product is added the cart

        Assert.assertTrue(buyingPage.cartIcon.getText().contentEquals("1"));

        MediaUtils.takeScreenshotOfTheEntirePage();


        // check the cart part and click checkout

        buyingPage.cartIcon.click();

        JSUtils.JSclickWithTimeout(buyingPage.checkOut);


        // click place order without billing details

        buyingPage.placeOrderButton.click();


        // verify that error message is displayed on the page


        Assert.assertTrue(buyingPage.Error.isDisplayed());




    }


}
