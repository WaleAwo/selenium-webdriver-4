package base.browseroptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

public class NewFirefoxOptions {
    public static void main(String[] args) {

        WebDriver driver;
        WebDriverManager.firefoxdriver().setup();

        // New EdgeOptions
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

        firefoxOptions.addArguments("--width=1920");
        firefoxOptions.addArguments("--height=1080");

        driver = new FirefoxDriver(firefoxOptions);
        driver.get("https://www.webdriveruniversity.com");

        driver.quit();

    }
}
