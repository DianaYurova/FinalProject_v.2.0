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
    private static  WebElement userBox;

    @FindBy(xpath = "//li[@class='inlblk'][1]")
    private WebElement languageCheckBoxItem;

    @FindBy(className = "marginleft15")
    private static WebElement messagesMenu;

    public WebDriver driver;

    public MainPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickProfileBtn() {
        myProfileBtn.click();
    }
    public void explicitCookiesBtn() { explicitToBeClickable(cookiesAcceptBtn);  }
    public void closeCookiesWarning() {
        cookiesAcceptBtn.click();
    }
    public void openProfileMenu() { action.moveToElement(myProfileBtn).build().perform();}
    public void clickOnProfileMenu() {action.moveToElement(userBox).click();}
    public void explicitMyProfileBtn() {explicitToBeClickable(myProfileBtn);}
    public boolean isLangItemSelected() { languageCheckBoxItem.isSelected();
        return false;
    }
    public void clickLangItem() { languageCheckBoxItem.click(); }
    public String getTextOfLangItem() {
        return languageCheckBoxItem.getText();
    }
    public String getNameOfMessageMenu() {
        return messagesMenu.getText();
    }
}
