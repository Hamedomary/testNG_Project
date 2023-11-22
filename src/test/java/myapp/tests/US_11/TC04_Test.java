package myapp.tests.US_11;

import myapp.pages.US11_US20.AlloverLoginPage;
import myapp.utilities.Driver;
import myapp.utilities.JSUtils;
import myapp.utilities.WaitUtils;

import org.testng.annotations.Test;

import static myapp.utilities.JSUtils.flashElement;

public class TC04_Test {


    @Test
    public void myAccountTest() throws InterruptedException {

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
        WaitUtils.waitFor(1);

        JSUtils.JSclickWithTimeout(alloverLoginPage.storeManagerButton);
        Driver.getDriver().navigate().back();


        JSUtils.JSclickWithTimeout(alloverLoginPage.ordersButton);
        Driver.getDriver().navigate().back();

        JSUtils.JSclickWithTimeout(alloverLoginPage.downloadsButton);
        Driver.getDriver().navigate().back();

       JSUtils.JSclickWithTimeout(alloverLoginPage.addressesButton);
       Driver.getDriver().navigate().back();

       JSUtils.JSclickWithTimeout(alloverLoginPage.accountDetailsButton);
       Driver.getDriver().navigate().back();

      JSUtils.JSclickWithTimeout(alloverLoginPage.wishlistButton);
      Driver.getDriver().navigate().back();

       JSUtils.JSclickWithTimeout(alloverLoginPage.supportTicketsButton);
       Driver.getDriver().navigate().back();

       JSUtils.JSclickWithTimeout(alloverLoginPage.followingButton);
       Driver.getDriver().navigate().back();

       JSUtils.JSclickWithTimeout(alloverLoginPage.logoutButton);



        Driver.closeDriver();




}

}






