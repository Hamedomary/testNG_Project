package myapp.pages.US11_US20;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlloverLoginPage {

    public AlloverLoginPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='Sign In']")
    public WebElement getSignIn;

    @FindBy(id = "username")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInSubmitButton;


    @FindBy(linkText = "My Account")
    public WebElement myAccountInput;

    @FindBy(linkText = "Store Manager")
    public WebElement storeManagerButton;

    @FindBy(linkText = "Orders")
    public WebElement ordersButton;

    @FindBy(linkText = "Downloads")
    public WebElement downloadsButton;

    @FindBy(linkText = "Addresses")
    public WebElement addressesButton;

    @FindBy(linkText = "Account details")
    public WebElement accountDetailsButton;

    @FindBy(linkText = "Wishlist")
    public WebElement wishlistButton;

    @FindBy(linkText = "Support Tickets")
    public WebElement supportTicketsButton;

    @FindBy(linkText = "Followings")
    public WebElement followingButton;

    @FindBy(linkText = "Logout")
    public WebElement logoutButton;




}

