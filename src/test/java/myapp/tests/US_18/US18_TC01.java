package myapp.tests.US_18;

import myapp.pages.US03_US18.AlloverCommerceMyAccountPage;
import myapp.pages.US03_US18.AlloverCommerce_HomePage;
import myapp.pages.US03_US18.VendorAccountPage;
import myapp.utilities.*;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class US18_TC01 {

    VendorAccountPage vendorAccountPage = new VendorAccountPage();
    AlloverCommerceMyAccountPage alloverCommerceMyAccountPage = new AlloverCommerceMyAccountPage();
    AlloverCommerce_HomePage alloverCommerceHomePage = new AlloverCommerce_HomePage();

      @Test
      public void TC01(){

//     User signs in to the application with a vendor account by using reusable method
          ReusableMethods.logInMethod();
//     User clicks on my account
          JSUtils.JSscrollIntoView(vendorAccountPage.myAccountVendor);
          WaitUtils.waitFor(2);
          vendorAccountPage.myAccountVendor.click();
//     User clicks on Store Manager
          vendorAccountPage.storeManagerLink.click();
//     User clicks on coupons
          WaitUtils.waitFor(3);
          JSUtils.JSclickWithTimeout(vendorAccountPage.couponsLink);
         // vendorAccountPage.couponsLink.click();
//     User click on add new button
          WaitUtils.waitFor(3);
          vendorAccountPage.addNewCouponButton.click();
          WaitUtils.waitFor(3);
      }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test (dependsOnMethods = "TC01")
    public void TC02() throws AWTException, InterruptedException {

//          User provides a code in the (code) field
            vendorAccountPage.codeField.sendKeys("1200");

//          provide a description in (Description) field
            vendorAccountPage.descriptionField.sendKeys("nice test");
            WaitUtils.waitFor(3);

//          Select (Discount types) separately
            BrowserUtils.dropdownSelectByIndex(vendorAccountPage.discountTypeDropDown,1);
            WaitUtils.waitFor(4);
            BrowserUtils.dropdownSelectByIndex(vendorAccountPage.discountTypeDropDown,0);

//          Provide an amount in (Coupon Amount) field
            vendorAccountPage.amountField.clear();
            vendorAccountPage.amountField.sendKeys("2000");

//          provide a date in the (Coupon expiry date) field
            vendorAccountPage.couponExpiryDate.sendKeys("2-2-2021", Keys.TAB);
             WaitUtils.waitFor(2);

//          Verify (Allow free shipping) check box is clickable
            if(!vendorAccountPage.allowFreeShippingCheckbox.isSelected()){
            vendorAccountPage.allowFreeShippingCheckbox.click();
            WaitUtils.waitFor(1);
        }
            Assert.assertTrue(vendorAccountPage.allowFreeShippingCheckbox.isSelected());
             WaitUtils.waitFor(1);

//          Verify (Show on store) check box is clickable
            if(!vendorAccountPage.showOnStoreCheckBox.isSelected()){
            vendorAccountPage.showOnStoreCheckBox.click();
            WaitUtils.waitFor(1);
        }
            Assert.assertTrue(vendorAccountPage.showOnStoreCheckBox.isSelected());

//          Click on (Submit) button
            WaitUtils.waitFor(3);
            JSUtils.JSscrollIntoView(vendorAccountPage.submitButtonCoupon);
            JSUtils.JSclickWithTimeout(vendorAccountPage.submitButtonCoupon);

//          Verify (Coupon successfully published) message is appeared
            Assert.assertTrue(vendorAccountPage.couponSuccessfullyPublishedMessage.isDisplayed());

//          Click on (coupons) link
            WaitUtils.waitFor(2);
            JSUtils.JSclickWithTimeout(vendorAccountPage.couponsLink);

//          Verify coupon is created
            vendorAccountPage.searchBar.sendKeys("1200");
            WaitUtils.waitFor(2);

            JSUtils.JSscrollIntoView(vendorAccountPage.couponCreatedCode);
            JSUtils.flashElement(vendorAccountPage.couponCreatedCode);
            Assert.assertTrue(vendorAccountPage.couponCreatedCode.getText().equals("1200"));
            WaitUtils.waitFor(4);

            // User deletes the coupon back
            JSUtils.JSclickWithTimeout(vendorAccountPage.deleteCouponButton);
           // vendorAccountPage.deleteCouponButton.click();
            WaitUtils.waitFor(2);
            Driver.getDriver().switchTo().alert().accept();

//           User closes the driver
             WaitUtils.waitFor(1);
             Driver.closeDriver();
    }
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        @Test (dependsOnMethods = "TC01")
        public void TC03() throws InterruptedException {
              vendorAccountPage.amountField.sendKeys("001");
//           User clicks on (Coupon expiry date) field
                 JSUtils.JSscrollIntoView(vendorAccountPage.couponExpiryDate);
                 JSUtils.JSclickWithTimeout(vendorAccountPage.couponExpiryDate);
                 WaitUtils.waitFor(3);
                 vendorAccountPage.couponExpiryDate.click();
                 WaitUtils.waitFor(6);

//           User clicks on( month )option to select a month

                 BrowserUtils.dropdownSelectByIndex(vendorAccountPage.monthDropDown,2);
                 WaitUtils.waitFor(3);

//           User clicks on (year) option to select a year
                 BrowserUtils.dropdownSelectByVisibleText(vendorAccountPage.yearDropDown,"2000");
                 WaitUtils.waitFor(3);

//          User clicks on right (arrow) link to change the date
                JSUtils.flashElement(vendorAccountPage.rightArrowDateChanger);
                vendorAccountPage.rightArrowDateChanger.click();
                WaitUtils.waitFor(3);
//          User clicks on left (arrow) link to change the date
                JSUtils.flashElement(vendorAccountPage.leftArrowDateChanger);
                vendorAccountPage.leftArrowDateChanger.click();
                WaitUtils.waitFor(3);

//          User Selects a day from (Day) table
               JSUtils.flashElement(vendorAccountPage.daySelection);
               JSUtils.JSclickWithTimeout(vendorAccountPage.daySelection);
               WaitUtils.waitFor(3);

               ReusableMethods.closeDriver();
       }

 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test(dependsOnMethods = "TC01")
    public void TC04(){


//         User leaves all the input fields empty and clicks on submit button
           WaitUtils.waitFor(3);
           JSUtils.JSscrollIntoView(vendorAccountPage.submitButtonCoupon);
           WaitUtils.waitFor(3);
           vendorAccountPage.submitButtonCoupon.click();

//         Verify (Please insert at least Coupon Title before submit.) is displayed
           WaitUtils.waitFor(3);
           Assert.assertTrue(vendorAccountPage.couponTitleISNeededErrorMessage1.isDisplayed());
           WaitUtils.waitFor(3);

           ReusableMethods.closeDriver();
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      @Test(dependsOnMethods = "TC01")
      public void TC05(){

//        User leaves the code field empty and fills all other inputs
          vendorAccountPage.descriptionField.sendKeys("good test");
          WaitUtils.waitFor(2);

          vendorAccountPage.amountField.clear();
          vendorAccountPage.amountField.sendKeys("2000");

          vendorAccountPage.couponExpiryDate.sendKeys("2-2-2021", Keys.TAB);
          WaitUtils.waitFor(2);

//         User leaves all the input fields empty and clicks on submit button
          WaitUtils.waitFor(3);
          JSUtils.JSscrollIntoView(vendorAccountPage.submitButtonCoupon);
          WaitUtils.waitFor(3);
          vendorAccountPage.submitButtonCoupon.click();

//         Verify (Please insert at least Coupon Title before submit.) is displayed
          WaitUtils.waitFor(3);
          Assert.assertTrue(vendorAccountPage.couponTitleISNeededErrorMessage1.isDisplayed());

//        Close the driver
           ReusableMethods.closeDriver();
      }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


       @Test(dependsOnMethods = "TC01")
    public void TC06() throws InterruptedException {

//     User enters a code in to the code field
          vendorAccountPage.codeField.sendKeys("1997");
          WaitUtils.waitFor(2);

//     User clicks on submit button without filling other input fields
          JSUtils.JSscrollIntoView(vendorAccountPage.submitButtonCoupon);
          WaitUtils.waitFor(2);
          vendorAccountPage.submitButtonCoupon.click();

          WaitUtils.waitFor(1);
//     Verify (coupon successfully published.) message is displayed

          Assert.assertTrue(vendorAccountPage.couponTitleISNeededErrorMessage1.isDisplayed());
          WaitUtils.waitFor(3);

          LoggerUtils.info("This assertion should not be passed, because the element to be displayed is other than what displays");

//     Verify the account is not created
           WaitUtils.waitFor(5);
           JSUtils.JSscrollIntoView(vendorAccountPage.couponsLink);
           WaitUtils.waitFor(5);
           JSUtils.JSclickWithTimeout(vendorAccountPage.couponsLink);
           WaitUtils.waitFor(5);
           vendorAccountPage.searchBar.sendKeys("1997");
           WaitUtils.waitFor(5);
           JSUtils.JSscrollIntoView(vendorAccountPage.couponCreatedCode);
           JSUtils.flashElement(vendorAccountPage.couponCreatedCode);
           Assert.assertTrue(vendorAccountPage.couponCreatedCode.isDisplayed());
           WaitUtils.waitFor(5);

//          Close the driver
           ReusableMethods.closeDriver();
       }
}
