package cucumber.pages;

import cucumber.Utils.DriverSharing;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;
    DriverSharing sharing;

    public CartPage(DriverSharing sharing) {
        this.sharing = sharing;
        this.driver = this.sharing.getDriver();
    }

    public void linkImage(String idImage){
        this.sharing.ButtonClick(By.id(idImage));
    }

    public void clickBackToProduct(){
        this.sharing.ButtonClick(By.id("back-to-products"));
    }

    public void addProduct(String nameProduct) {
        this.sharing.ButtonClick(By.id("add-to-cart-"+nameProduct));
    }

    public void clickCartIcon() {
        this.sharing.ButtonClick(By.xpath("//a[@class='shopping_cart_link']"));
    }

    public void removeCart(String name) {
        String nameCart = name.replace(" ", "-").toLowerCase();
        this.sharing.ButtonClick(By.id("remove-"+nameCart));
    }
}
