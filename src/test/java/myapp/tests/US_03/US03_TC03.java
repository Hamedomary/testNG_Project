package myapp.tests.US_03;

import myapp.pages.US03_US18.AlloverCommerceMyAccountPage;
import myapp.pages.US03_US18.AlloverCommerce_HomePage;
import myapp.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US03_TC03 {
    AlloverCommerce_HomePage alloverCommerceHomePage = new AlloverCommerce_HomePage();
    AlloverCommerceMyAccountPage alloverCommerceMyAccountPage = new AlloverCommerceMyAccountPage();

    @Test
    public void TC03(){
//        User logs into the application wit a created buyer account
          Driver.getDriver().get(ConfigReader.getProperty("URL"));
          alloverCommerceHomePage.signInLink.click();
          alloverCommerceHomePage.UserName.sendKeys("mobile");
          alloverCommerceHomePage.password.sendKeys("Mobile211400");
          alloverCommerceHomePage.signInButton.click();
          WaitUtils.waitFor(1);


//        User clicks on (my account) link
          JSUtils.JSscrollIntoView(alloverCommerceHomePage.myAccount);
          JSUtils.JSclickWithTimeout(alloverCommerceHomePage.myAccount);
          WaitUtils.waitFor(1);

//        User clicks on (Addresses)
          alloverCommerceMyAccountPage.addresses.click();

//        User clicks on (Edit Billing Address) button
          alloverCommerceMyAccountPage.EditYourBillingAddressButton.click();
          WaitUtils.waitFor(2);

//        User clears the credentials if they are filled by using reusable method
          ReusableMethods.clearMethod();

//        User provides all the credentials for changing the billing address
          ReusableMethods.fillingMethod();

//        User clicks on save address button
          JSUtils.JSscrollIntoView(alloverCommerceMyAccountPage.saveAddressButton);
          JSUtils.JSclickWithTimeout(alloverCommerceMyAccountPage.saveAddressButton);
          WaitUtils.waitFor(1);
          Assert.assertTrue(alloverCommerceMyAccountPage.addressSuccessfullyChangedMessage.isDisplayed());

//        User closes the driver
          ReusableMethods.closeDriver();
    }
}
