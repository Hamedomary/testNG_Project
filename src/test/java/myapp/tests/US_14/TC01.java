<<<<<<< Updated upstream:src/test/java/myapp/tests/TC01.java

package myapp.tests;

public class TC01 {
    Test

package myapp.tests.projectss;
=======
package myapp.tests.US_14;
>>>>>>> Stashed changes:src/test/java/myapp/tests/US_14/TC01.java

import myapp.pages.US_14.Allovercommerce;
import myapp.utilities.*;
import org.junit.Assert;
import org.testng.annotations.Test;


public class TC01 {
//    Go to homepage
//    Click 'sign in'
//    Type Email
//    Type Password
//    Click 'sign in'
//    Click My Account
//    Click Store Manager
//    Click Product
//    Click Add New
//    Click the Dropdown
//    Verify Simple Product option is exist
//    Verify Variable Product option is exist
//    Verify Grouped Product options is exist
//    Verify External - Affiliate Product option is exist

    @Test
    public void TC01(){

        Allovercommerce allovercommerce = new Allovercommerce();
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerce"));
        allovercommerce.login.click();
        allovercommerce.username.sendKeys(ConfigReader.getProperty("aoc_username"));
        allovercommerce.password.sendKeys(ConfigReader.getProperty("aoc_password"));
        allovercommerce.loginbutton.click();
        WaitUtils.waitFor(4);
        JSUtils.JSclickWithTimeout(allovercommerce.myAccountButton);
        WaitUtils.waitFor(2);
        allovercommerce.storeManager.click();
        WaitUtils.waitFor(2);
        allovercommerce.products.click();
        WaitUtils.waitFor(2);
        allovercommerce.addnew.click();
        String[] products = {"Simple Product", "Variable Product", "Grouped Product", "External/Affiliate Product"};
        for (int i = 0; i <4 ; i++) {
           Assert.assertTrue(allovercommerce.productDropdown.getText().contains(products[i]));
            System.out.println(products[i]);
        }

    }

}
