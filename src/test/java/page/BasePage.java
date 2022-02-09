package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static test.BaseTest.driver;

public abstract class BasePage {

    public static WebElement webElement;
    public static WebElement dynamicElement1;
    public static WebElement dynamicElement2;
    public static Actions action = new Actions(driver);

//    @FindBy(xpath = "//button[@class = 'cookie-close abs cookiesBarClose']")
//    public WebElement cookiesAcceptBtn;
//
//    @FindBy(xpath = "//div[@class = 'inlblk rel']")
//    private WebElement myProfileBtn;
//
//    @FindBy(xpath = "//div[@class='css-1g5leiq']")
//    private static WebElement usernameBox;
//
//    @FindBy(xpath = "//div[@class = 'userbox-dd abs br5 nowrap hidden']")
//    private static  WebElement userBox;
//
//    @FindBy(xpath = "//li[@class='inlblk'][1]")
//    private WebElement languageCheckBoxItem;
//
//    @FindBy(className = "marginleft15")
//    private static WebElement messagesMenu;

//    public static boolean isDisplayed(WebElement webElement){
//        return webElement.isDisplayed();
//    }

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

//    public void clickProfileBtn() {
//        myProfileBtn.click();
//    }
//    public void explicitCookiesBtn() { explicitToBeClickable(cookiesAcceptBtn);  }
//    public void closeCookiesWarning() {
//        cookiesAcceptBtn.click();
//    }
//    public void openProfileMenu() { action.moveToElement(myProfileBtn).build().perform();}
//    public void clickOnProfileMenu() {action.moveToElement(userBox).click();}
//    public void explicitMyProfileBtn() {explicitToBeClickable(myProfileBtn);}
//    public boolean isLangItemSelected() { languageCheckBoxItem.isSelected();
//        return false;
//    };
//    public void clickLangItem() { languageCheckBoxItem.click(); }
//    public String getTextOfLangItem() {
//        return languageCheckBoxItem.getText();
//    }
//    public String getNameOfMessageMenu() {
//        return messagesMenu.getText();
//    }
}
