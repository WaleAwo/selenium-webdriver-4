package windows;

import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;


public class NewTabTest extends Hooks {

    @Test
    public void newTab() {

        // Open window & save window handle id
        driver.get("https://webdriveruniversity.com/");
        String originalWindow = driver.getWindowHandle();

        // Create new tab, switch and launch Google
        driver.switchTo().newWindow(WindowType.TAB);
        String newWindow = driver.getWindowHandle();
        driver.get("https://google.com");

        // Close new tab
        driver.close();

        // Open new tab
        driver.switchTo().window(originalWindow);
        WebElement loginButton = driver.findElement(By.id("login-portal"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // Switch to new tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()); // An array to hold window handles
        driver.switchTo().window(tabs.get(1));
        System.out.println("Tab title: " + driver.getTitle());
        wait.until(ExpectedConditions.titleIs("WebDriver | Login Portal"));

        // Switch to original tab and close the other tab
        driver.switchTo().window(originalWindow);
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        driver.close();

        // Switch back to first tab
        driver.switchTo().window(originalWindow);
        System.out.println("Original Tab Title: " + driver.getTitle());
    }
}
