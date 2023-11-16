package myapp.tests;

import myapp.pages.Allovercommerce;
import myapp.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        allovercommerce.categoryName.sendKeys("team02salvador");
        int random = (int)(Math.random() * 20 + 1);
        BrowserUtils.dropdownSelectByIndex(allovercommerce.parentCategoryDropdown,random);
        WaitUtils.waitFor(1);
        JSUtils.JSclickWithTimeout(allovercommerce.addNewCategoryButton);
        WaitUtils.waitFor(1);
        Assert.assertTrue(allovercommerce.addedCategory.isSelected());


    }
}
