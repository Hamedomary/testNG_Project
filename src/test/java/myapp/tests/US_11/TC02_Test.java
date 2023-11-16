package myapp.tests.US_11;

import myapp.pages.AlloverLoginPage;

import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


import static myapp.utilities.Driver.driver;
import static myapp.utilities.JSUtils.flashElement;
import static org.testng.AssertJUnit.assertTrue;

public class TC02_Test {

    @Test
    public void loginTest() throws InterruptedException {

        Driver.getDriver().get("https://allovercommerce.com");

        AlloverLoginPage alloverLoginPage = new AlloverLoginPage();

        flashElement(alloverLoginPage.getSignIn);
        alloverLoginPage.getSignIn.click();

        flashElement(alloverLoginPage.usernameInput);
        alloverLoginPage.usernameInput.sendKeys("gulbulozoktemgmailcom");
        //  assertTrue(alloverLoginPage.usernameInput.isDisplayed);
        WaitUtils.waitFor(2);


        flashElement(alloverLoginPage.passwordInput);
        alloverLoginPage.passwordInput.sendKeys("12345");
        //assertTrue(alloverLoginPage.passwordInput.isDisplayed);
        WaitUtils.waitFor(2);

        alloverLoginPage.signInSubmitButton.click();
        WaitUtils.waitFor(2);

        Driver.closeDriver();



    }


}

