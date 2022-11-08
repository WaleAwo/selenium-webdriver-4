package base.browseroptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class NewChromeOptions {
    public static void main(String[] args) {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();

        /*
        ***Deprecated***

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

         */

        // New ChromeOptions
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        chromeOptions.setCapability(CapabilityType.PLATFORM_NAME, "Windows 10");

        driver = new ChromeDriver(chromeOptions);

        driver.get("https://www.webdriveruniversity.com");
        driver.manage().window().maximize();

        driver.quit();

    }
}
