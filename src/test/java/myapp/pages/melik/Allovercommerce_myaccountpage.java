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

    @FindBy(xpath = "//html[@lang='en-US']")
    public WebElement biography;



}
