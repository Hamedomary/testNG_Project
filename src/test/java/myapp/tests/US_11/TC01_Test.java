package myapp.tests.US_11;

import myapp.pages.us11_us20.AlloverLoginPage;

import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.testng.annotations.Test;


import static myapp.utilities.JSUtils.flashElement;
import static org.testng.AssertJUnit.assertTrue;

public class TC01_Test {

    @Test
    public void loginTest() throws InterruptedException {

        Driver.getDriver().get("https://allovercommerce.com");

        AlloverLoginPage alloverLoginPage = new AlloverLoginPage();

        flashElement(alloverLoginPage.getSignIn);
        alloverLoginPage.getSignIn.click();

        flashElement(alloverLoginPage.usernameInput);
        alloverLoginPage.usernameInput.sendKeys("gulbulozoktem@gmail.com");

        WaitUtils.waitFor(2);


        flashElement(alloverLoginPage.passwordInput);
        alloverLoginPage.passwordInput.sendKeys("nsngl2023@");

        WaitUtils.waitFor(2);

        alloverLoginPage.signInSubmitButton.click();
        WaitUtils.waitFor(2);

        Driver.closeDriver();


        }



    }




