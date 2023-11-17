package myapp.tests.userStory01;

import com.github.javafaker.Faker;
import myapp.pages.userStory01.LoginPage;
import myapp.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class RegisterTest {

    private static final String ALLOVERCOMMERCE_COM = "https://allovercommerce.com/";
    private static final WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    public static final String INVALID_PASSWORD = "A1234567.";
    private LoginPage loginPage = new LoginPage();
    private Faker faker = new Faker();

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = Driver.getDriver();
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

    @Test(priority = 100)
    public void shouldRegisterSuccessFull() {
        driver.get(ALLOVERCOMMERCE_COM);
        loginPage.registerButton.click();
        loginPage.registerUserName.sendKeys(faker.name().username());
        loginPage.registerEmail.sendKeys(faker.internet().emailAddress());
        loginPage.registerPassword.sendKeys(faker.internet().password());
        loginPage.privacyCheckbox.click();
        loginPage.registerSignUp.click();
        wait.until(visibilityOf(loginPage.signOutButton));
        loginPage.signOutButton.click();
        wait.until(visibilityOf(loginPage.logOutButton));
        loginPage.logOutButton.click();

    }

    @Test
    public void shouldNotRegisterWhenUsernameIsEmpty() {
        driver.get(ALLOVERCOMMERCE_COM);
        loginPage.registerButton.click();
        loginPage.registerEmail.sendKeys(faker.internet().emailAddress());
        loginPage.registerPassword.sendKeys(faker.internet().password());
        loginPage.privacyCheckbox.click();
        loginPage.registerSignUp.click();
        wait.until(not(visibilityOf(loginPage.myAccountText)));

    }

    @Test
    public void shouldNotRegisterWhenPrivacyCheckboxNotClick() {
        driver.get(ALLOVERCOMMERCE_COM);
        loginPage.registerButton.click();
        loginPage.registerUserName.sendKeys(faker.name().username());
        loginPage.registerEmail.sendKeys(faker.internet().emailAddress());
        loginPage.registerPassword.sendKeys(faker.internet().password());
        loginPage.registerSignUp.click();
        wait.until(not(visibilityOf(loginPage.myAccountText)));
    }

    @Test
    public void shouldNotRegisterWhenInvalidPassword() {
        driver.get(ALLOVERCOMMERCE_COM);
        loginPage.registerButton.click();
        loginPage.registerUserName.sendKeys(faker.name().username());
        loginPage.registerEmail.sendKeys(faker.internet().emailAddress());
        loginPage.registerPassword.sendKeys(INVALID_PASSWORD);
        loginPage.registerSignUp.click();
        wait.until(not(visibilityOf(loginPage.myAccountText)));
    }

    @Test
    public void shouldNotRegisterWhenAlreadyEmailRegistered() {
        driver.get(ALLOVERCOMMERCE_COM);
        loginPage.registerButton.click();
        String username = faker.name().username();
        String emailAddress = faker.internet().emailAddress();
        String password = faker.internet().password();
        loginPage.registerUserName.sendKeys(username);
        loginPage.registerEmail.sendKeys(emailAddress);
        loginPage.registerPassword.sendKeys(password);
        loginPage.privacyCheckbox.click();
        loginPage.registerSignUp.click();
        wait.until(visibilityOf(loginPage.myAccountText));
        loginPage.signOutButton.click();
        wait.until(visibilityOf(loginPage.logOutButton));
        loginPage.logOutButton.click();

        driver.get(ALLOVERCOMMERCE_COM);
        loginPage.registerButton.click();
        loginPage.registerUserName.sendKeys(username);
        loginPage.registerEmail.sendKeys(emailAddress);
        loginPage.registerPassword.sendKeys(password);
        loginPage.privacyCheckbox.click();
        loginPage.registerSignUp.click();
        wait.until(textToBePresentInElement(loginPage.loginPopup, "An account is already registered with your email address"));
        wait.until(not(visibilityOf(loginPage.myAccountText)));

    }

    @Test
    public void shouldNotRegisterWhenEmailIsNotCorrect() {
        driver.get(ALLOVERCOMMERCE_COM);
        loginPage.registerButton.click();
        loginPage.registerUserName.sendKeys(faker.name().username());
        loginPage.registerEmail.sendKeys("test@");
        loginPage.registerPassword.sendKeys(faker.internet().password());
        loginPage.privacyCheckbox.click();
        loginPage.registerSignUp.click();
        wait.until(not(visibilityOf(loginPage.myAccountText)));
    }

    @Test
    public void shouldNotRegisterWhenUserAlreadyRegistered()  {
        driver.get(ALLOVERCOMMERCE_COM);
        loginPage.registerButton.click();
        String username = faker.name().username();
        loginPage.registerUserName.sendKeys(username);
        loginPage.registerEmail.sendKeys(faker.internet().emailAddress());
        loginPage.registerPassword.sendKeys(faker.internet().password());
        loginPage.privacyCheckbox.click();
        loginPage.registerSignUp.click();
        wait.until(visibilityOf(loginPage.signOutButton));
        loginPage.signOutButton.click();
        wait.until(visibilityOf(loginPage.logOutButton));
        loginPage.logOutButton.click();

        driver.get(ALLOVERCOMMERCE_COM);
        loginPage.registerButton.click();
        loginPage.registerUserName.sendKeys(username);
        loginPage.registerEmail.sendKeys(faker.internet().emailAddress());
        loginPage.registerPassword.sendKeys(faker.internet().password());
        loginPage.privacyCheckbox.click();
        loginPage.registerSignUp.click();
        wait.until(textToBePresentInElement(loginPage.loginPopup, "An account is already registered with that username. Please choose another."));
        wait.until(not(visibilityOf(loginPage.myAccountText)));

    }

}
