package windows.old;

import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class NewTabTest extends Hooks {

    @Test
    public void HandlingTabs() throws InterruptedException {
        driver.get("http://www.webdriveruniversity.com/Page-Object-Model/index.html");

        // open link in new tab
        WebElement contactUsLink = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Contact Us")));
        contactUsLink.sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));

        // an array to hold all active window handles
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        // switch to the most recent tab
        driver.switchTo().window(tabs.get(tabs.size() - 1));

        // close the most recent tab
        driver.close();

        // switch back to default tab
        driver.switchTo().window(tabs.get(0));

        // open a new tab using JavaScript and navigate to a url
        ((JavascriptExecutor) driver).executeScript("window.open()");
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        driver.get("https://www.youtube.com");

        Thread.sleep(1000);
    }
}
