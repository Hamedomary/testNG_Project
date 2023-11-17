package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Allovercommerce {
    public Allovercommerce(){
        PageFactory.initElements(Driver.getDriver(),this);}
    @FindBy(xpath = "//a[@class='login inline-type']")
    public WebElement login;
    @FindBy(xpath = "//input[@name='username']")
    public WebElement username;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;
    @FindBy(xpath = "//button[@name='login']")
    public WebElement loginbutton;
    @FindBy(linkText = "My Account")
    public WebElement myAccountButton;
    //xpath = "//li[@id='menu-item-1079']/a"
    @FindBy(linkText = "Store Manager")
    public WebElement storeManager;
    @FindBy(linkText = "Products")
    public WebElement products;
    @FindBy(linkText = "Add New")
    public WebElement addnew;
    @FindBy(xpath = "//select[@id='product_type']")
    public WebElement productDropdown;
    @FindBy(xpath = "//*[@class='wcfm_product_manager_cats_checklist_fields wcfm_product_taxonomy_product_brand']/p")
    public WebElement productBrands;
    @FindBy(xpath = "//iframe[@id='excerpt_ifr']")
    public WebElement shortDescIframe;
    @FindBy(xpath = "//iframe[@id='description_ifr']")
    public WebElement descriptionIframe;

    @FindBy(xpath = "//*[@data-super_parent='645']")
    public WebElement categoriesList;
    @FindBy(xpath = "//*[@id='pro_title']")
    public WebElement productTitle;
    @FindBy(xpath = "//*[@id='tinymce']")
    public WebElement shortDescription;
    @FindBy(xpath = "//*[@id='tinymce']")
    public WebElement description;
    @FindBy(xpath = "//*[@data-super_parent='335']")
    public WebElement brandsList;
    @FindBy(xpath = "//*[@id='featured_img_display']")
    public WebElement imageToClick;
    @FindBy(xpath = "//*[@id='gallery_img_gimage_0_display']")
    public WebElement galleryImageToClick;

    @FindBy(xpath = "//*[@type='file']")
    public WebElement fileUpload;
   @FindBy(xpath = "//*[@class = 'button media-button button-primary button-large media-button-select']")
   public WebElement fileUploadSelect;

   @FindBy(xpath = "//*[@id='__wp-uploader-id-3']/div[4]/div/div[2]/button")
   public WebElement imageUploadGalery;

   @FindBy(xpath = "//*[@name='submit-data']")
    public WebElement submitData;
    @FindBy(xpath = "//span[@class=\"product-status product-status-publish\"]")
    public WebElement submitAssertion;

    @FindBy(xpath = "//*[@class='wcfm-message wcfm-error']")
    public WebElement errorMessage;
    @FindBy(xpath = "//*[@id='wcfm_products_manage_form_general_expander']/div[2]/div[5]/p")
    public WebElement addNewCategory;

    @FindBy(xpath = "//*[@id='wcfm_new_cat']")
    public WebElement categoryName;

    @FindBy(xpath = "//select[@id='wcfm_new_parent_cat']")
    public WebElement parentCategoryDropdown;

    @FindBy(xpath = "//button[@data-taxonomy='product_cat']")
    public WebElement addNewCategoryButton;
    @FindBy(xpath = "//*[@id='product_cats_checklist']/li[1]")
    public WebElement addedCategory;
    @FindBy(xpath = "//*[@id='product_brand']/li[1]")
    public WebElement addedBrand;
    @FindBy(xpath = "//button[@data-taxonomy='product_brand']")
    public WebElement addNewBrandButton;

    @FindBy(xpath = "//*[@id='wcfm_products_manage_form_general_expander']/div[2]/div[10]/p")
    public WebElement addNewBrand;
    @FindBy(xpath = "//*[@id='wcfm_new_product_brand']")
    public WebElement brandName;
    @FindBy(xpath = "//select[@id='wcfm_new_parent_product_brand']")
    public WebElement parentBrandDropdown;






}
