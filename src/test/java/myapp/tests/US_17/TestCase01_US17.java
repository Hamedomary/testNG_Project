package myapp.tests.US_17;

import com.github.javafaker.Faker;
import myapp.pages.US_14.AC_checkoutpage;
import myapp.pages.US_14.AC_homepage;
import myapp.pages.US_14.AC_loginpage;
import myapp.utilities.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class TestCase01_US17 {

    Faker faker = new Faker();

    @Test
    public void TC_01(){


//    Vendor goes to the webpage
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce"));
//    Vendor logs in with a registered customer account
        AC_homepage homepage = new AC_homepage();
        AC_loginpage loginpage = new AC_loginpage();
        AC_checkoutpage checkoutpage = new AC_checkoutpage();
        Actions actions = new Actions(Driver.getDriver());

        WaitUtils.waitFor(1);
        homepage.signIn.click();


        loginpage.usurname.sendKeys(ConfigReader.getProperty("aoc_username"));
        loginpage.password.sendKeys(ConfigReader.getProperty("aoc_password"));
        WaitUtils.waitFor(1);
        loginpage.signInButton.click();
        WaitUtils.waitFor(2);

//    Verify (Add to chart) button in Deals Hot Of The Day box visible
        assertTrue(homepage.dealsHotOfTheDay.isDisplayed());

//    Click on the "ADD TO CHART"
        JSUtils.JSclickWithTimeout(homepage.addToChart);

//    Verify (CHART) icon is visible
        assertTrue(homepage.chartIcon.isDisplayed());

//    Click the CHART BUTTON
        JSUtils.JSclickWithTimeout(homepage.chartIcon);

//    Click the CHECKOUT BUTTON
        JSUtils.JSclickWithTimeout(checkoutpage.checkoutButton);

//    Verify that Vendor is on the checkout page
        assertTrue(checkoutpage.checkoutPage.isDisplayed());

//    Verify that product and products has been successfully added.
        assertTrue(checkoutpage.successfullyAdded.isDisplayed());

//    Click on the First Name Box and type a name
        checkoutpage.firstName.sendKeys(faker.harryPotter().character());

//    Click on the Last Name Box and type a name
        checkoutpage.lastName.sendKeys(faker.harryPotter().character());

//    Click on the Company Name and type your company name
        checkoutpage.companyName.sendKeys(faker.artist().name());
//    Click on the Country/Region and type your country then enter


//    Click on the Street Address and type your address
        checkoutpage.address.sendKeys(faker.address().streetAddress());
//    Click on the Postcode/Zip and type valid postcode/zip
        checkoutpage.postcode.sendKeys(faker.address().zipCode());
//    Click on the Town/City and type your city

//    Click on the Province and select your province

//    Click on the phone and type your number
        checkoutpage.phone.sendKeys(faker.phoneNumber().cellPhone());
//    Click on the email address and type a email
        checkoutpage.email.clear();
        checkoutpage.email.sendKeys(faker.internet().emailAddress());

//    Verify that "Total Amount" is visible
        checkoutpage.totalAmount.isDisplayed();
//    Verify if "Ship to a different address?" box clickable and then leave unclick
        BrowserUtils.verifyElementClickable(checkoutpage.shippingAddressClickable);

//    Verify if "Wire transfer/EFT" is visible
        BrowserUtils.verifyElementDisplayed(checkoutpage.eftWireTransferDisplay);

//    Click on the Wire transfer/EFT button
        JSUtils.JSclickWithTimeout(checkoutpage.eftWireTransferClick);
//    Verify if "Pay at the door" is visible
        BrowserUtils.verifyElementDisplayed(checkoutpage.payAtDoorDisplay);
//    Click on the "Pay at the door" button
        JSUtils.JSclickWithTimeout(checkoutpage.payAtDoorClick);
//    Verify that "Place Order" button is visible
        BrowserUtils.verifyElementDisplayed(checkoutpage.placeOrder);
//    Click on the place order button
        JSUtils.JSclickWithTimeout(checkoutpage.placeOrder);
//    Verify that "My Orders" under My- account is visible
        WaitUtils.waitFor(10);
        BrowserUtils.verifyElementDisplayed(homepage.myOrders);
//    Click on the My Orders button
        JSUtils.JSclickWithTimeout(homepage.myOrders);
//    Verify the id of order
        WaitUtils.waitFor(3);
        BrowserUtils.verifyElementDisplayed(homepage.myOrdersOrderNumber);
//        Close the driver

        //Driver.closeDriver();
    }
}