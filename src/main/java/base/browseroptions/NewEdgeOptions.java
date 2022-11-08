package base.browseroptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class NewEdgeOptions {
    public static void main(String[] args) {

        WebDriver driver;
        WebDriverManager.edgedriver().setup();

        // New EdgeOptions
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

        driver = new EdgeDriver(edgeOptions);

        driver.get("https://www.webdriveruniversity.com");
        driver.manage().window().maximize();

        driver.quit();

    }
}
