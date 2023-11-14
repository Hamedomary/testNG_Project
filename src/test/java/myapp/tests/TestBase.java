package myapp.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;

    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

//    @BeforeMethod
//    public void openBrowser() {
//        driver.get("https://allovercommerce.com");
//    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
