package windows;

import base.Hooks;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class NewWindowTest extends Hooks {

    @Test
    public void newWindow(){
        driver.get("https://webdriveruniversity.com/");

        // Open new window
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://automationteststore.com/");
        driver.manage().window().maximize();

        // Switch between windows
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());

        // Original window
        driver.switchTo().window(windows.get(0));
        System.out.println(driver.getCurrentUrl());

        // New window
        driver.switchTo().window(windows.get(1));
        System.out.println(driver.getCurrentUrl());
        driver.close();

        // Switch back to original window and close tab
        driver.switchTo().window(windows.get(0));
    }

}
