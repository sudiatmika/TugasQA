package cucumber;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverSaucedemo {
    public WebDriver driver;
    public String baseUrl = "https://www.saucedemo.com/";

    public DriverSaucedemo() {
        WebDriverManager.chromedriver().setup();
    }
    public void setup() {
        this.driver = new ChromeDriver();
        this.driver.get(baseUrl);
        this.driver.manage().window().maximize();
    }

    public void homePageLogin() {
        String swagLab = this.driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(swagLab, "Swag Labs");
    }

    public void tearDown() {
        if(this.driver!=null) {
            this.driver.quit();
        }
    }

    public void userInsertUsernamePassword(String username, String password){
        WebElement usernameInput = this.driver.findElement(By.id("user-name"));
        usernameInput.sendKeys(username);

        WebElement passwordInput = this.driver.findElement(By.id("password"));
        passwordInput.sendKeys(password);
    }

    public void ButtonClick(By idClass) {
        WebElement buttonClick = this.driver.findElement(idClass);
        buttonClick.click();
    }


    public void isDisplay(By idClass) {
        WebElement buttonClick = this.driver.findElement(idClass);
        buttonClick.isDisplayed();
    }

    public void checkLinkUrl(String Url) {
        String curUlr = this.driver.getCurrentUrl();
        Assert.assertEquals(this.baseUrl + Url, curUlr);
    }

    public void isEquals(By idClass, String text) {
        String getTextHtml = this.driver.findElement(idClass).getText();
        Assert.assertEquals(text, getTextHtml);

    }

    public void insertText(By idClass, String text) {
        WebElement usernameInput = this.driver.findElement(idClass);
        usernameInput.sendKeys(text);
    }

    public void waitPage() {
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
}
