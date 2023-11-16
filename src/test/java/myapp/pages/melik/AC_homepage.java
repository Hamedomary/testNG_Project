package myapp.pages.melik;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AC_homepage {


    public AC_homepage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[normalize-space()='Sign In']")
    public WebElement signIn;

    @FindBy(xpath = "//a[contains(text(),'My Account')]")
    public WebElement MyAccount;

    @FindBy(xpath = "//button[@value='13206']")
    public WebElement addToChart;

    @FindBy(xpath = "//h2[@class='elementor-heading-title elementor-size-default']")
    public WebElement dealsHotOfTheDay;

    @FindBy(xpath = "(//button[@class='slider-button slider-button-next'])[1]")
    public WebElement nextPageSign;








}
