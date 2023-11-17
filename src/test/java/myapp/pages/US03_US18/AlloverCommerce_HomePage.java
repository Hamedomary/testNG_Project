package myapp.pages.US03_US18;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlloverCommerce_HomePage {
    public AlloverCommerce_HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[text()='Sign In']") public WebElement signInLink;
    @FindBy (xpath = " //input[@name='username']") public WebElement UserName;
    @FindBy (xpath = "//input[@name='password']") public WebElement password;
    @FindBy (xpath = "//button[@value='Sign In']") public WebElement signInButton ;
    @FindBy(xpath = " //li[@id='menu-item-1079']//a[contains(text(),'My Account')]") public WebElement myAccount ;



}

