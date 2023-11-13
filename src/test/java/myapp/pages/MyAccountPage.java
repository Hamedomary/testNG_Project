package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    public MyAccountPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


//    public WebElement openTab(String name){
//        return Driver.getDriver().findElement(By.xpath("//a[.='" + name + "']"));
//    }

    @FindBy(xpath = "//a[.='Addresses']")
    public WebElement addresses;

    @FindBy(xpath = "(//a[@class='edit btn btn-link btn-primary btn-underline mb-4'])[2]")
    public WebElement addAddress;

    @FindBy(id = "shipping_first_name")
    public WebElement firstName;

    @FindBy(id = "shipping_last_name")
    public WebElement lastName;

    @FindBy(id = "shipping_company")
    public WebElement companyName;

    @FindBy(id = "select2-shipping_country-container")
    public WebElement countryRegion;

    @FindBy(id = "shipping_address_1")
    public WebElement streetAddress;

    @FindBy(id = "shipping_city")
    public WebElement townCity;

    @FindBy(id = "sselect2-shipping_state-container")
    public WebElement state;

    @FindBy(id = "shipping_postcode")
    public WebElement zipCode;

    @FindBy(name = "save_address")
    public WebElement saveAddress;



}
