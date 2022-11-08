package chromedevtools;

import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class EmulateGeoLocationsTest extends Hooks {

    @Test
    public void emulateGEOLocations() {

        // Store location coordinates
        Map<String, Object> coordinates = new HashMap<>();
        coordinates.put("latitude", 27.96205551052111);
        coordinates.put("longitude", -82.4063099239078);
        coordinates.put("accuracy", 100);

        // Set geolocation function
        ((ChromeDriver) driver).executeCdpCommand("Emulation.setGeolocationOverride", coordinates);

        driver.get("https://locations.kfc.com/search");

        WebElement location_button = driver.findElement(By.cssSelector("[data-ya-track='geolocate']"));
        location_button.click();
    }
}
