package myapp.tests.US_14;

import myapp.pages.US_14.Allovercommerce;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.JSUtils;
import myapp.utilities.WaitUtils;
import org.openqa.selenium.By;
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
//        Leave any of Product Title, Short Description and Description
//        Add Product Image
//        Choose Categories
//        Click Submit Button
//        Verify that there is an error message  : Description or Product Title or Short Description is required

public class TC05 {
    @Test
    public void TC05_withoutProductTitle(){
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
        Driver.getDriver().switchTo().frame(allovercommerce.shortDescIframe);
        allovercommerce.shortDescription.sendKeys("asd23da");
        Driver.getDriver().switchTo().defaultContent();
        Driver.getDriver().switchTo().frame(allovercommerce.descriptionIframe);
        allovercommerce.description.sendKeys("asjkd3kjashdka");
        Driver.getDriver().switchTo().defaultContent();
        JSUtils.JSclickWithTimeout(allovercommerce.brandsList);
        JSUtils.JSclickWithTimeout(allovercommerce.categoriesList);
        JSUtils.JSclickWithTimeout(allovercommerce.imageToClick);
        allovercommerce.fileUpload.sendKeys("C:\\Users\\musta\\OneDrive\\Desktop\\indir.png");
        WaitUtils.waitFor(2);
        JSUtils.JSclickWithTimeout(allovercommerce.fileUploadSelect);
        WaitUtils.waitFor(2);
        JSUtils.JSclickWithTimeout(allovercommerce.galleryImageToClick);
        WaitUtils.waitFor(2);
        JSUtils.JSclickWithTimeout(Driver.getDriver().findElement(By.xpath("//*[@id='__attachments-view-122']/li[1]")));
        WaitUtils.waitFor(3);
        JSUtils.JSclickWithTimeout(allovercommerce.imageUploadGalery);
        WaitUtils.waitFor(2);
        JSUtils.JSclickWithTimeout(allovercommerce.submitData);
        WaitUtils.waitFor(2);
        Assert.assertTrue(allovercommerce.errorMessage.getText().contains("Please insert Product Title before submit"));
    }

    @Test
    public void TC05_withoutShortDesc(){
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
        Driver.getDriver().switchTo().defaultContent();
        Driver.getDriver().switchTo().frame(allovercommerce.descriptionIframe);
        allovercommerce.description.sendKeys("asjkd3kjashdka");
        Driver.getDriver().switchTo().defaultContent();
        JSUtils.JSclickWithTimeout(allovercommerce.brandsList);
        JSUtils.JSclickWithTimeout(allovercommerce.categoriesList);
        JSUtils.JSclickWithTimeout(allovercommerce.imageToClick);
        allovercommerce.fileUpload.sendKeys("C:\\Users\\musta\\OneDrive\\Desktop\\indir.png");
        WaitUtils.waitFor(2);
        JSUtils.JSclickWithTimeout(allovercommerce.fileUploadSelect);
        WaitUtils.waitFor(2);
        JSUtils.JSclickWithTimeout(allovercommerce.galleryImageToClick);
        WaitUtils.waitFor(2);
        JSUtils.JSclickWithTimeout(Driver.getDriver().findElement(By.xpath("//*[@id='__attachments-view-122']/li[1]")));
        WaitUtils.waitFor(3);
        JSUtils.JSclickWithTimeout(allovercommerce.imageUploadGalery);
        WaitUtils.waitFor(2);
        JSUtils.JSclickWithTimeout(allovercommerce.submitData);
        WaitUtils.waitFor(2);
        Assert.assertTrue(allovercommerce.errorMessage.getText().contains("Please insert Short Description before submit"));

    }

    @Test
    public void TC05_withoutDesc(){
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
        JSUtils.JSclickWithTimeout(allovercommerce.brandsList);
        JSUtils.JSclickWithTimeout(allovercommerce.categoriesList);
        JSUtils.JSclickWithTimeout(allovercommerce.imageToClick);
        allovercommerce.fileUpload.sendKeys("C:\\Users\\musta\\OneDrive\\Desktop\\indir.png");
        WaitUtils.waitFor(2);
        JSUtils.JSclickWithTimeout(allovercommerce.fileUploadSelect);
        WaitUtils.waitFor(2);
        JSUtils.JSclickWithTimeout(allovercommerce.galleryImageToClick);
        WaitUtils.waitFor(2);
        JSUtils.JSclickWithTimeout(Driver.getDriver().findElement(By.xpath("//*[@id='__attachments-view-122']/li[1]")));
        WaitUtils.waitFor(3);
        JSUtils.JSclickWithTimeout(allovercommerce.imageUploadGalery);
        WaitUtils.waitFor(2);
        JSUtils.JSclickWithTimeout(allovercommerce.submitData);
        WaitUtils.waitFor(2);
        Assert.assertTrue(allovercommerce.errorMessage.getText().contains("Please insert Description before submit"));
    }
}
