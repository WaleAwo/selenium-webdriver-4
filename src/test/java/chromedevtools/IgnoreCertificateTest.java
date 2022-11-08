package chromedevtools;

import base.Hooks;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.security.Security;
import org.testng.annotations.Test;

public class IgnoreCertificateTest extends Hooks {

    @Test
    public void ignoreCertificateTest() {
        DevTools devTools = ((ChromeDriver)driver).getDevTools();

        devTools.send(Security.enable());
        devTools.send(Security.setIgnoreCertificateErrors(true)); // Ignore certificates

        driver.get("SSL_URL");
    }
}
