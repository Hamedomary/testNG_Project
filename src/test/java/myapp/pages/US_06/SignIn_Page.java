package myapp.pages.US_06;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn_Page {


    public SignIn_Page() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"username\"][1]")
    public WebElement userName;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div/div/div[9]/div/div/a[1]/span")
    public WebElement signInIcon;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(name = "login")
    public WebElement signInButton;




}
