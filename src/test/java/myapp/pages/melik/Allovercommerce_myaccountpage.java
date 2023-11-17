package myapp.pages.melik;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Allovercommerce_myaccountpage {


    public Allovercommerce_myaccountpage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "//h2[@class='page-title']")
    public WebElement myAccountText;

    @FindBy(xpath = "//a[.='Account details']")
    public WebElement accountDetails;

    @FindBy(id = "account_first_name")
    public WebElement firstName;

    @FindBy(id = "account_last_name")
    public WebElement lastname;

    @FindBy(id = "account_display_name")
    public WebElement displayName;

    @FindBy(id = "account_email")
    public WebElement email;

    @FindBy(id = "user_description_ifr")
    public WebElement biography;

    @FindBy(id = "password_current")
    public WebElement current_password;

    @FindBy(id = "password_1")
    public WebElement new_password;

    @FindBy(id = "password_2")
    public WebElement confirm_password;

    @FindBy(xpath = "//*[@value='Save changes']")
    public WebElement saveChangesButton;

    @FindBy(xpath = "//*[@class='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']")
    public WebElement successfullSaved;




}
