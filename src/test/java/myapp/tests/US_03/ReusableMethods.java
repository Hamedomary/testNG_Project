package myapp.tests.US_03;

import myapp.pages.US03_US18.AlloverCommerceMyAccountPage;
import myapp.pages.US03_US18.AlloverCommerce_HomePage;
import myapp.utilities.*;
import org.openqa.selenium.support.ui.Select;

public class ReusableMethods {
    public static void logInMethod(){
        AlloverCommerce_HomePage alloverCommerceHomePage = new AlloverCommerce_HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        alloverCommerceHomePage.signInLink.click();
        BrowserUtils.sendKeysWithTimeout(alloverCommerceHomePage.UserName,ConfigReader.getProperty("US03_UserName"),1);
        BrowserUtils.sendKeysWithTimeout(alloverCommerceHomePage.password,ConfigReader.getProperty("US03_Password"), 1);
        alloverCommerceHomePage.signInButton.click();

    }

    public static void clearMethod(){
       AlloverCommerceMyAccountPage  alloverCommerceMyAccountPage =new AlloverCommerceMyAccountPage();
        if(alloverCommerceMyAccountPage.billingEmail.isDisplayed()){
            alloverCommerceMyAccountPage.billingFirstNameField.clear();
            alloverCommerceMyAccountPage.billingLastName.clear();
            alloverCommerceMyAccountPage.billingCompany.clear();
            alloverCommerceMyAccountPage.billingStreetAddress.clear();
            alloverCommerceMyAccountPage.billingPostCode.clear();
            alloverCommerceMyAccountPage.billingCity.clear();
            alloverCommerceMyAccountPage.billingPhone.clear();
        }else{
            alloverCommerceMyAccountPage.saveAddressButton.click();
        }

    }
    public static void fillingMethod(){
        AlloverCommerceMyAccountPage alloverCommerceMyAccountPage = new AlloverCommerceMyAccountPage();
        BrowserUtils.sendKeysWithTimeout(alloverCommerceMyAccountPage.billingFirstNameField,"Boss11",1);
        BrowserUtils.sendKeysWithTimeout(alloverCommerceMyAccountPage.billingLastName,"german",1);
        alloverCommerceMyAccountPage.billingCompany.sendKeys("Foret");
        WaitUtils.waitFor(5);
        Select select = new Select(alloverCommerceMyAccountPage.billingCountry);
        WaitUtils.waitFor(3);
        select.selectByVisibleText("Afghanistan");
        JSUtils.JSscrollIntoView(alloverCommerceMyAccountPage.billingStreetAddress);
        BrowserUtils.sendKeysWithTimeout(alloverCommerceMyAccountPage.billingStreetAddress,"calle sagra",1);
        JSUtils.JSscrollIntoView(alloverCommerceMyAccountPage.billingPostCode);
        WaitUtils.waitFor(1);
        BrowserUtils.sendKeysWithTimeout(alloverCommerceMyAccountPage.billingPostCode,"12456",1);
        JSUtils.JSscrollIntoView(alloverCommerceMyAccountPage.billingCity);
        WaitUtils.waitFor(2);
        BrowserUtils.sendKeysWithTimeout(alloverCommerceMyAccountPage.billingCity,"Leganes",1);
        BrowserUtils.sendKeysWithTimeout(alloverCommerceMyAccountPage.billingPhone,"604285365",1);
    }

    public static void closeDriver()
    {
        Driver.getDriver().quit();
    }

    }
