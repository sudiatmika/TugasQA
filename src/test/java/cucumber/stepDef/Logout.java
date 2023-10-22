package cucumber.stepDef;

import cucumber.Utils.DriverSharing;
import cucumber.pages.CartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Logout {
    WebDriver driver;
    DriverSharing sharing;

    CartPage cartPage;

    public Logout(DriverSharing sharing) {
        this.sharing = sharing;
        this.driver = this.sharing.getDriver();
        cartPage = new CartPage(this.sharing);
    }

    @Given("I am in Products item")
    public void i_am_in_products_item() {
        this.sharing.checkLinkUrl("inventory.html");
    }


    @Then("Click button burger")
    public void clickButtonBurger() {
        this.sharing.ButtonClick(By.id("react-burger-menu-btn"));
    }

    @Then("Show side bar")
    public void showSideBar() {
//        this.sharing.isEquals(By.id("logout_sidebar_link"), "Logout");
        Wait<WebDriver> wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        try{
            Boolean checkLogout = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("logout_sidebar_link"), "Logout"));
            System.out.println(checkLogout);
        }catch (ElementNotInteractableException e) {
            System.out.println("Element not interactable: " + e.getMessage());
            Assert.fail();
        }
    }

    @Then("Click Logout menu")
    public void clickLogoutMenu() {
        this.sharing.ButtonClick(By.id("logout_sidebar_link"));
    }

    @Then("Redirect to login page")
    public void redirectToLoginPage() {
        this.sharing.homePageLogin();
    }
}
