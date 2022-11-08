package screenshot;

import base.Hooks;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class FullScreenshotTest extends Hooks {

    @Test
    public void fullScreenshot() throws IOException {
        driver.get("https://automationteststore.com/");

        // Capture full-screen (Firefox only)
        File screenshot = ((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("./full_screenshot.png"));
    }
}
