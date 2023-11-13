package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "username")
    public WebElement userName;

    @FindBy(xpath = "//a[.='Sign In']")
    public WebElement signInButton;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(name = "login")
    public WebElement signInButtonInPopUp;

    @FindBy(xpath = "//a[.='My Account']")
    public WebElement myAccount;

//    public WebElement openTab(String name){
//        return Driver.getDriver().findElement(By.xpath("//a[.='" + name + "']"));
//    }



}
