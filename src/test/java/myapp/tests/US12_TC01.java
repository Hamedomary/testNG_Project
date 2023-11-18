package myapp.tests;

import myapp.utilities.BrowserUtils;
import myapp.utilities.Driver;
import myapp.utilities.JSUtils;
import myapp.utilities.WaitUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class US12_TC01 {
    @Test
    public void test(){

        //Go to homepage
        Driver.getDriver().get("https://allovercommerce.com/");
        //Click on "sing in" button QUI C'è UN PROBLEMA
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


        BrowserUtils.dropdownSelectByIndex(Driver.getDriver().findElement(By.xpath("//select[@id = 'billing_country']")),5);
        Driver.getDriver().findElement(By.xpath("//*[@id='billing_address_1']")).sendKeys("Via Etruria, 47");
        Driver.getDriver().findElement(By.xpath("//*[@id='billing_postcode']")).sendKeys("58742");
        Driver.getDriver().findElement(By.xpath("//*[@id='billing_phone']")).sendKeys("0123456789");
        Driver.getDriver().findElement(By.xpath("//*[@id='billing_city']")).sendKeys("Rome");
        Driver.getDriver().findElement(By.xpath("//*[@id='billing_state']")).sendKeys("Lazio");
        BrowserUtils.verifyElementDisplayed(Driver.getDriver().findElement(By.xpath("//*[@value='Zehra']")));
        BrowserUtils.verifyElementDisplayed(Driver.getDriver().findElement(By.xpath("//*[@value='Demir']")));
        BrowserUtils.verifyElementDisplayed(Driver.getDriver().findElement(By.xpath("//*[@value='zehrademir92@icloud.com']")));
        JSUtils.JSclickWithTimeout(Driver.getDriver().findElement(By.xpath("//button[@name='save_address']")));
        WaitUtils.waitFor(2);
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[@class = 'woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']")).getText().contains("success"));







    }
    @Test
    public void test2(){


    }



    //Enter your passord
    //Click  on "sing in" button
    //Click on "My Account"
    //Click on Addresses
    //Click on "Add" button to add Billing Address
    //Verify user's(First name, lastname and email adress) come automatically
    //Enter the First name in the first name field
    //Enter the Last name in the last name field
    //Enter the Email address in the email address field
    //Provide a Country/Region in the country/region field
    //Enter the Street Address in the street address field
    //Enter the ZIP Code in the zip code field
    //Enter the Town/City in the town/city field
    //Enter the Phone in the phone field
    //Verify that the Save Address button is visibile
    //Click on the Save Address button
    //Verify that " Address changed successfully." message is visibile.
}

