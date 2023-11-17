package myapp.tests.US_18;

import myapp.pages.US03_US18.AlloverCommerce_HomePage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;

public class ReusableMethods {

    public static void logInMethod(){
        AlloverCommerce_HomePage alloverCommerceHomePage = new AlloverCommerce_HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        alloverCommerceHomePage.signInLink.click();
        BrowserUtils.sendKeysWithTimeout(alloverCommerceHomePage.UserName,ConfigReader.getProperty("VendorSingInEmail_18"),1);
        BrowserUtils.sendKeysWithTimeout(alloverCommerceHomePage.password,ConfigReader.getProperty("vendorPassword_18"), 1);
        alloverCommerceHomePage.signInButton.click();
    }


    public static void closeDriver(){
        WaitUtils.waitFor(2);
        Driver.getDriver().quit();
    }
}
