package myapp.tests.US_11;


import myapp.pages.us11_us20.AlloverLoginPage;
import myapp.utilities.Driver;
import myapp.utilities.JSUtils;
import myapp.utilities.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static myapp.utilities.JSUtils.flashElement;

public class TC03_Test {


        @Test
        public void myAccountTest() throws InterruptedException {

            WebDriver webDriver = new ChromeDriver();
            Driver.getDriver().get("https://allovercommerce.com");

            AlloverLoginPage alloverLoginPage = new AlloverLoginPage();

            flashElement(alloverLoginPage.getSignIn);
            alloverLoginPage.getSignIn.click();

            flashElement(alloverLoginPage.usernameInput);
            alloverLoginPage.usernameInput.sendKeys("gulbulozoktem@gmail.com");

            WaitUtils.waitFor(2);


            flashElement(alloverLoginPage.passwordInput);
            alloverLoginPage.passwordInput.sendKeys("nsngl2023@");

            WaitUtils.waitFor(2);

            alloverLoginPage.signInSubmitButton.click();
            WaitUtils.waitFor(2);

          JSUtils.JSclickWithTimeout(alloverLoginPage.myAccountInput);



          Assert.assertTrue(alloverLoginPage.storeManagerButton.isDisplayed());

          Assert.assertTrue(alloverLoginPage.ordersButton.isDisplayed());

          Assert.assertTrue(alloverLoginPage.downloadsButton.isDisplayed());

          Assert.assertTrue(alloverLoginPage.addressesButton.isDisplayed());

          Assert.assertTrue(alloverLoginPage.accountDetailsButton.isDisplayed());

          Assert.assertTrue(alloverLoginPage.wishlistButton.isDisplayed());

          Assert.assertTrue(alloverLoginPage.supportTicketsButton.isDisplayed());

          Assert.assertTrue(alloverLoginPage.followingButton.isDisplayed());

          Assert.assertTrue(alloverLoginPage.logoutButton.isDisplayed());

          Driver.closeDriver();
































        }


}



