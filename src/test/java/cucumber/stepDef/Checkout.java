package cucumber.stepDef;

import cucumber.Utils.DriverSharing;
import cucumber.pages.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout {
    WebDriver driver;
    DriverSharing sharing;

    CartPage cartPage;

    public Checkout(DriverSharing sharing) {
        this.sharing = sharing;
        this.driver = this.sharing.getDriver();
        cartPage = new CartPage(this.sharing);
    }

    @Given("Add product sauce lab bike light in cart")
    public void add_product_sauce_lab_bike_light_in_cart() {
        cartPage.linkImage("item_0_img_link");

        String name = "Sauce Labs Bike Light";
        String addCart = name.replace(" ", "-").toLowerCase();
        cartPage.addProduct(addCart);

        cartPage.clickBackToProduct();
    }

    @Then("Click Cart Icon")
    public void clickCartIcon() {
        cartPage.clickCartIcon();
    }

    @Then("Show your cart page")
    public void showYourCartPage() {
        this.sharing.isEquals(By.xpath("//div[@class='header_secondary_container']//span[@class='title']"), "Your Cart");
    }

    @Then("Click button checkout")
    public void clickButtonCheckout() {
        this.sharing.ButtonClick(By.id("checkout"));
    }

    @Then("Insert first name")
    public void insertFirstName() {
        this.sharing.insertText(By.id("first-name"), "Indrawan");
    }

    @And("Insert last name")
    public void insertLastName() {
        this.sharing.insertText(By.id("last-name"), "Hu");
    }

    @And("Insert postal code")
    public void insertPostalCode() {
        this.sharing.insertText(By.id("postal-code"), "30129");
    }

    @Then("Click button continue")
    public void clickButtonContinue() {
        this.sharing.ButtonClick(By.id("continue"));
    }

    @Then("Show checkout page")
    public void showCheckoutPage() {
        this.sharing.isEquals(By.xpath("//div[@class='header_secondary_container']//span[@class='title']"), "Checkout: Overview");
    }

    @Then("Pay checkout product")
    public void payCheckoutProduct() {
        this.sharing.ButtonClick(By.id("finish"));
    }

    @Then("Success checkout")
    public void successCheckout() {
        this.sharing.isEquals(By.xpath("//h2[@class='complete-header']"), "Thank you for your order!");
    }

    @Then("error display checkout")
    public void errorDisplayCheckout() {
        this.sharing.isEquals(By.xpath("//h3[@data-test='error']"), "Error: First Name is required");
    }
}
