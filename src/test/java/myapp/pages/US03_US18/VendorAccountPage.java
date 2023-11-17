package myapp.pages.US03_US18;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorAccountPage {
    public VendorAccountPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[contains(text(),'My Account')]") public WebElement myAccountVendor;
    @FindBy(xpath = "//a[normalize-space()='Store Manager']") public WebElement storeManagerLink;
    @FindBy (xpath = "//span[normalize-space()='Coupons']") public WebElement couponsLink;
    @FindBy (xpath = "//span[contains(text(),'Add New')]") public WebElement addNewCouponButton;
    @FindBy (xpath = "//input[@id='title']") public WebElement codeField;
    @FindBy (xpath = "//textarea[@id='description']") public WebElement descriptionField;
    @FindBy(css = "#coupon_amount") public WebElement amountField;
    @FindBy (xpath = "//select[@id='discount_type']") public WebElement discountTypeDropDown;
    @FindBy (xpath = "//select[@aria-label='Select year']") public WebElement yearDropDown;
    @FindBy (xpath = "//select[@aria-label='Select month']") public WebElement monthDropDown;
    @FindBy (xpath = "/html[1]/body[1]/div[6]/table[1]/tbody[1]/tr[2]/td[4]/a[1]") public WebElement daySelection;
    @FindBy (xpath = "/html[1]/body[1]/div[6]/div[1]/a[2]/span[1]") public WebElement rightArrowDateChanger;
    @FindBy (xpath = "//span[@class='ui-icon ui-icon-circle-triangle-w']") public WebElement leftArrowDateChanger;
    @FindBy (xpath = "/html[1]/body[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/input[5]") public WebElement allowFreeShippingCheckbox;
    @FindBy (xpath = "//input[@id='show_on_store']") public WebElement showOnStoreCheckBox;
    @FindBy (xpath = "//input[@id='wcfm_coupon_manager_submit_button']") public WebElement submitButtonCoupon;
    @FindBy(xpath = "//div[@class='wcfm-message wcfm-success']") public WebElement couponSuccessfullyPublishedMessage;
    @FindBy (xpath = "//input[@aria-controls='wcfm-coupons']") public WebElement searchBar;
    @FindBy (xpath = "//td[@class='sorting_1']") public WebElement couponCreatedCode;
    @FindBy (xpath = "//span[@class='coupon-types coupon-types-fixed_product']") public WebElement percentageTypeSelected;
    @FindBy (xpath = "//div[@class='wcfm-message wcfm-error']") public WebElement couponTitleErrorMessage;
    @FindBy (xpath = "//tbody/tr[1]/td[5]") public WebElement expiryDateSelected;
    @FindBy (xpath = "//tfoot//th[contains(text(),'Amount')]") public WebElement amountEntered;
    @FindBy (xpath = "//input[@id='expiry_date']") public WebElement couponExpiryDate;
    @FindBy (xpath = "//span[@class='wcfmfa fa-trash-alt text_tip']") public WebElement deleteCouponButton;
    @FindBy (xpath = "//div[@class='wcfm-message wcfm-error']") public WebElement couponTitleISNeededErrorMessage1;

}
