package myapp.tests;

import myapp.pages.melik.Allovercommerce_homepage;
import myapp.pages.melik.Allovercommerce_loginpage;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.JSUtils;
import myapp.utilities.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static myapp.utilities.JSUtils.flashElement;


@Listeners(myapp.utilities.ListenerUtils.class)
public class US_05_TC01 {

    @Test
    public void US_05_TC01() throws InterruptedException {

//    User goes to the webpage
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
//    User logs in with a registered customer account
        Allovercommerce_homepage allovercommerce_homepage = new Allovercommerce_homepage();
        allovercommerce_homepage.signIn.click();
        Allovercommerce_loginpage allovercommerce_loginpage = new Allovercommerce_loginpage();
        allovercommerce_loginpage.usurname.sendKeys(ConfigReader.getProperty("allovercommerce_username"));
        allovercommerce_loginpage.password.sendKeys(ConfigReader.getProperty("allovercommerce_password"));
        flashElement(allovercommerce_loginpage.signInButton);
        allovercommerce_loginpage.signInButton.click();
//        Verify that user on the home page
        WaitUtils.waitForVisibility(By.xpath("//a[.='Sign Out']"),7); //if signout element visible means that user on the page,

//    Verify (My account) link is visible
        JSUtils.JSscrollAllTheWayDown();
        Assert.assertTrue(allovercommerce_homepage.MyAccount.isDisplayed());

//    Click on the MY ACCOUNT
//    Verify (Account Details) link is visible
//    Click on the ACCOUNT DETAILS
//    User click in the First Name box and type a name
//    User click on the LAST NAME and type a name
//    User click on the Display Name and remove existing Display Name then  type new Name
//    User click on the EMAIL ADDRESS and remove existing email address then type new valid email
//    User click on the Biography section and type lorem
//    User click on the current password and type the current one
//    User click on the new password and type the new password
//    User click on the confirm password and type the password you write for new password
//    Verify the save changes button
//    User click on "SAVE CHANGES" BUTTON
//    Verify the message "Account details changed successfully
//    Close the driver
//      Driver.closeDriver();



    }

}
