package myapp.pages.US03_US18;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlloverCommerceMyAccountPage {
    public AlloverCommerceMyAccountPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//li[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--edit-address']") public WebElement addresses;
    @FindBy (xpath = "//h3[text()='Billing address']") public WebElement billingAddressHeader;
    @FindBy (xpath = "//a[@class='edit btn btn-link btn-primary btn-underline mb-4']") public WebElement billingAddressAddButton ;
    @FindBy (xpath = "//input[@id='billing_first_name']") public WebElement billingFirstNameField;
    @FindBy (xpath = "//input[@id='billing_last_name']") public WebElement billingLastName ;
    @FindBy (xpath = "//input[@id='billing_company']") public WebElement billingCompany;
    @FindBy (xpath = "//*[@id='billing_country']") public WebElement billingCountry;
    @FindBy (xpath = "//input[@id='billing_address_1']") public WebElement billingStreetAddress;
    @FindBy (xpath = "billing_address_2") public WebElement billingStreetAddress2;
    @FindBy (xpath = "//input[@id='billing_city']") public WebElement billingCity;
    @FindBy (xpath = "//input[@id='billing_postcode']") public WebElement billingPostCode;
    @FindBy (xpath = "//input[@id='billing_phone']") public WebElement billingPhone;
    @FindBy (xpath = "//input[@id='billing_email']") public WebElement billingEmail;
    @FindBy (xpath = "//span[text()='Select an option…']") public WebElement billingState;
    @FindBy (xpath = "//button[@name='save_address']") public WebElement saveAddressButton ;
    @FindBy (xpath = "//div[@role='alert']") public WebElement addressSuccessfullyChangedMessage;
    @FindBy(xpath = "//li[normalize-space()='First name is a required field.']") public WebElement firstNameErrorMSG;
    @FindBy (xpath = "//li[normalize-space()='Last name is a required field.']") public WebElement lastNameErrorMSG;
    @FindBy (xpath = "//li[normalize-space()='Country / Region is a required field.'] ") public WebElement countryErrorMSG;
    @FindBy (xpath = " //li[normalize-space()='Street address is a required field.']") public WebElement StreetErrorMSG;
    @FindBy (xpath = "//li[normalize-space()='Town / City is a required field.'] ") public WebElement cityErrorMSG;
    @FindBy (xpath = " //li[normalize-space()='State is a required field.']") public WebElement stateErrorMSG;
    @FindBy (xpath = " //li[normalize-space()='ZIP Code is a required field.']") public WebElement zipcodeErrorMSG;
    @FindBy (xpath = "//li[normalize-space()='Phone is a required field.'] ") public WebElement phoneErrorMSG;
    @FindBy (xpath = "//li[normalize-space()='Email address is a required field.'] ") public WebElement emailAddressErrorMSG;
    @FindBy(xpath = "//a[normalize-space()='Edit Your Billing Address']") public WebElement EditYourBillingAddressButton;





}
