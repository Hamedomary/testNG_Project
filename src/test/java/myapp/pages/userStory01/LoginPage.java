package myapp.pages.userStory01;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[.='Register']")
    public WebElement registerButton;

    @FindBy(id="reg_username")
    public WebElement registerUserName;

    @FindBy(id="reg_email")
    public WebElement registerEmail;

    @FindBy(id="reg_password")
    public WebElement registerPassword;

    @FindBy(id="register-policy")
    public WebElement privacyCheckbox;

    @FindBy(name="register")
    public WebElement registerSignUp;

    @FindBy(xpath = "//a[.='My Account']")
    public WebElement myAccountText;

    @FindBy(id = "customer_login")
    public WebElement loginPopup;

    @FindBy(xpath = "//a[@class='login logout inline-type']")
    public WebElement signOutButton;

    @FindBy(xpath = "//a[text()='Log out']")
    public WebElement logOutButton;

}
