package myapp.pages.US_06;

import myapp.utilities.Driver;
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

    @FindBy(id = "register-policy")
    public WebElement privacyPolicy;

    @FindBy(xpath = "//a[.='Register']")
    public WebElement registerButton;

    @FindBy(id = "reg_username")
    public WebElement registerUserName;

    @FindBy(id = "reg_email")
    public WebElement registerEmail;

    @FindBy(id = "reg_password")
    public WebElement registerPassword;

    @FindBy(name = "register")
    public WebElement registerSignUp;



//    public WebElement openTab(String name){
//        return Driver.getDriver().findElement(By.xpath("//a[.='" + name + "']"));
//    }


}
