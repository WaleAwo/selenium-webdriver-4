package actions;

import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class PerformingActionsTest extends Hooks {

    @Test
    public void performingActions() {
        driver.get("https://webdriveruniversity.com/Actions/index.html");

        // Click & Hold
        WebElement clickAndHoldElement = driver.findElement(By.id("click-box"));
        Actions actions = new Actions(driver);

        actions.clickAndHold(clickAndHoldElement).build().perform();
        actions.release().build().perform();

        // Drag & Drop
        WebElement dragElement = driver.findElement(By.id("draggable"));
        WebElement dropElement = driver.findElement(By.id("droppable"));

        actions.moveToElement(dragElement).clickAndHold().moveToElement(dropElement).release().build().perform();

        // Double Click
        WebElement doubleClickElement = driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClickElement).release().build().perform();
    }
}
