package myapp.tests.US_11;

import myapp.pages.us11_us20.AlloverLoginPage;

import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.testng.annotations.Test;


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

