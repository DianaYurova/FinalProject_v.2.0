package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static test.BaseTest.driver;


public abstract class BasePage {

    public static WebElement webElement;
    public static WebElement dynamicElement1;
    public static WebElement dynamicElement2;
    public static Actions action = new Actions(driver);

    public static void explicitToBeClickable(WebElement webElement) {
        dynamicElement1 = new WebDriverWait(driver, Duration.ofSeconds(100))
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void explicitPageReload() {
        dynamicElement2 = new WebDriverWait(driver, Duration.ofSeconds(100))
                .until(ExpectedConditions.refreshed(
                        ExpectedConditions.presenceOfElementLocated(By.id("headerLogo"))
                ));
    }

}
