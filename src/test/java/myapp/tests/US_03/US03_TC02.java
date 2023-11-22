package myapp.tests.US_03;

import myapp.pages.US03_US18.AlloverCommerceMyAccountPage;
import myapp.pages.US03_US18.AlloverCommerce_HomePage;
import myapp.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class US03_TC02 {
    AlloverCommerce_HomePage alloverCommerceHomePage = new AlloverCommerce_HomePage();
    AlloverCommerceMyAccountPage alloverCommerceMyAccountPage = new AlloverCommerceMyAccountPage();

    @Test
    public void TC02() throws InterruptedException, IOException {
        ExtentReportUtils.createTestReport("unit test","adding billing address test");
//        User logs into the application with a created buyer account
        ExtentReportUtils.info("Starting the test");
          ReusableMethods.logInMethod();
          WaitUtils.waitFor(1);
         ExtentReportUtils.pass("user is logged into the webpage");


//        User clicks on (my account) link
           JSUtils.JSscrollIntoView(alloverCommerceHomePage.myAccount);
           JSUtils.JSclickWithTimeout(alloverCommerceHomePage.myAccount);
           WaitUtils.waitFor(1);
          ExtentReportUtils.pass("User could go to my account page");
//        User clicks on (Addresses)
          alloverCommerceMyAccountPage.addresses.click();

//        User clicks on (add) button
          alloverCommerceMyAccountPage.billingAddressAddButton.click();

          // User clears the filled credentials fields and leaves others as blank
          JSUtils.JSscrollIntoView(alloverCommerceMyAccountPage.billingEmail);
          alloverCommerceMyAccountPage.billingEmail.clear();

//       User clicks on save address button
         JSUtils.JSclickWithTimeout(alloverCommerceMyAccountPage.saveAddressButton);
         WaitUtils.waitFor(1);
         ExtentReportUtils.pass("User was able to click on save address button");
//       Verify (First name is a required field.) error message is appeared
         Assert.assertTrue(alloverCommerceMyAccountPage.firstNameErrorMSG.getText().equals("First name is a required field."));

    // Verify (Last name is a required field.) error message is appeared
    Assert.assertTrue(alloverCommerceMyAccountPage.lastNameErrorMSG.getText().equals("Last name is a required field."));

    // Verify (Country / Region is a required field.) error message is appeared
     Assert.assertTrue(alloverCommerceMyAccountPage.countryErrorMSG.getText().equals("Country / Region is a required field."));

    // Verify (State is a required field.) error message is appeared
    Assert.assertTrue(alloverCommerceMyAccountPage.stateErrorMSG.getText().equals("State is a required field."));
        MediaUtils.takeScreenshotOfTheEntirePage();

    // Verify (Street address is a required field.) error message is appeared
     Assert.assertTrue(alloverCommerceMyAccountPage.StreetErrorMSG.getText().equals("Street address is a required field."));

    // Verify (Postcode / ZIP is a required field.) error message is appeared
      Assert.assertTrue(alloverCommerceMyAccountPage.zipcodeErrorMSG.getText().equals("ZIP Code is a required field."));
      JSUtils.JSscrollIntoView(alloverCommerceMyAccountPage.zipcodeErrorMSG);
      WaitUtils.waitFor(1);

    // Verify (Town / City is a required field.) error message is appeared
     Assert.assertTrue(alloverCommerceMyAccountPage.cityErrorMSG.getText().equals("Town / City is a required field."));

    // Verify (Phone is a required field.) error message is appeared
     Assert.assertTrue(alloverCommerceMyAccountPage.phoneErrorMSG.getText().equals("Phone is a required field."));

    // Verify (Email address is a required field. ) error message ie appeared
     Assert.assertTrue(alloverCommerceMyAccountPage.emailAddressErrorMSG.getText().equals("Email address is a required field."));
     ExtentReportUtils.passAndCaptureScreenshot("Test case passed");
        LoggerUtils.info("The test case passed. The application does not save the billing address until providing necessary credentials.");

     // Close Driver
        ReusableMethods.closeDriver();

         ExtentReportUtils.info("Test finished");
         ExtentReportUtils.flush();
}

}
