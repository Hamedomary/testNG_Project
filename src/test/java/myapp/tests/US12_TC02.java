package myapp.tests;

import myapp.utilities.BrowserUtils;
import myapp.utilities.Driver;
import myapp.utilities.JSUtils;
import myapp.utilities.WaitUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class US12_TC02 {

    @Test
    public void test02(){
        //Go to homepage
        Driver.getDriver().get("https://allovercommerce.com/");
        Driver.getDriver().findElement(By.xpath("//a[@class='login inline-type']")).click();

        //Enter your account username
        Driver.getDriver().findElement(By.xpath("//input[@id='username']")).sendKeys("zehrademir92@icloud.com");
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("Italia.92");
        Driver.getDriver().findElement(By.xpath("//button[@name='login']")).click();
        WaitUtils.waitFor(3);
        JSUtils.JSclickWithTimeout(Driver.getDriver().findElement(By.linkText("My Account")));
        WaitUtils.waitFor(2);
        JSUtils.JSclickWithTimeout(Driver.getDriver().findElement(By.linkText("Addresses")));
        WaitUtils.waitFor(2);
        JSUtils.JSclickWithTimeout(Driver.getDriver().findElement(By.xpath("//*[@class='edit btn btn-link btn-primary btn-underline mb-4']")));
        WaitUtils.waitFor(2);

        BrowserUtils.verifyElementDisplayed(Driver.getDriver().findElement(By.xpath("//*[@value='Zehra']")));
        BrowserUtils.verifyElementDisplayed(Driver.getDriver().findElement(By.xpath("//*[@value='Demir']")));
        BrowserUtils.verifyElementDisplayed(Driver.getDriver().findElement(By.xpath("//*[@value='zehrademir92@icloud.com']")));

        BrowserUtils.dropdownSelectByIndex(Driver.getDriver().findElement(By.xpath("//select[@id = 'billing_country']")),4);
        Driver.getDriver().findElement(By.xpath("//*[@id='billing_address_1']")).clear();
        Driver.getDriver().findElement(By.xpath("//*[@id='billing_postcode']")).clear();
        Driver.getDriver().findElement(By.xpath("//*[@id='billing_phone']")).clear();
        Driver.getDriver().findElement(By.xpath("//*[@id='billing_city']")).clear();
        JSUtils.JSclickWithTimeout(Driver.getDriver().findElement(By.xpath("//button[@name='save_address']")));
        WaitUtils.waitFor(2);

        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[@data-id='billing_address_1']")).getText().contains("required"));
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[@data-id='billing_postcode']")).getText().contains("required"));
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[@data-id='billing_phone']")).getText().contains("required"));
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[@data-id='billing_city']")).getText().contains("required"));
    }

}

