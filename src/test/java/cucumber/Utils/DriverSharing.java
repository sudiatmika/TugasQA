package cucumber.Utils;

import cucumber.DriverSaucedemo;
import org.openqa.selenium.WebDriver;

public class DriverSharing extends DriverSaucedemo {

    public DriverSharing(){
        setup();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
