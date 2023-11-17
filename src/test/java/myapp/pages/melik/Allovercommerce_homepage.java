package myapp.pages.melik;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Allovercommerce_homepage {


    public Allovercommerce_homepage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.='Sign In']")
    public WebElement signIn;

    @FindBy(partialLinkText = "My Account")
    public WebElement MyAccount;







}
