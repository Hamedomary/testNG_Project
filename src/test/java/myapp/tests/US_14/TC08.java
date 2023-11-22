package myapp.tests.US_14;

import myapp.pages.US_14.Allovercommerce;
import myapp.utilities.*;
import org.junit.Assert;
import org.testng.annotations.Test;

//Go to homepage
//        Click 'sign in'
//        Type Email
//        Type Password
//        Click 'sign in'
//        Click My Account
//        Click Store Manager
//        Click Product
//        Click Add New
//        Click the Dropdown
//        Verify Product brands options are exist

public class TC08 {

    @Test
    public void TC08(){
        Allovercommerce allovercommerce = new Allovercommerce();
        Driver.getDriver().get("https://allovercommerce.com");
        allovercommerce.login.click();
        allovercommerce.username.sendKeys(ConfigReader.getProperty("aoc_username"));
        allovercommerce.password.sendKeys(ConfigReader.getProperty("aoc_password"));
        allovercommerce.loginbutton.click();
        WaitUtils.waitFor(4);
        JSUtils.JSclickWithTimeout(allovercommerce.myAccountButton);
        WaitUtils.waitFor(2);
        allovercommerce.storeManager.click();
        WaitUtils.waitFor(2);
        allovercommerce.products.click();
        WaitUtils.waitFor(2);
        allovercommerce.addnew.click();
        Assert.assertTrue(allovercommerce.productBrands.getText().equals("Product brands"));
        //System.out.println(allovercommerce.productBrands.getText());


    }



}
