package page;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static test.BaseTest.driver;

public class SearchPage extends BasePage{

    public WebDriver driver;

    public SearchPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//div[@class='fieldsets']")
    public WebElement blockOfFilters;

    @FindBy (xpath = "//input [@id = 'search-text']")
    public WebElement searchField;

    @FindBy (xpath = "//span[@class='button big4 fright br3']")
    public WebElement searchBtn;

    @FindBy (xpath = "//input[@id = 'cityField']")
    public WebElement cityField;

    @FindBy (xpath = "//a[@data-id = '8']")
    public WebElement regionKh;

    @FindBy (xpath = "//a[@data-name = '" + "Харьков" + "']")
    public WebElement cityKh;

    @FindBy (xpath = "//span[@class = 'fbold vishid']")
    public WebElement filledCityField;

    @FindBy (xpath = "//h1[@class = 'small fnormal inline lheight18']")
    public WebElement queryHeader;

    @FindBy (xpath = "//a[@class = 'clear-input-button']")
    public WebElement clearBtn;

    public static WebElement dynamicElement3;

    public boolean isDispayedFilters() {
        return blockOfFilters.isDisplayed();
    }

    public void clearSearchField() { searchField.clear();}
    public void clickClearBtn() { clearBtn.click(); }
    public void searchByKeyword(String keyword) { searchField.sendKeys(keyword); }
    public void searchConfirm() { searchField.sendKeys(Keys.ENTER);}
    public void clickSearchBtn() { searchBtn.click(); }
    public void clickCityField() { cityField.click(); }
    public void selectRegionInList() { regionKh.click(); }
    public void selectCityInList() { cityKh.click(); }
    public String containsCityName() { return filledCityField.getAttribute("innerHTML"); }
    public String headerContainsQuery() { return queryHeader.getAttribute("innerHTML"); }
    public void explicitWaiter() {
        dynamicElement3 = new WebDriverWait(driver, Duration.ofSeconds(100))
                .until(ExpectedConditions.elementToBeClickable
                        (By.xpath("//button[@id = 'saved-searches-floating-btn']")));
    }

    public void waiterPageReload() {
        new WebDriverWait(driver, Duration.ofSeconds(100)).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));

    }

}
