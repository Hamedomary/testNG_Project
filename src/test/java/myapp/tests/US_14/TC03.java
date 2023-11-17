package myapp.tests.US_14;

import myapp.pages.US_14.Allovercommerce;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.JSUtils;
import myapp.utilities.WaitUtils;
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
//        Type Product Title, Short Description and Description
//        Product Image is empty
//        Choose Categories
//        Click Submit Button
//        Verify that there is an error message  : Image is required

public class TC03 {
    @Test
    public void TC03(){
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
        allovercommerce.productTitle.sendKeys("asd12312");
        Driver.getDriver().switchTo().frame(allovercommerce.shortDescIframe);
        allovercommerce.shortDescription.sendKeys("asd23da");
        Driver.getDriver().switchTo().defaultContent();
        Driver.getDriver().switchTo().frame(allovercommerce.descriptionIframe);
        allovercommerce.description.sendKeys("asjkd3kjashdka");
        Driver.getDriver().switchTo().defaultContent();
        JSUtils.JSclickWithTimeout(allovercommerce.brandsList);
        JSUtils.JSclickWithTimeout(allovercommerce.categoriesList);
        WaitUtils.waitFor(2);
        JSUtils.JSclickWithTimeout(allovercommerce.submitData);
        WaitUtils.waitFor(1);
        Assert.assertTrue(allovercommerce.errorMessage.getText().contains("Featured img: This field is required"));

    }
}
