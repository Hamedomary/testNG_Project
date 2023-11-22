package myapp.pages.US_10;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorRegisterPage {

    public VendorRegisterPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.='Register']")
    public WebElement registerButton;

    @FindBy(id = "user_email")
    public WebElement emailInput;

    @FindBy(className = "email_verification_message")
    public WebElement verificationCodeSentMessage;

    @FindBy(id = "passoword")
    public WebElement passwordInput;

    @FindBy(xpath = "//div[@id=\"password_strength\" and @class=\"short\"]")
    public WebElement tooShortWarning;

    @FindBy(xpath = "//div[@id=\"password_strength\" and @class=\"weak\"]")
    public WebElement weakWarning;

    @FindBy(xpath = "//div[@id=\"password_strength\" and @class=\"good\"]")
    public WebElement goodWarning;

    @FindBy(xpath = "//div[@id=\"password_strength\" and @class=\"strong\"]")
    public WebElement strongWarning;

}
