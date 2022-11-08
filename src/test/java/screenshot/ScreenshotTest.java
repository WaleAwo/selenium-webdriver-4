package screenshot;

import base.Hooks;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenshotTest extends Hooks {

    @Test
    public void screenshot() throws IOException {
        driver.get("https://automationteststore.com/");

        // Capture screen
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File ("./test.png"));

        // Capture web element
        WebElement homeButton = driver.findElement(By.xpath("//a[text()='Home']"));
        srcFile = homeButton.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File ("./element.png"));
    }
}
