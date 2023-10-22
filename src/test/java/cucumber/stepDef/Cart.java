package cucumber.stepDef;

import cucumber.Utils.DriverSharing;
import cucumber.pages.CartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart {
    WebDriver driver;
    DriverSharing sharing;

    CartPage cartPage;

    private final By boltTShirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");

    public Cart(DriverSharing sharing) {
        this.sharing = sharing;
        this.driver = this.sharing.getDriver();
        cartPage = new CartPage(this.sharing);
    }

    @Given("I am in Products page")
    public void i_am_in_products_page() {
        this.sharing.checkLinkUrl("inventory.html");
    }

    @Then("I select picture product {int}")
    public void iSelectPictureProduct(Integer id) {
        String product_id = "item_"+ id + "_img_link";
        cartPage.linkImage(product_id);
//        this.sharing.ButtonClick(By.id(product_id));
    }

    @Then("user add (.*) in cart$")
    public void userAddProduct_nameInCart(String name) {
        String addCart = name.replace(" ", "-").toLowerCase();
        cartPage.addProduct(addCart);
    }

    @Then("{int} product added to cart")
    public void productAddedToCart(Integer item) {
        WebElement badge = this.driver.findElement(By.className("shopping_cart_badge"));
        if (badge.isDisplayed()){
            Assert.assertEquals(Integer.toString(item) , badge.getText());
        }
    }

    @Then("click back to product")
    public void clickBackToProduct() {
        cartPage.clickBackToProduct();
    }

    @Then("Click remove button sauce lab bike light")
    public void clickRemoveButtonSauceLabBikeLight() {
        cartPage.removeCart("Sauce Labs Bike Light");
    }
}
