package myapp.pages.US_10;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    public MyAccountPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "username")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

//    @FindBy(xpath = "//*[@id=\"signin\"]/form/button")
    @FindBy(name = "login")
    public WebElement signinButton;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/div/div[2]/div/div/div[3]/div/a")
    public WebElement addressButton;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/div/div[3]/div[1]/div/a")
    public WebElement addressAddButton;

    @FindBy(id = "billing_first_name")
    public WebElement billingFirstName;

    @FindBy(id = "billing_last_name")
    public WebElement billingLastName;

    @FindBy(id = "billing_country")
    public WebElement billingCountry;

    @FindBy(id = "billing_address_1")
    public WebElement billingAddress1;

    @FindBy(id = "billing_city")
    public WebElement billingCity;

    @FindBy(id = "billing_postcode")
    public WebElement billingZipCode;

    @FindBy(id = "billing_phone")
    public WebElement billingPhone;

    @FindBy(id = "billing_email")
    public WebElement billingEmail;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/div/form/div/p/button")
//    @FindBy(name = "save_address")
    public WebElement billingSaveAddressButton;


    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/div/div[3]/div[1]/div/a")
    public WebElement billingEditAddressButton;







}
