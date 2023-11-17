package myapp.tests;

import myapp.pages.Allovercommerce;
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
//        Click Add new Category
//        Type Category Name
//        Choose Parent Category
//        Click Add
//        Verify New Category was added

public class TC06 {
    @Test
    public void TC06(){
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
        JSUtils.JSclickWithTimeout(allovercommerce.addNewCategory);
        WaitUtils.waitFor(1);
        allovercommerce.categoryName.sendKeys("salvadorwashere");
        int random = (int)(Math.random() * 20 + 1);
        BrowserUtils.dropdownSelectByIndex(allovercommerce.parentCategoryDropdown,random);
        WaitUtils.waitFor(1);
        JSUtils.JSclickWithTimeout(allovercommerce.addNewCategoryButton);
        WaitUtils.waitFor(3);
        Assert.assertTrue(allovercommerce.addedCategory.getText().contains("salvadorwashere"));


    }
}
