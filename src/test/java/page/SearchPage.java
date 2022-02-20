package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage extends BasePage{

    public WebDriver driver;

    public SearchPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//div[@class='fieldsets']")
    private WebElement blockOfFilters;

    @FindBy (xpath = "//input [@id = 'search-text']")
    private WebElement searchField;

    @FindBy (xpath = "//span[@class='button big4 fright br3']")
    private WebElement searchBtn;

    @FindBy (xpath = "//input[@id = 'cityField']")
    private WebElement cityField;

    @FindBy (xpath = "//a[@data-id = '8']")
    private WebElement regionKh;

    @FindBy (xpath = "//a[@data-name = '" + "Харьков" + "']")
    private WebElement cityKh;

    @FindBy (xpath = "//span[@class = 'fbold vishid']")
    private WebElement filledCityField;

    @FindBy (xpath = "//h1[@class = 'small fnormal inline lheight18']")
    private WebElement queryHeader;

    @FindBy (xpath = "//a[@class = 'clear-input-button']")
    private WebElement clearBtn;

    @FindBy(xpath = "//h3[@class= 'lheight22 margintop5']")
    private WebElement searchResultAd;

    @FindBy(xpath = "//span[@data-icon = 'star']")
    private WebElement addToFavBtn;

    @FindBy(xpath = "//a[@class = 'button button-from numeric gray block fnormal rel zi3 clr']")
    private WebElement priceMin;

    @FindBy(xpath = "//div[@class='filter-item filter-item-from rel numeric-item price']//a[@data-name = '1 000']")
    private WebElement thousandMin;

    @FindBy(xpath = "//a[@class = 'button button-to numeric gray block fnormal rel zi3 clr']")
    private WebElement priceMax;

    @FindBy(xpath = "//div[@class='filter-item filter-item-to rel numeric-item price']//a[@data-name = '1 000']")
    private WebElement thousandMax;

    @FindBy(xpath = "//div[@class='space inlblk rel']//p")
    private WebElement adPrice;

    @FindBy(xpath = "//a[@data-type = 'region']")
    private WebElement selectRegion;

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
    public void selectAd() { searchResultAd.click(); }
    public void addToFavorite() { addToFavBtn.click(); }

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

    public void selectMinPrice() { priceMin.click();}
    public void selectMaxPrice() { priceMax.click();}
    public void setMin1000() { priceMin.sendKeys("1000");}
    public void setMax1000() { priceMax.sendKeys("1000");}
    public void selectThousandMin() { thousandMin.click(); }
    public void selectThousandMax() { thousandMax.click(); }
    public String getAdvtPrice() { return adPrice.getText(); }
    public void selectRegion() { selectRegion.click(); }
    public void clickMin1000() { action.doubleClick(priceMin); }
    public void clickMax1000() { action.doubleClick(priceMax); }
    public void moveToMin1000() { action.moveToElement(thousandMin).build().perform(); }
    public void moveToMax1000() { action.moveToElement(thousandMax).click(); }
}
