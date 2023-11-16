package myapp.tests.US_17;

import myapp.pages.melik.AC_homepage;
import myapp.pages.melik.AC_loginpage;
import myapp.pages.melik.AC_myaccountpage;
import myapp.utilities.*;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import javax.annotation.Tainted;

import static org.junit.Assert.assertTrue;

public class TestCase01 {



    @Test
    public void TC_01(){



//    Vendor goes to the webpage
        Driver.getDriver().get(ConfigReader.getProperty("AC_url"));
//    Vendor logs in with a registered customer account
        AC_homepage homepage = new AC_homepage();
        AC_loginpage loginpage = new AC_loginpage();
        AC_myaccountpage myaccountpage = new AC_myaccountpage();


        WaitUtils.waitFor(1);
        homepage.signIn.click();


        loginpage.usurname.sendKeys(ConfigReader.getProperty("AC_Vendoremail"));
        loginpage.password.sendKeys(ConfigReader.getProperty("AC_Vendorpass"));
        WaitUtils.waitFor(1);
        loginpage.signInButton.click();
        WaitUtils.waitFor(2);

//    Verify the home element is  visible
//    Click the home
//    Verify (Add to chart) button in Deals Hot Of The Day box visible
        assertTrue(homepage.dealsHotOfTheDay.isDisplayed());

//    Click on the "ADD TO CHART"
        JSUtils.JSclickWithTimeout(homepage.addToChart);

//    Verify the next page sign in Deals Hot Of tHE Day Box visible

        JSUtils.JSclickWithTimeout(homepage.nextPageSign);
//    Click on the nex page sign in Deals Hot Of The Day Box
//    Verify the increase button in Deals Hot Of The Day Box
//    Click the increase button once
//    Verify (Add to chart) button in Deals Hot Of The Day box visible
//    Click on the "ADD TO CHART"
//    Verify (VIEW CHART) button is visible
//    Click the VIEW CHART BUTTON
//    Verify that product and products has been successfully added to cart.
//    Verify (Proceed to checkout) button is visible
//    Click on the Proceed to Checkout button
//    Click on the First Name Box and type a name
//    Click on the Last Name Box and type a name
//    Click on the Company Name and type your company name
//    Click on the Country/Region and type your country then enter
//    Click on the Street Address and type your address
//    Click on the Postcode/Zip and type valid postcode/zip
//    Click on the Town/City and type your city
//    Click on the Province and select your province
//    Click on the phone and type your number
//    Click on the email address and type a email
//    Verify if "Ship to a different address?" box clickable and then leave unclick
//    Verify that "Total Amount" is visible
//    Verify if "Wire transfer/EFT" is visible
//    Click on the Wire transfer/EFT button
//    Verify if "Pay at the door" is visible
//    Click on the "Pay at the door" button
//    Verify that "Place Order" button is visible
//    Click on the place order button
//    Verify that "My Orders" under My- account is visible
//    Click on the My Orders button
//    Verify the id of order
}
}
