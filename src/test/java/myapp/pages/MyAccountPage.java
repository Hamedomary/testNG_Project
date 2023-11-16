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

    @FindBy(id = "shipping_country")
    public WebElement countryRegion;

    @FindBy(id = "shipping_address_1")
    public WebElement streetAddress;

    @FindBy(id = "shipping_city")
    public WebElement townCity;

    @FindBy(id = "shipping_state")
    public WebElement state;

    @FindBy(id = "shipping_postcode")
    public WebElement zipCode;

    @FindBy(name = "save_address")
    public WebElement saveAddress;

    @FindBy(xpath = "//li[contains(@class,'alert-danger')]")
    public WebElement errorMessage;

    @FindBy(xpath = "//div[@role='alert']")
    public  WebElement successMessage;

    @FindBy(xpath = "//a[.='Store Manager']")
    public WebElement storeManager;

    @FindBy(xpath = "//a[contains(.,'Products')]")
    public WebElement products;

    @FindBy(xpath = "//span[contains(@class,'text') and text()='Add New']")
    public WebElement addNewButton;

    @FindBy(id = "pro_title")
    public WebElement productTitle;

    @FindBy(xpath = "//button[@class='button insert-media add_media']")
    public WebElement shortDiscAddMedia;

    @FindBy(xpath = "(//button[@class='button insert-media add_media'])[2]")
    public WebElement discriptionAddMedia;

    @FindBy(name = "product_cats[]")
    public WebElement categories;

    @FindBy(id = "sku")
    public WebElement sku;

    @FindBy(id = "manage_stock")
    public WebElement manageStock;

    @FindBy(id = "sold_individually")
    public WebElement soldIndividually;

    @FindBy(id = "stock_qty")
    public WebElement stockQty;

    @FindBy(id = "wcfm_products_manage_form_shipping_head")
    public WebElement shipping;

    @FindBy(id = "weight")
    public WebElement weight;

    @FindBy(id = "length")
    public WebElement length;

    @FindBy(id = "height")
    public WebElement height;

    @FindBy(id = "width")
    public WebElement width;

    @FindBy(id = "wcfm_products_manage_form_attribute_head")
    public WebElement attributes;

    @FindBy(id = "attributes_is_active_1")
    public WebElement color;

    @FindBy(xpath = "//p[contains(.,'Size')]")
    public WebElement size;

    @FindBy(name = "submit-data")
    public WebElement submitButton;

    @FindBy(id = "__wp-uploader-id-1")
    public WebElement selectFile;

    @FindBy(id = "featured_img_display")
    public WebElement img;

    @FindBy(xpath = "//*[@type='file']")
    public WebElement fileUpload;

    @FindBy(xpath = "(//div[@class='thumbnail'])[1]")
    public WebElement flower1;

    @FindBy(xpath = "(//button[contains(.,'Select')])[8]")
    public WebElement select;

    @FindBy(xpath = "//button[contains(.,'Insert into post')]")
    public WebElement insertIntoPost;

    @FindBy(xpath = "//div[@class='thumbnail']")
    public WebElement selectFlower;



















}
