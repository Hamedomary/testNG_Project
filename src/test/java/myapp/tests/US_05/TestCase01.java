package myapp.tests.US_05;

import com.github.javafaker.Faker;
import myapp.pages.melik.AC_homepage;
import myapp.pages.melik.AC_loginpage;
import myapp.pages.melik.AC_myaccountpage;
import myapp.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static myapp.utilities.JSUtils.*;
import static org.junit.Assert.assertTrue;


@Listeners(myapp.utilities.ListenerUtils.class)
public class TestCase01 {

    Faker faker = new Faker();
    Actions actions = new Actions(Driver.getDriver());


    @Test
    public void TC01() throws InterruptedException {
        AC_homepage AC_homepage = new AC_homepage();
        AC_loginpage AC_loginpage = new AC_loginpage();
        AC_myaccountpage myaccountpage = new AC_myaccountpage();

        LoggerUtils.info("Test case begins .. ");

        ExtentReportUtils.createTestReport("Unit Test Report","Account Details Test");

//    User goes to the webpage
        Driver.getDriver().get(ConfigReader.getProperty("AC_url"));

//    User logs in with a registered customer account
        ExtentReportUtils.pass("User navigate to login page...");
        WaitUtils.waitFor(1);
        AC_homepage.signIn.click();

        ExtentReportUtils.pass("User registers to their account...");

        AC_loginpage.usurname.sendKeys(ConfigReader.getProperty("AC_email"));
        AC_loginpage.password.sendKeys(ConfigReader.getProperty("AC_pass"));
        WaitUtils.waitFor(1);
        AC_loginpage.signInButton.click();

//        Verify that user on the home page

        ExtentReportUtils.pass("User is on the home page");
        WaitUtils.waitForVisibility(By.xpath("//a[.='Sign Out']"),3); //if signout element visible means that user on the page,

//    Verify (My account) link is visible
        JSUtils.JSscrollAllTheWayDown();
        Assert.assertTrue(AC_homepage.MyAccount.isDisplayed());

//    Click on the MY ACCOUNT
        flashElement(AC_homepage.MyAccount);
        WaitUtils.waitFor(1);
        AC_homepage.MyAccount.click();

//    Verify (My Account) link is visible

        ExtentReportUtils.pass("User is on the my account page");
        Assert.assertEquals(myaccountpage.myAccountText.getText(),"My Account");

//    Click on the ACCOUNT DETAILS
        ExtentReportUtils.pass("User is on the Account Details Page");
        WaitUtils.waitFor(1);
        myaccountpage.accountDetails.click();

//    User click in the First Name box and type a name
       myaccountpage.firstName.clear();
       myaccountpage.firstName.sendKeys(ConfigReader.getProperty("AC_name"));

//    User click on the LAST NAME and type a name
        myaccountpage.lastname.clear();
        myaccountpage.lastname.sendKeys(ConfigReader.getProperty("AC_lastName"));

//    User click on the Display Name and remove existing Display Name then  type new Name
        myaccountpage.displayName.clear();
        myaccountpage.displayName.sendKeys("BreakingBad");

//    User click on the EMAIL ADDRESS and remove existing email address then type new valid email
        myaccountpage.email.clear();
        myaccountpage.email.sendKeys(ConfigReader.getProperty("AC_newMail"));


//    User click on the Biography section and type lorem
//        Actions actions = new Actions(Driver.getDriver());
//        Driver.getDriver().switchTo().frame(0);
//        actions.click(myaccountpage.biography).perform();
//        myaccountpage.biography.sendKeys("lorem");

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WaitUtils.waitFor(2);
        String text=faker.harryPotter().quote();
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[@id='user_description_ifr']")));
        WaitUtils.waitFor(1);
        JSclickWithTimeout(myaccountpage.biography);
        myaccountpage.biography.sendKeys(text);
        WaitUtils.waitFor(2);
        Driver.getDriver().switchTo().defaultContent();

//        Driver.getDriver().switchTo().frame(0);
//        JSUtils.JSclickWithTimeout(myaccountpage.biography);
//        myaccountpage.biography.sendKeys("ABcdefg123546");
//        Driver.getDriver().switchTo().defaultContent();





//    User click on the current password and type the current one
        myaccountpage.current_password.sendKeys(ConfigReader.getProperty("AC_pass"));

//    User click on the new password and type the new password
        String newPassword = faker.internet().password(12,13,true,true,true);
        myaccountpage.new_password.sendKeys(newPassword);

//    User click on the confirm password and type the password you write for new password
        myaccountpage.confirm_password.sendKeys(newPassword);
        JSscrollAllTheWayDown();

//    Verify the save changes button
//    User click on "SAVE CHANGES" BUTTON
        flashElement(myaccountpage.saveChangesButton);
        WaitUtils.waitFor(1);
        myaccountpage.saveChangesButton.click();

//    Verify the message "Account details changed successfully

        assertTrue(myaccountpage.successfullSaved.isDisplayed());

//        Type ex mail ex password  after succssfullyMessage

        myaccountpage.email.clear();
        myaccountpage.email.sendKeys(ConfigReader.getProperty("AC_email"));

        flashElement(myaccountpage.current_password);
        myaccountpage.current_password.sendKeys(newPassword);

        myaccountpage.new_password.sendKeys(ConfigReader.getProperty("AC_pass"));
        myaccountpage.confirm_password.sendKeys(ConfigReader.getProperty("AC_pass"));

        flashElement(myaccountpage.saveChangesButton);
        JSUtils.JSclickWithTimeout(myaccountpage.saveChangesButton);
        assertTrue(myaccountpage.successfullSaved.isDisplayed());
        ExtentReportUtils.passAndCaptureScreenshot("Account details changed succesfully...");

//       Close the driver
         Driver.closeDriver();
        ExtentReportUtils.pass("Driver is closed.... Test is completed successfully...");

        ExtentReportUtils.flush();
        LoggerUtils.info("Test completed...");




//


    }

}
