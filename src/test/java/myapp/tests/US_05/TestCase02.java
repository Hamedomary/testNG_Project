package myapp.tests.US_05;

import myapp.pages.melik.AC_homepage;
import myapp.pages.melik.AC_loginpage;
import myapp.pages.melik.AC_myaccountpage;
import myapp.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static myapp.utilities.JSUtils.flashElement;

@Listeners(myapp.utilities.ListenerUtils.class)
public class TestCase02 {

    AC_homepage homepage = new AC_homepage();
    AC_loginpage loginpage = new AC_loginpage();
    AC_myaccountpage myaccountpage = new AC_myaccountpage();

    @BeforeMethod
    public void loggedInTheWebsite() throws InterruptedException {
        LoggerUtils.info("Test case begins .. ");
        ExtentReportUtils.createTestReport("Unit Test Report","Account Details Test");

//        User goes to the webpage
          Driver.getDriver().get(ConfigReader.getProperty("AC_url"));

//        User logs in with a registered customer account
        AC_homepage homepage = new AC_homepage();
        AC_loginpage loginpage = new AC_loginpage();
        AC_myaccountpage myaccountpage = new AC_myaccountpage();

        ExtentReportUtils.pass("User navigate to login page...");
        WaitUtils.waitFor(1);
        homepage.signIn.click();

        ExtentReportUtils.pass("User registers to their account...");
        loginpage.usurname.sendKeys(ConfigReader.getProperty("AC_email"));
        loginpage.password.sendKeys(ConfigReader.getProperty("AC_pass"));
        WaitUtils.waitFor(1);
        loginpage.signInButton.click();

        ExtentReportUtils.pass("User is on the home page");
        WaitUtils.waitForVisibility(By.xpath("//a[.='Sign Out']"),3);

//        Click on the MY ACCOUNT
        JSUtils.JSscrollAllTheWayDown();
        flashElement(homepage.MyAccount);
        WaitUtils.waitFor(2);
        homepage.MyAccount.click();

//        Click on the ACCOUNT DETAILS
        ExtentReportUtils.pass("User is on the Account Details Page");
        WaitUtils.waitFor(1);
        myaccountpage.accountDetails.click();
    }

    @Test (priority = 1)
    public void leaveBlankFirstName() throws InterruptedException {
//        Clean the First Name box
        AC_myaccountpage myaccountpage = new AC_myaccountpage();
        myaccountpage.firstName.clear();

//        User click on "SAVE CHANGES" BUTTON
        JSUtils.JSscrollAllTheWayDown();
        flashElement(myaccountpage.saveChangesButton);
        myaccountpage.saveChangesButton.click();

//        Verify the message First Name
        Assert.assertTrue(myaccountpage.firstNameRequired.getText().contains("FIRST NAME is a required field."));
    }
    @Test (priority = 2)
    public void leaveBlankSurname() throws InterruptedException {
//        Clean the last Name box
        AC_myaccountpage myaccountpage = new AC_myaccountpage();
        myaccountpage.lastname.clear();

//        User click on "SAVE CHANGES" BUTTON
        JSUtils.JSscrollAllTheWayDown();
        flashElement(myaccountpage.saveChangesButton);
        myaccountpage.saveChangesButton.click();

//        Verify the message First Name
        Assert.assertTrue(myaccountpage.lastNameRequired.getText().contains("required field."));
    }

    @Test (priority = 3)
    public void leaveBlankDisplay() throws InterruptedException {

//        Clean the First Name box
        AC_myaccountpage myaccountpage = new AC_myaccountpage();
        myaccountpage.displayName.clear();

//        User click on "SAVE CHANGES" BUTTON
        JSUtils.JSscrollAllTheWayDown();
        flashElement(myaccountpage.saveChangesButton);
        myaccountpage.saveChangesButton.click();

//        Verify the message First Name
        Assert.assertTrue(myaccountpage.displayNameRequired.getText().contains("required field."));

    }

    @Test (priority = 4)
    public void leaveBlankEmail() throws InterruptedException {

//        Clean the First Name box
        AC_myaccountpage myaccountpage = new AC_myaccountpage();
        myaccountpage.email.clear();

//        User click on "SAVE CHANGES" BUTTON
        JSUtils.JSscrollAllTheWayDown();
        flashElement(myaccountpage.saveChangesButton);
        myaccountpage.saveChangesButton.click();

//        Verify the message First Name
        Assert.assertEquals(myaccountpage.emailAddressRequired.getText(),"EMAIL ADDRESS is a required field.");
    }

    @AfterMethod
    public void tearDown(){

        Driver.closeDriver();
    }

}
