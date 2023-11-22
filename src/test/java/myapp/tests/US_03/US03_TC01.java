package myapp.tests.US_03;

import myapp.pages.US03_US18.AlloverCommerceMyAccountPage;
import myapp.pages.US03_US18.AlloverCommerce_HomePage;
import myapp.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class US03_TC01 {
    AlloverCommerce_HomePage alloverCommerceHomePage = new AlloverCommerce_HomePage();
    AlloverCommerceMyAccountPage alloverCommerceMyAccountPage = new AlloverCommerceMyAccountPage();

    @Test
    public void TC01() throws InterruptedException, IOException {

        LoggerUtils.info("Test case Execution Starts");
        ExtentReportUtils.createTestReport("Unit test","adding billing address test");

//        User logs into the created buyer account
          ReusableMethods.logInMethod();

           ExtentReportUtils.pass("User could log into the webpage");


//        User clicks on (my account) link
           WaitUtils.waitFor(3);
           JSUtils.JSscrollIntoView(alloverCommerceHomePage.myAccount);
           JSUtils.JSclickWithTimeout(alloverCommerceHomePage.myAccount);
           WaitUtils.waitFor(3);
           ExtentReportUtils.pass("User could go to the my account page");

//        User clicks on (Addresses)
          alloverCommerceMyAccountPage.addresses.click();
          WaitUtils.waitFor(3);

//        User clicks on (add) button
           alloverCommerceMyAccountPage.billingAddressAddButton.click();
           ExtentReportUtils.pass("User was able to move in the adding billing address page");
//        Verify (Email address) field comes automatically
          JSUtils.JSscrollIntoView(alloverCommerceMyAccountPage.billingEmail);
          JSUtils.flashElement(alloverCommerceMyAccountPage.billingEmail);
          WaitUtils.waitFor(3);
          Assert.assertTrue(alloverCommerceMyAccountPage.billingEmail.getAttribute("value").equals(ConfigReader.getProperty("US03_Email")));
           ExtentReportUtils.passAndCaptureScreenshot("User´email address came automatically in to the email field");
//        Assert.assertTrue(alloverCommerceMyAccountPage.billingFirstNameField.getAttribute("value").equals(ConfigReader.getProperty("UserFirstName")));
//        Assert.assertTrue(alloverCommerceMyAccountPage.billingLastName.getAttribute("value").equals(ConfigReader.getProperty("UserLastName ")));


//        Verify (First name) field comes automatically
        JSUtils.JSscrollAllTheWayUp();
        JSUtils.flashElement(alloverCommerceMyAccountPage.billingFirstNameField);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(alloverCommerceMyAccountPage.billingFirstNameField.getAttribute("value").equals(ConfigReader.getProperty("US03_UserFirstName")));
         ExtentReportUtils.fail("User first name is not appeared");
         MediaUtils.takeScreenshotOfTheEntirePage();
//        Verify (Last name) field comes automatically
        JSUtils.flashElement(alloverCommerceMyAccountPage.billingLastName);
        softAssert.assertTrue(alloverCommerceMyAccountPage.billingLastName.getAttribute("value").equals(ConfigReader.getProperty("US03_UserLastName")));
         WaitUtils.waitFor(3);
        softAssert.assertAll();


         ExtentReportUtils.fail("User last name is not appeared");

        LoggerUtils.info("The test case failed, because the application does not provide First name and last name credentials automatically");

//      User closes the driver
        ReusableMethods.closeDriver();
        ExtentReportUtils.pass("Driver is closed, test is failed");
        ExtentReportUtils.flush();
    }

}
