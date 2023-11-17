package myapp.pages.melik;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AC_checkoutpage {


    public AC_checkoutpage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy (xpath = "//a[@class='button checkout wc-forward']")
    public WebElement checkoutButton;

    @FindBy (xpath = "//li[@class='current']//a[contains(text(),'Checkout')]")
    public WebElement checkoutPage;

    @FindBy (xpath = "//td[@class='product-name']")
    public WebElement successfullyAdded;

    @FindBy (xpath = "//tr[@class='order-total']//bdi[1]")
    public WebElement totalAmount;

    @FindBy (id = "billing_first_name")
    public WebElement firstName;

    @FindBy (id = "billing_last_name")
    public WebElement lastName;

    @FindBy (id = "billing_company")
    public WebElement companyName;

    @FindBy (id = "billing_address_1")
    public WebElement address;

    @FindBy (id = "billing_postcode")
    public WebElement postcode;

    @FindBy (id = "billing_phone")
    public WebElement phone;

    @FindBy(id = "billing_email")
    public WebElement email;

    @FindBy(xpath = "//span[normalize-space()='Ship to a different address?']")
    public WebElement shippingAddressClickable;

}
