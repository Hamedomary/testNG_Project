package myapp.tests.US_15;

import myapp.pages.us04_us18.HomePage;
import myapp.pages.us04_us18.MyAccountPage;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.JSUtils;
import myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class US_15_TC_04 {
    //Scenario: TC_04
    //    Given user sign in to the application
    //    And user goes to my account page
    //    And click Store Manager
    //    And click Product button
    //    When click Add New button
    //    And enter product title, short description and description
    //    And add media for short description and for description
    //    And select category
    //    And "Verify Inventory, Shipping, Attributes, Linked, Seo,Advanced menus are visible"
    //    And click Inventory button
    //    And enter the data for SKU
    //    And click manage stock checkbox
    //    And Stock Qty field should be visible
    //    And choose to allow from allow backorders
    //    And click sold individually checkbox
    //    And click shipping button
    //    And enter valid weight
    //    And enter valid dimension
    //    And select processing time
    //    And click Attributes button
    //    And select color and size
    //    Then click submit button

    MyAccountPage myAccountPage = new MyAccountPage();
    HomePage homePage = new HomePage();

    @Test
    public void TC_4_Test() {
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
//        myAccountPage.imageToClick.click();

//    And add media for short description and for description
//        JSUtils.JSclickWithTimeout(myAccountPage.img);

//        myAccountPage.selectFile.click();
        //Driver.getDriver().switchTo().frame("excerpt_ifr");

        String userHome = System.getProperty("user.home");
//        Driver.getDriver().findElement(By.className("upload-ui"));
        myAccountPage.fileUpload.sendKeys(userHome + "/Desktop/flower.jpeg");
        WaitUtils.waitForClickablility(myAccountPage.select, 10);
        myAccountPage.select.click();

        WaitUtils.waitFor(3);

        JSUtils.JSclickWithTimeout(myAccountPage.shortDiscAddMedia);
//        WaitUtils.waitForClickablility(myAccountPage.selectFlower, 10);
        WaitUtils.waitFor(3);
        JSUtils.JSclickWithTimeout(myAccountPage.selectFlower);
        WaitUtils.waitFor(3);
        myAccountPage.insertIntoPost.click();

        WaitUtils.waitFor(3);
        JSUtils.JSclickWithTimeout(myAccountPage.discriptionAddMedia);
        WaitUtils.waitFor(3);
//        WaitUtils.waitForClickablility(myAccountPage.selectFlower, 10);
        JSUtils.JSclickWithTimeout(myAccountPage.selectFlower2);
        myAccountPage.insertIntoPost2.click();

//       And select category
        JSUtils.JSclickWithTimeout(myAccountPage.categories("Flowers"));

//    Then "Verify Inventory, Shipping, Attributes, Linked, Seo,Advanced menus are visible"
        Assert.assertTrue(myAccountPage.menuList.isDisplayed());

//    And click Inventory button
        JSUtils.JSclickWithTimeout(myAccountPage.inventory);

//    And enter the data for SKU
        myAccountPage.sku.sendKeys("Flower");

//    And click sold individually checkbox
        JSUtils.JSclickWithTimeout(myAccountPage.soldIndividually);

//    And click shipping button
        JSUtils.JSclickWithTimeout(myAccountPage.shipping);

        //    And enter valid weight
        myAccountPage.weight.sendKeys("25");

        //    And enter valid dimension
        myAccountPage.length.sendKeys("40");
        myAccountPage.width.sendKeys("10");
        myAccountPage.height.sendKeys("200");

        //    And click Attributes button
        myAccountPage.attributes.click();

        //    And select color and size

        myAccountPage.color.click();
        myAccountPage.colorSelect.sendKeys("Beyaz");
        myAccountPage.size.click();
        myAccountPage.sizeSelect.sendKeys("12");
        
        //    Then click submit button
        JSUtils.JSclickWithTimeout(myAccountPage.submitButton);
    }
    @AfterTest
    public void close(){
        Driver.closeDriver();
    }
}
