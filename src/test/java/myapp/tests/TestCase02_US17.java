

import com.github.javafaker.Faker;
import myapp.pages.melik.AC_checkoutpage;
import myapp.pages.melik.AC_homepage;
import myapp.pages.melik.AC_loginpage;
import myapp.utilities.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class TestCase02_US17 {

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
        checkoutpage.firstName.clear();

//    Click on the Last Name Box and type a name
        checkoutpage.lastName.clear();

//    Click on the Company Name and type your company name
        checkoutpage.companyName.clear();
//    Click on the Country/Region and type your country then enter


//    Click on the Street Address and type your address
        checkoutpage.address.clear();
//    Click on the Postcode/Zip and type valid postcode/zip
        checkoutpage.postcode.clear();
//    Click on the Town/City and type your city

//    Click on the Province and select your province

//    Click on the phone and type your number
        checkoutpage.phone.clear();
//    Click on the email address and type a email
        checkoutpage.email.clear();
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
        WaitUtils.waitFor(2);
//    Verify that there is an error message
        Assert.assertTrue(checkoutpage.addressAlert.getText().contains("required"));
        Assert.assertTrue(checkoutpage.phoneAlert.getText().contains("required"));
        Assert.assertTrue(checkoutpage.lastNameAlert.getText().contains("required"));
        Assert.assertTrue(checkoutpage.emailAlert.getText().contains("required"));
        Assert.assertTrue(checkoutpage.firstNameAlert.getText().contains("required"));
        Assert.assertTrue(checkoutpage.postcodeAlert.getText().contains("required"));






//        Close the driver

        //Driver.closeDriver();
    }
}