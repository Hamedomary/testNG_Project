package myapp.tests.US_20_FirstPart;

import myapp.pages.US11_US20.US20Page;
import myapp.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_02 {

    @Test
    public void TC02Test() throws InterruptedException {

        Driver.getDriver().get("https://allovercommerce.com");

        US20Page us20Page = new US20Page();

        us20Page.searchButton.sendKeys("baby", Keys.ENTER);

        Assert.assertTrue(us20Page.searchResultBaby.isDisplayed());

        Assert.assertTrue(us20Page.noProductsFound.isDisplayed());

        System.out.println("No products were found matching your selection.");






        Driver.closeDriver();


    }
}
