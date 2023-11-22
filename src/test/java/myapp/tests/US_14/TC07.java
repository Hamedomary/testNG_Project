package myapp.tests.US_14;

import myapp.pages.US_14.Allovercommerce;
import myapp.utilities.*;
import org.testng.Assert;
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
//        Click Add new Product Brand
//        Type Brand Name
//        Choose Parent Taxonomy
//        Click Add
//        Verify new Brand was added

public class TC07 {
    @Test
    public void TC07(){
        Allovercommerce allovercommerce = new Allovercommerce();
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce"));
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
        WaitUtils.waitFor(1);
        JSUtils.JSclickWithTimeout(allovercommerce.addNewBrand);
        WaitUtils.waitFor(1);
        allovercommerce.brandName.sendKeys("salvadorwashere");
        int random = (int)(Math.random() * 20 + 1);
        BrowserUtils.dropdownSelectByIndex(allovercommerce.parentBrandDropdown,random);
        WaitUtils.waitFor(1);
        JSUtils.JSclickWithTimeout(allovercommerce.addNewBrandButton);
        WaitUtils.waitFor(3);
        Assert.assertTrue(allovercommerce.addedBrand.getText().contains("salvadorwashere"));
    }
}
