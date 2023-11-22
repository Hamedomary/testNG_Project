package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Buying_Page {

    public void HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }




    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div/div/div[3]/div/div/form/input[2]")

    public WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[4]/ul/li[1]/div/figure/a/img[2]")

    public WebElement searchResultBag;


    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div/div/div[6]/div/div/a/i")

    public WebElement cartIcon;


    @FindBy(xpath="//*[@id=\"product-32667\"]/div[2]/div/form/div/div/div/button")

    public WebElement addToCartButton;


    @FindBy(xpath = "(//i[@class='w-icon-cart'])")

    public WebElement cartButton;


    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div/div/div[6]/div/div/div[2]/div/p[2]/a[2]")

    public WebElement checkOut;



    @FindBy(xpath = "//*[@id=\"place_order\"]")

    public WebElement placeOrderButton;


    @FindBy(xpath = "//*[@id=\"product-32667\"]/div[2]/div/form/div/div/div/div[2]/div/button[2]")

    public WebElement plusButton;


    @FindBy(xpath = "//*[@id=\"product-32667\"]/div[2]/div/form/div/div/div/div[2]/div/button[1]")

    public WebElement minusButton;


    @FindBy (xpath = "(//p[@class= 'woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success'])")

    public WebElement orderReceived;


    @FindBy(xpath = "//*[@id=\"payment_method_cod\"]")

    public WebElement payAtTheDoor;


    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/form[2]/div[1]/ul\n")

    public WebElement Error;














}