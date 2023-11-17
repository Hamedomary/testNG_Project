package myapp.pages.melik;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AC_loginpage {


    public AC_loginpage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(id = "username")
    public WebElement usurname;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement signInButton;

}