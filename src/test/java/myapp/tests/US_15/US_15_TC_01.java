package myapp.tests.US_15;

import com.github.javafaker.Faker;
import myapp.pages.HomePage;
import myapp.pages.MyAccountPage;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.JSUtils;
import myapp.utilities.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

//    And add media for short description and for description
        JSUtils.JSclickWithTimeout(myAccountPage.shortDiscAddMedia);

//        myAccountPage.selectFile.click();
       //Driver.getDriver().switchTo().frame("excerpt_ifr");
        String userHome= System.getProperty("user.home");
        Driver.getDriver().findElement(By.className("upload-ui"));
        myAccountPage.fileUpload.sendKeys(userHome + "/Desktop/flower.jpeg");
        myAccountPage.insertIntoPost.click();
        myAccountPage.selectFlower.click();
//        myAccountPage.flower1.click();
        WaitUtils.waitFor(3);
        myAccountPage.insertIntoPost.click();
 //       JSUtils.JSclickWithTimeout(myAccountPage.insertIntoPost);


//    And select category
//        myAccountPage.categories.click();
        JSUtils.JSclickWithTimeout(myAccountPage.categories);

//    Then "Verify Inventory, Shipping, Attributes, Linked, Seo,Advanced menus are visible"



    }
}