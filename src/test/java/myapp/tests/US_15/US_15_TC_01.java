package myapp.tests.US_15;

import com.github.javafaker.Faker;
import myapp.pages.US04_US15.HomePage;
import myapp.pages.US04_US15.MyAccountPage;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.JSUtils;
import myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class US_15_TC_01 {

//    Scenario: TC_01 Inventory, Shipping, Attributes, Linked, Seo, Advanced menus should be visible
//    Given user sign in to the application
//    And user goes to my account page
//    And click Store Manager
//    And click Product button
//    When click Add New button
//    And add media for short description and for description
//    And select category
//    Then "Verify Inventory, Shipping, Attributes, Linked, Seo,Advanced menus are visible"

    Faker faker = new Faker();
    MyAccountPage myAccountPage = new MyAccountPage();
    HomePage homePage = new HomePage();

    @Test
    public void TC_1_Test() {
//    Given user sign in to the application
//    And user goes to my account page
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
        homePage.signInButton.click();
        homePage.userName.sendKeys(ConfigReader.getProperty("allover_vendor_email_US_15"));
        homePage.password.sendKeys(ConfigReader.getProperty("allover_vendor_password_15"));
        homePage.signInButtonInPopUp.click();

        JSUtils.JSclickWithTimeout(homePage.myAccount);

//    And click Store Manager
        JSUtils.JSclickWithTimeout(myAccountPage.storeManager);

//    And click Product button
        JSUtils.JSclickWithTimeout(myAccountPage.products);

//    When click Add New button
        myAccountPage.addNewButton.click();
        WaitUtils.waitFor(3);
        JSUtils.JSclickWithTimeout(myAccountPage.imageToClick);

//    And add media for short description and for description
        String userHome= System.getProperty("user.home");
        myAccountPage.fileUpload.sendKeys(userHome + "/Desktop/flower.jpeg");
        WaitUtils.waitForClickablility(myAccountPage.select, 10);
        myAccountPage.select.click();

        WaitUtils.waitFor(3);
        JSUtils.JSclickWithTimeout(myAccountPage.shortDiscAddMedia);

        WaitUtils.waitFor(3);
        JSUtils.JSclickWithTimeout(myAccountPage.selectFlower);

        WaitUtils.waitFor(3);
        myAccountPage.insertIntoPost.click();

        WaitUtils.waitFor(3);
        JSUtils.JSclickWithTimeout(myAccountPage.discriptionAddMedia);

        WaitUtils.waitFor(3);
        JSUtils.JSclickWithTimeout(myAccountPage.selectFlower2);
        myAccountPage.insertIntoPost2.click();

//       And select category
        JSUtils.JSclickWithTimeout(myAccountPage.categories("Flowers"));

//    Then "Verify Inventory, Shipping, Attributes, Linked, Seo,Advanced menus are visible"
        Assert.assertTrue(myAccountPage.menuList.isDisplayed());
    }

    @AfterTest
    public void close(){
        Driver.closeDriver();
    }
}