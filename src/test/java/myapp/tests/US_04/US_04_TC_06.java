package myapp.tests.US_04;

import com.github.javafaker.Faker;
import myapp.pages.HomePage;
import myapp.pages.MyAccountPage;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.JSUtils;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_04_TC_06 {
//    Scenario: TC_06 Fill the shipping address form without city
//    Given user sign in to the application
//    And user goes to my account page
//    And user clicks addresses
//    When user click add button under shipping address
//    And user enter "fist_name"
//    And user enter "last_name"
//    And user enter "company"
//    And user select country
//    And user enter "address"
//    And user enter "state"
//    And user enter "postcode"
//    And user click save address button
//    Then verify error message is displayed
Faker faker=new Faker();
    MyAccountPage myAccountPage=new MyAccountPage();
    HomePage homePage=new HomePage();

    @Test
    public void signInTest(){
//    Given user sign in to the application
//    And user goes to my account page
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce_url"));
        homePage.signInButton.click();
        homePage.userName.sendKeys(ConfigReader.getProperty("allovercommerce_username_US_04"));
        homePage.password.sendKeys(ConfigReader.getProperty("allovercommerce_password_US_04"));
        homePage.signInButtonInPopUp.click();

        JSUtils.JSclickWithTimeout(homePage.myAccount);


//        homePage.myAccount.click();

//    And user clicks addresses
        myAccountPage.addresses.click();

//    When user click add button under shipping address
        JSUtils.JSclickWithTimeout(myAccountPage.addAddress);
//        myAccountPage.addAddress.click();

//    And user enter "firstName"
        myAccountPage.firstName.sendKeys(faker.name().firstName());

//    And user enter "last_name"
        myAccountPage.lastName.sendKeys(faker.name().lastName());

//    And user enter "company"
        myAccountPage.companyName.sendKeys(faker.company().name());

//    And user select country
        Select selectCountry=new Select(myAccountPage.countryRegion);
        selectCountry.selectByVisibleText(ConfigReader.getProperty("shipping_country_US_04"));

//    And user enter "address"
        myAccountPage.streetAddress.sendKeys(faker.address().streetAddress());

//    And user enter "state"
        Select selectState=new Select(myAccountPage.state);
        selectState.selectByVisibleText(faker.address().state());


//    And user enter "postcode"
        myAccountPage.zipCode.sendKeys(faker.address().zipCode());


//    And user click save address button
//        myAccountPage.saveAddress.click();
        JSUtils.JSclickWithTimeout(myAccountPage.saveAddress);


//    Then verify error message is displayed
        Assert.assertTrue(myAccountPage.errorMessage.isDisplayed());

        Driver.getDriver().quit();
    }
}
