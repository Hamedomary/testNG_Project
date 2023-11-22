package myapp.tests.US_05;

import com.github.javafaker.Faker;
import myapp.pages.melik.Allovercommerce_homepage;
import myapp.pages.melik.Allovercommerce_loginpage;
import myapp.pages.melik.Allovercommerce_myaccountpage;
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

import static myapp.utilities.JSUtils.JSscrollAllTheWayDown;
import static myapp.utilities.JSUtils.flashElement;
import static org.testng.AssertJUnit.assertTrue;


@Listeners(myapp.utilities.ListenerUtils.class)
public class US_05_TC01 {

    Faker faker = new Faker();
    Actions actions = new Actions(Driver.getDriver());
    @Test
    public void US_05_TC01() throws InterruptedException {

//    User goes to the webpage
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
//    User logs in with a registered customer account
        Allovercommerce_homepage allovercommerce_homepage = new Allovercommerce_homepage();
        allovercommerce_homepage.signIn.click();
        Allovercommerce_loginpage allovercommerce_loginpage = new Allovercommerce_loginpage();
        allovercommerce_loginpage.usurname.sendKeys(ConfigReader.getProperty("aCommerce_username"));
        allovercommerce_loginpage.password.sendKeys(ConfigReader.getProperty("aCommerce_pass"));
        allovercommerce_loginpage.signInButton.click();
//        Verify that user on the home page
        WaitUtils.waitForVisibility(By.xpath("//a[.='Sign Out']"),3); //if signout element visible means that user on the page,

//    Verify (My account) link is visible
        JSUtils.JSscrollAllTheWayDown();
        Assert.assertTrue(allovercommerce_homepage.MyAccount.isDisplayed());

//    Click on the MY ACCOUNT
        flashElement(allovercommerce_homepage.MyAccount);
        allovercommerce_homepage.MyAccount.click();
//    Verify (My Account) link is visible
        Allovercommerce_myaccountpage myaccountpage = new Allovercommerce_myaccountpage();
        Assert.assertEquals(myaccountpage.myAccountText.getText(),"My Account");
//    Click on the ACCOUNT DETAILS
        myaccountpage.accountDetails.click();
//    User click in the First Name box and type a name
       myaccountpage.firstName.clear();
       myaccountpage.firstName.sendKeys("Walter");
//    User click on the LAST NAME and type a name
        myaccountpage.lastname.clear();
        myaccountpage.lastname.sendKeys("White");
//    User click on the Display Name and remove existing Display Name then  type new Name
        myaccountpage.displayName.clear();
        myaccountpage.displayName.sendKeys("BreakingBad");
//    User click on the EMAIL ADDRESS and remove existing email address then type new valid email
        myaccountpage.email.clear();
        myaccountpage.email.sendKeys(ConfigReader.getProperty("aCommerce_newMail"));


//    User click on the Biography section and type lorem
//        Actions actions = new Actions(Driver.getDriver());
//        Driver.getDriver().switchTo().frame(0);
//        actions.click(myaccountpage.biography).perform();
//        myaccountpage.biography.sendKeys("lorem");


//    User click on the current password and type the current one
        myaccountpage.current_password.sendKeys(ConfigReader.getProperty("aCommerce_pass"));

//    User click on the new password and type the new password
        String newPassword = faker.internet().password(12,13,true,true,true);
        myaccountpage.new_password.sendKeys(newPassword);
//    User click on the confirm password and type the password you write for new password
        myaccountpage.confirm_password.sendKeys(newPassword);
        JSscrollAllTheWayDown();

//    Verify the save changes button
//    User click on "SAVE CHANGES" BUTTON
        flashElement(myaccountpage.saveChangesButton);
        myaccountpage.saveChangesButton.click();

//    Verify the message "Account details changed successfully

        assertTrue(myaccountpage.successfullSaved.isDisplayed());

//        Type ex mail ex password  after succssfullyMessage
        myaccountpage.email.clear();
        myaccountpage.email.sendKeys(ConfigReader.getProperty("aCommerce_username"));
        flashElement(myaccountpage.current_password);
        myaccountpage.current_password.sendKeys(newPassword);
        myaccountpage.new_password.sendKeys(ConfigReader.getProperty("aCommerce_pass"));
        myaccountpage.confirm_password.sendKeys(ConfigReader.getProperty("aCommerce_pass"),Keys.TAB);
        flashElement(myaccountpage.saveChangesButton);
        JSUtils.JSclickWithTimeout(myaccountpage.saveChangesButton);
        assertTrue(myaccountpage.successfullSaved.isDisplayed());

//    Close the driver
      Driver.closeDriver();



    }

}
