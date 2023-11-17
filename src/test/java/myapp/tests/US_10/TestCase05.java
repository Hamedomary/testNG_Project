package myapp.tests.US_10;

import myapp.pages.HomePage;
import myapp.pages.VendorRegisterPage;
import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase05 {

    WebDriver driver = null;
    HomePage homePage = new HomePage();
    VendorRegisterPage vendorRegisterPage = new VendorRegisterPage();

    @BeforeClass
    public void initializeDriver() {
        driver = Driver.getDriver();
    }

    @AfterClass
    public void quitDriver() {
        Driver.closeDriver();
    }

    @Test(priority = 1)
    public void step1_navigateToWebpage() {

        // User navigates to the webpage
        driver.get("https://allovercommerce.com");
    }

    @Test(priority = 2)
    public void step2_clickRegisterButton() {

        // User clicks on (Register) link
        homePage.registerButton.click();
    }

    @Test(priority = 3)
    public void step3_checkVendorLinkIsVisible() {

        WaitUtils.waitFor(2);

        // Verify (sign up as a vendor?) link is visible
        Assert.assertTrue(homePage.signupAsVendorLink.isDisplayed());
    }

    @Test(priority = 4)
    public void step4_clickSignupAsVendorLink() {

        // User clicks on (Sign up as vendor?) link
        homePage.signupAsVendorLink.click();
    }

    @Test(priority = 5)
    public void step5_verifyVendorPageIsOpened() {

        // Verify (vendor Registration) page is opened
        WaitUtils.waitForPageToLoad(2);

        Assert.assertTrue( vendorRegisterPage.registerButton.isDisplayed() );
    }

    @Test(priority = 6)
    public void step6_enterValidEmail() {

        // User enters a valid email address in (Email)field
        vendorRegisterPage.emailInput.sendKeys("testUser@testEmail.com");
        vendorRegisterPage.emailInput.sendKeys(Keys.TAB);
    }

    @Test(priority = 7)
    public void step7_isVerificationCodeSent() {

        WaitUtils.waitForVisibility(vendorRegisterPage.verificationCodeSentMessage, 10);

        // Verify (Verification code sent to your email) msg is visible
        Assert.assertTrue(vendorRegisterPage.verificationCodeSentMessage.isDisplayed());
    }

    @Test(priority = 8)
    public void step8_enterPass() {

        // User provides repetitive number, lowercase or uppercase letters in the password field
        vendorRegisterPage.passwordInput.sendKeys("1e1e1e1e");
    }

    @Test(priority = 9)
    public void step9_verifyGoodWarningIsVisible() {

        // Verify (Too short) text is visible under password field
        Assert.assertTrue( vendorRegisterPage.goodWarning.isDisplayed() );
    }

}
