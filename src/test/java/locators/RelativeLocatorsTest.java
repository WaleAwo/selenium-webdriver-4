package locators;

import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

public class RelativeLocatorsTest extends Hooks {

    @Test
    public void relativeLocators() {
        driver.get("https://webdriveruniversity.com/Contact-Us/contactus.html");

        // 'Above' Example 1
        driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.xpath("//input[@name='last_name']"))).sendKeys("John");

        // 'Above' Example 2
        WebElement lastNameTextField = driver.findElement(RelativeLocator.with(By.xpath("//input[@name='last_name']")));
        WebElement firstNameTextField = driver.findElement(RelativeLocator.with(By.tagName("input")).above(lastNameTextField));
        firstNameTextField.sendKeys("Mary");
        lastNameTextField.sendKeys("Willis");

        // 'Below' Example
        WebElement emailAddressTextField = driver.findElement(RelativeLocator.with(By.tagName("input")).below(lastNameTextField));
        emailAddressTextField.sendKeys("mary@mail.com");

        WebElement commentsTextArea = driver.findElement(RelativeLocator.with(By.tagName("textarea")).below(lastNameTextField));
        commentsTextArea.sendKeys("This is some comment");

        WebElement resetButton = driver.findElement(RelativeLocator.with(By.tagName("input")).below(commentsTextArea));
        resetButton.click();

        // 'toRightOf' & 'toLeftOf'
        WebElement submitButton = driver.findElement(RelativeLocator.with(By.tagName("input")).toRightOf(resetButton));
        submitButton.click();

        /* 'Near'
        WebElement submitButton2 = driver.findElement(RelativeLocator.with(By.xpath("//input[@value='SUBMIT']")).near(resetButton));
        submitButton2.click();
         */
    }
}
