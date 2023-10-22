package cucumber.stepDef;

import cucumber.Utils.DriverSharing;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Login {
    WebDriver driver;

    DriverSharing sharing;

    private final By buttonLoginLocator = By.id("login-button");

    private final By burgerIcon = By.id("react-burger-menu-btn");
    private final By swagLogo = By.xpath("//div[@class='swag-logo']");

    public Login(DriverSharing sharing) {
        this.sharing = sharing;
        this.driver = this.sharing.getDriver();
    }

    @After
    public void tearDown() {
        this.sharing.tearDown();
    }

    @Given("I am on saucedemo login page")
    public void i_am_on_saucedemo_login_page(){
        this.sharing.homePageLogin();
    }

    @Given("I have enter username and password")
    public void iHaveEnterUsernameAndPassword() {
        this.sharing.userInsertUsernamePassword("standard_user", "secret_sauce");
    }

    @When("I click on the login button")
    public void iClickOnTheLoginButton() {
        this.sharing.ButtonClick(buttonLoginLocator);
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {
        this.sharing.isDisplay(burgerIcon);
    }

    @Given("I have enter invalid username and password")
    public void iHaveEnterInvalidUsernameAndPassword() {
        this.sharing.userInsertUsernamePassword("wrong_user", "secret");
    }

    @Then("Show Error message credential")
    public void showErrorMessageCredential() {
        this.sharing.isDisplay(By.xpath("//h3[@data-test='error']"));
    }
}
