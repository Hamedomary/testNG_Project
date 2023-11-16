package myapp.tests.projectss;

import com.sun.jna.StringArray;
import myapp.pages.Allovercommerce;
import myapp.utilities.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class TC01 {

    @Test
    public void TC01(){
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
        String[] products = {"Simple Product", "Variable Product", "Grouped Product", "External/Affiliate Product"};
        for (int i = 0; i <4 ; i++) {
            Assert.assertTrue(allovercommerce.productDropdown.getText().contains(products[i]));
            System.out.println(products[i]);
        }

    }
}
