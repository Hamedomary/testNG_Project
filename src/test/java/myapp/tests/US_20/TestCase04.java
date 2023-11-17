package myapp.tests.US_20;

import myapp.pages.US_10.HomePage;
import myapp.pages.US_10.MyAccountPage;
import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase04 {

    WebDriver driver = null;

    HomePage homePage = new HomePage();
    MyAccountPage myAccountPage = new MyAccountPage();

    @BeforeClass
    public void initializeDriver() {

        driver = Driver.getDriver();

        // Vendor must be sign in
        driver.get("https://allovercommerce.com/my-account-2/");
        myAccountPage.usernameInput.sendKeys("telvin.daking@meshfor.com");
        myAccountPage.passwordInput.sendKeys("Deneme@12345");
        myAccountPage.passwordInput.sendKeys(Keys.RETURN);

        // WaitUtils.waitForClickablility(myAccountPage.signinButton, 10);
        // myAccountPage.signinButton.click();

    }

    @AfterClass
    public void quitDriver() {
        Driver.closeDriver();
    }

    @Test(priority = 1)
    public void step1_navigateToWebpage() {

        // Go to home page
        driver.get("https://allovercommerce.com");
    }

    @Test(priority = 2)
    public void step2_clickMyAccountLink() {

        // WaitUtils.waitForClickablility(homePage.myAccountLink, 10);

        // Click on My Account end of the homepage
        // homePage.myAccountLink.click();
        driver.get("https://allovercommerce.com/my-account-2");
    }

    @Test(priority = 3)
    public void step3_clickAddressButton() {

        WaitUtils.waitForVisibility(myAccountPage.addressButton, 10);

        // Click on Addresses button
        myAccountPage.addressButton.click();
    }

    @Test(priority =  4)
    public void step4_clickAddButton() {

        WaitUtils.waitFor(10);
        // Click on Add button
        myAccountPage.addressAddButton.click();
    }

    @Test(priority =  5)
    public void step5_enterFirstName() {

        WaitUtils.waitForVisibility(myAccountPage.billingFirstName, 10);

        // Vendor enters First Name
        myAccountPage.billingFirstName.sendKeys("Elizabeth");
    }

    @Test(priority =  6)
    public void step6_enterLastName() {

        // Vendor enters Last Name
        myAccountPage.billingLastName.sendKeys("Potter");
    }

    @Test(priority =  7)
    public void step7_selectCountry() {

        Select countrySelect = new Select(myAccountPage.billingCountry);

        // Vendor selects Country/Region
        countrySelect.selectByVisibleText("United Kingdom (UK)");
    }

    @Test(priority =  8)
    public void step8_enterStreetAddress() {

        // Vendor enters Street Address
        myAccountPage.billingAddress1.sendKeys("Shepherds Way");
    }

    @Test(priority =  9)
    public void step9_enterCity() {

        // Vendor enters Town/City
        myAccountPage.billingCity.sendKeys("Hatfield");
    }

    @Test(priority =  10)
    public void step10_enterZipCode() {

        // Vendor enters Zip Code
        myAccountPage.billingZipCode.sendKeys("AL9 6NS");
    }

    @Test(priority =  11)
    public void step11_enterPhone() {

        // Vendor enters Phone
        myAccountPage.billingZipCode.sendKeys("1707602500");
    }

    @Test(priority =  12)
    public void step12_enterEmail() {

        // Vendor enters email address
        myAccountPage.billingEmail.sendKeys("gulbulozoktem@gmail.com");
    }

    @Test(priority =  13)
    public void step13_clickSaveAddress() {

        // Click on Save Address button
        myAccountPage.billingSaveAddressButton.click();
    }

    @Test(priority =  14)
    public void step14_clickEditAddress() {

        // Click on Edit Address button
        myAccountPage.billingEditAddressButton.click();
    }

    @Test(priority =  15)
    public void step15_verifyAddress() {

        // Verify edit address details
        Assert.assertEquals(myAccountPage.billingFirstName.getText(), "Elizabeth");
        Assert.assertEquals(myAccountPage.billingLastName.getText(), "Potter");
        Assert.assertEquals(myAccountPage.billingCountry.getText(), "United Kingdom (UK)");
        Assert.assertEquals(myAccountPage.billingAddress1.getText(), "Shepherds Way");
        Assert.assertEquals(myAccountPage.billingCity.getText(), "Hatfield");
        Assert.assertEquals(myAccountPage.billingZipCode.getText(), "");
        Assert.assertEquals(myAccountPage.billingPhone.getText(), "");
        Assert.assertEquals(myAccountPage.billingEmail.getText(), "gulbulozoktem@gmail.com");
    }

    @Test(priority =  16)
    public void step16_clickSaveAddress() {

        // Click on Save Address button
        myAccountPage.billingSaveAddressButton.click();
    }
}
