package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(xpath = "//button[@class = 'cookie-close abs cookiesBarClose']")
    public WebElement cookiesAcceptBtn;

    @FindBy(xpath = "//div[@class = 'inlblk rel']")
    private WebElement myProfileBtn;

    @FindBy(xpath = "//div[@class='css-1g5leiq']")
    private static WebElement usernameBox;

    @FindBy(xpath = "//div[@class = 'userbox-dd abs br5 nowrap hidden']")
    private static WebElement userBox;

    @FindBy(xpath = "//li[@class='inlblk'][1]")
    private WebElement languageCheckBoxItem1;

    @FindBy(xpath = "//a[@id='changeLang']")
    private WebElement languageCheckBoxItem2;

    @FindBy(className = "marginleft15")
    private static WebElement messagesMenu;

    @FindBy(xpath = "//span[@class='x-normal']")
    private static WebElement selectedLang;

    @FindBy(xpath = "//div[@class='adm-hp-wideboard-main']")
    private static WebElement adBox;

    @FindBy(xpath = "//div[@class='wrapper clr rel']")
    private static WebElement headerBox;

    public WebDriver driver;

    public MainPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickProfileBtn() {
        myProfileBtn.click();
    }
    public void explicitCookiesBtn() { explicitToBeClickable(cookiesAcceptBtn);  }
    public void explicitHeaderToBeVisible() { explicitToBeVisible(headerBox); }
    public void closeCookiesWarning() {
        cookiesAcceptBtn.click();
    }
    public void openProfileMenu() { action.moveToElement(myProfileBtn).build().perform();}
    public void clickOnProfileMenu() {action.moveToElement(userBox).click();}
    public void explicitMyProfileBtn() {explicitToBeClickable(myProfileBtn);}
    public boolean isLangItemSelected() { languageCheckBoxItem1.isSelected();
        return false; }
    public void clickLangItem1() { languageCheckBoxItem1.click(); }
    public void clickLangItem2() { languageCheckBoxItem2.click(); }
    public String getTextOfLangItem() { return selectedLang.getText();  }
    public String getNameOfMessageMenu() {
        return messagesMenu.getText();
    }
}
