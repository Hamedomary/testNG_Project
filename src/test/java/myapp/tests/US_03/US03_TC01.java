package myapp.tests.US_03;

import myapp.pages.US03_US18.AlloverCommerceMyAccountPage;
import myapp.pages.US03_US18.AlloverCommerce_HomePage;
import myapp.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class US03_TC01 {
    AlloverCommerce_HomePage alloverCommerceHomePage = new AlloverCommerce_HomePage();
    AlloverCommerceMyAccountPage alloverCommerceMyAccountPage = new AlloverCommerceMyAccountPage();

    @Test
    public void TC01() throws InterruptedException {

//        User logs into the created buyer account
        ReusableMethods.logInMethod();


//        User clicks on (my account) link
        JSUtils.JSscrollIntoView(alloverCommerceHomePage.myAccount);
        JSUtils.JSclickWithTimeout(alloverCommerceHomePage.myAccount);
        WaitUtils.waitFor(1);


//       User clicks on (Addresses)
        alloverCommerceMyAccountPage.addresses.click();
        WaitUtils.waitFor(1);

//        User clicks on (add) button
        alloverCommerceMyAccountPage.billingAddressAddButton.click();

//        Verify (Email address) field comes automatically
        JSUtils.JSscrollIntoView(alloverCommerceMyAccountPage.billingEmail);
        JSUtils.flashElement(alloverCommerceMyAccountPage.billingEmail);
        WaitUtils.waitFor(1);
        Assert.assertTrue(alloverCommerceMyAccountPage.billingEmail.getAttribute("value").equals(ConfigReader.getProperty("US03_Email")));

//        Assert.assertTrue(alloverCommerceMyAccountPage.billingFirstNameField.getAttribute("value").equals(ConfigReader.getProperty("UserFirstName")));
//        Assert.assertTrue(alloverCommerceMyAccountPage.billingLastName.getAttribute("value").equals(ConfigReader.getProperty("UserLastName ")));


//        Verify (First name) field comes automatically
        JSUtils.JSscrollAllTheWayUp();
        JSUtils.flashElement(alloverCommerceMyAccountPage.billingFirstNameField);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(alloverCommerceMyAccountPage.billingFirstNameField.getAttribute("value").equals(ConfigReader.getProperty("US03_UserFirstName")));


//        Verify (Last name) field comes automatically
        JSUtils.flashElement(alloverCommerceMyAccountPage.billingLastName);
        softAssert.assertTrue(alloverCommerceMyAccountPage.billingLastName.getAttribute("value").equals(ConfigReader.getProperty("US03_UserLastName")));
        softAssert.assertAll();

        LoggerUtils.info("The test case failed, because the application does not provide First name and last name credentials automatically");

//      User closes the driver
        ReusableMethods.closeDriver();
    }

}
