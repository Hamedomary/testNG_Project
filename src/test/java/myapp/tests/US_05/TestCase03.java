package myapp.tests.US_05;

import com.github.javafaker.Faker;
import myapp.pages.melik.AC_homepage;
import myapp.pages.melik.AC_loginpage;
import myapp.pages.melik.AC_myaccountpage;
import myapp.utilities.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static myapp.utilities.JSUtils.flashElement;

@Listeners(ListenerUtils.class)
public class TestCase03 {

    AC_homepage homepage = new AC_homepage();
    AC_loginpage loginpage = new AC_loginpage();
    AC_myaccountpage myaccountpage = new AC_myaccountpage();
    Faker faker = new Faker();

    @Test
    public void incorrectCurrentPass() throws InterruptedException {
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

//        User click on the current password and type wrong password
        ExtentReportUtils.pass("User enters incorrect password");
        myaccountpage.current_password.sendKeys(faker.internet().password(12,13,true,true,true));

//        User click on the new password and type the new password
        ExtentReportUtils.pass("User enters new password");
        String newPassword = faker.internet().password(12,13,true,true,true);
        myaccountpage.new_password.sendKeys(newPassword);

//        User click on the confirm password and type same password  typied on the new password
        ExtentReportUtils.pass("User enters confirm password");
        myaccountpage.confirm_password.sendKeys(newPassword);

//        Click on the save changes button
        ExtentReportUtils.pass("User clicks the save changes button");
        JSUtils.JSscrollAllTheWayDown();
        flashElement(myaccountpage.saveChangesButton);
        myaccountpage.saveChangesButton.click();

//        Verify the Your current password is incorrect.
       Assert.assertTrue(myaccountpage.incorrectCurrentPass.isDisplayed());

       ExtentReportUtils.flush();

//        Close the driver
        Driver.closeDriver();

    }

}
