package myapp.tests.US_04;
import com.github.javafaker.Faker;
import myapp.pages.us04_us15.HomePage;
import myapp.pages.us04_us15.MyAccountPage;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.JSUtils;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_04_TC_09 {
//    Scenario: TC_9 Fill the shipping address form
//    Given user sign in to the application
//    And user goes to my account page
//    And user clicks addresses
//    When user click add button under shipping address
//    And user enter "fist_name"
//    And user enter "last_name"
//    And user enter "company"
//    And user select country
//    And user enter "address"
//    And user enter "city"
//    And user enter "state"
//    And user enter "postcode"
//    And user click save address button
//    Then verify saved successful
    Faker faker=new Faker();
    MyAccountPage myAccountPage=new MyAccountPage();
    HomePage homePage=new HomePage();

    @Test
    public void signInTest(){
//    Given user sign in to the application
//    And user goes to my account page
        Driver.getDriver().get (ConfigReader.getProperty("allovercommerce_url"));
        homePage.registerButton.click();
        homePage.registerUserName.sendKeys(faker.name().username());
        homePage.registerEmail.sendKeys(faker.internet().emailAddress());

        homePage.registerPassword.sendKeys(faker.internet().password());
        homePage.privacyPolicy.click();
        homePage.registerSignUp.click();

        JSUtils.JSclickWithTimeout(homePage.myAccount);

//    And user clicks addresses
        myAccountPage.addresses.click();

//    When user click add button under shipping address
        JSUtils.JSclickWithTimeout(myAccountPage.addAddress);

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

//    And user enter "city"
        myAccountPage.townCity.sendKeys(faker.address().city());


//    And user enter "state"
        Select selectState=new Select(myAccountPage.state);
        selectState.selectByVisibleText(faker.address().state());


//    And user enter "postcode"
        myAccountPage.zipCode.sendKeys(faker.address().zipCode());


//    And user click save address button
//        myAccountPage.saveAddress.click();
        JSUtils.JSclickWithTimeout(myAccountPage.saveAddress);


//    Then verify error message is displayed
        Assert.assertTrue(myAccountPage.successMessage.isDisplayed());


        Driver.getDriver().quit();
    }
}
