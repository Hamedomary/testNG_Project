package myapp.pages.US_08;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Locators {
    public Locators(){
        PageFactory.initElements(Driver.getDriver(), this); }

    @FindBy(xpath = "//span[text()='Sign In']")
    public WebElement signIn;
    @FindBy(xpath = "(//input [@name='username'])[1]")
    public WebElement userName;
    @FindBy(xpath ="(//input [@name='password'])[1]")
    public WebElement password;
    @FindBy(xpath = "//button[@value='Sign In']")
    public WebElement signInButton;
    @FindBy(xpath = "//input[@aria-label='Search']")
    public WebElement searchBox;
    @FindBy(xpath = "(//button[@class='btn btn-search'])[1]")
    public WebElement searchEnter;
    @FindBy(xpath = "(//a[@href='https://allovercommerce.com/urun/home-sofa/'])[1]")
    public WebElement selectProduct;
    @FindBy(xpath = "//div[@data-product-id='13222']")
    public WebElement addProductWishlist;
    @FindBy(xpath = "//i[@class='w-icon-heart']")
    public WebElement wishlistButton;
    @FindBy(xpath = "(//td[@class='product-thumbnail'])[1]")
    public WebElement productInWishlist;
    @FindBy(xpath = "//ul[@id='menu-categories']/li")
    public List<WebElement>catalogItems;
    @FindBy(xpath = "//ul[@data-col-list=\" row cols-sm-1 cols-2\"]/li")
    public List<WebElement>catalogProduct;
    @FindBy (xpath = "//div/a[@data-product-id='13232']")
    public WebElement addCatalogProductToWishList;
    @FindBy(xpath ="//i[@class='w-icon-heart']" )
    public WebElement clickMyWishlist;
    @FindBy(xpath = "//button[@title='Quick View']")
    public WebElement seeQuickView;
    @FindBy(xpath = "//div[@class='mfp-content']")
    public WebElement productdetails;
    @FindBy(xpath = "//a[@data-product_id='13232']")
    public WebElement addProductCard;
    @FindBy(xpath = "//a[@class='cart-toggle']/i[@class='w-icon-cart']")
    public WebElement openCart;
    @FindBy(xpath = "//div[@data-fragment-ref='13232']")
    public WebElement productInWishlistss;
    @FindBy(xpath = "//button[@name='add-to-cart']")
    public WebElement addtocart;
    @FindBy(xpath = "//a[@class='button checkout wc-forward']")
    public WebElement clickCheckout;
    @FindBy(xpath = "//span/input[@name='billing_first_name']")
    public WebElement firstName;
    @FindBy(xpath = "//span/input[@name='billing_last_name']")
    public WebElement lastName;
    @FindBy(xpath = "(//span[@class='select2-selection__rendered'])[1]")
    public WebElement country;

    @FindBy(xpath = "//select[@name='billing_country']")
    public WebElement country1;

    @FindBy(xpath = "(//span/input[@placeholder='House number and street name'])[1]")
    public WebElement streetAddress;
    @FindBy(xpath = "//span/input[@name='billing_city']")
    public WebElement townCity;
    @FindBy(xpath ="(//span/span[@aria-label='State'])[1]")
    public WebElement state;
    @FindBy(xpath ="//span/input[@name='billing_postcode']")
    public WebElement zipCode;
    @FindBy(xpath ="//span/input[@name='billing_phone']")
    public WebElement phone;
    @FindBy(xpath ="//span/input[@name='billing_email']")
    public WebElement email;
    @FindBy(xpath = "//button[@id='place_order']")
    public WebElement placeOrder;
    @FindBy(xpath = "//*[text()='Thank you. Your order has been received.']")
    public WebElement orderComplete;













}
