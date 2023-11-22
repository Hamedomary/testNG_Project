package myapp.pages.US_06;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Billing_Page {

    public void HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "//*[@id=\"billing_first_name\"]")

    public WebElement billingDetailsName;



    @FindBy(xpath = "//*[@id=\"billing_last_name\"]")

    public WebElement billingDetailsLastName;



    @FindBy(xpath = "//*[@id=\"billing_company\"]")

    public WebElement billingDetailsCompany;



    @FindBy(xpath = "//*[@id=\"select2-billing_country-container\"]")

    public WebElement billingDetailsCountry;


    @FindBy(xpath = "//*[@id=\"billing_address_1\"]")

    public WebElement billingDetailsStreet;



    @FindBy(xpath = "//*[@id=\"billing_city\"]")

    public WebElement billingDetailsCity;



    @FindBy(xpath = "//*[@id=\"select2-billing_state-container\"]")

    public WebElement billingDetailsState;


    @FindBy(xpath = "//*[@id=\"billing_postcode\"]")

    public WebElement billingDetailsZip;


    @FindBy(xpath = "//*[@id=\"billing_phone\"]")

    public WebElement billingDetailsPhone;



    @FindBy(xpath = "//*[@id=\"billing_email\"]")

    public WebElement billingDetailsEmail;













}
