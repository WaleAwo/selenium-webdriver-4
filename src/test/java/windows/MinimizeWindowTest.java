package windows;

import base.Hooks;
import org.testng.annotations.Test;

public class MinimizeWindowTest extends Hooks {

    @Test
    public void minimizeWindow() {

        // Minimize window
        driver.get("https://webdriveruniversity.com/");
        driver.manage().window().minimize();

    }
}
