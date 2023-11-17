package myapp.pages.us11_us20;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US20Page {

    public US20Page() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='Sign In']")
    public static WebElement getSignIn;

    @FindBy(id = "username")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInSubmitButton;


    @FindBy(xpath = "//input[@aria-label='Search']")
    public WebElement searchButton;

    @FindBy(xpath = "//button[@name='add-to-cart']")
   public  WebElement addToCartButton;

    @FindBy(xpath = "//a[@class='cart-toggle']//i[@class='w-icon-cart']")
    public  WebElement cartButton;
    @FindBy(xpath="//a[@class='button wc-forward']")
    public  WebElement viewCartButton;

    // @FindBy(linkText = "View cart")
   // public WebElement viewCart;


    @FindBy(xpath = "//h4[@class='cart-title']")
    public WebElement shoppingCartInput;

    @FindBy(xpath = "//li[contains(text(),'Search results for “baby”')]")
    public WebElement searchResultBaby;

    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
    public WebElement proceedCheckout;

    @FindBy(xpath = "//h3[@id='order_review_heading']")
    public WebElement yourOrder;

    @FindBy(xpath = "//th[@class='product-quantity']")
    public WebElement quantityInput;

    @FindBy(xpath = "//li[contains(text(),'Search results for “baby”')]")
    public WebElement getSearchResultBaby;

   @FindBy(xpath = "//p[@class='alert alert-light alert-info woocommerce-info']")
    public WebElement noProductsFound;






}
