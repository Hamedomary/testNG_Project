package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.='Register']")
    public WebElement registerButton;

    @FindBy(xpath = "//a[.='Signup as a vendor?']")
    public WebElement signupAsVendorLink;

}
