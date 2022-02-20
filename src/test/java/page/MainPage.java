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

    @FindBy(xpath = "//li[@class = 'candidate-profile-link']/a")
    private WebElement candidateProfileLink;

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

    @FindBy(xpath = "//a[@data-id = '899']/span[@style = 'background-color: rgb(200, 248, 246);']")
    private WebElement domIsadIcon;

    @FindBy(xpath = "//a[@data-id = '1433']")
    private WebElement sadOgorod;

    @FindBy(xpath = "//h3[@class= 'lheight22 margintop5']")
    private WebElement advt;

    @FindBy(xpath = "//a[@class = 'css-1q6sukh']/span")
    private WebElement myMessages;

    @FindBy(xpath = "//p[@class = 'css-kfe4ks-Text eu5v0x0'][1]")
    private WebElement textOfLastMsg;

    @FindBy(xpath = "//div//strong[@data-cy='common_text_header_observed_ads_counter']")
    private WebElement favCounter;

    @FindBy(xpath = "//a[@title='Помощь и Обратная связь']")
    private WebElement helpLink;

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
    public void clickCandidateLink() { candidateProfileLink.click(); }
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
    public void selectSearchCategory() { domIsadIcon.click(); }
    public void selectSubCategory() { sadOgorod.click(); }
    public void explicitMyMessagesBecomeClickable() { explicitToBeClickable(myMessages); }
    public void clickOnMessagesMenu() {action.moveToElement(myMessages).click();}
    public void openMyMessages() { myMessages.click(); }
    public String getTextOfLastMsg() { return textOfLastMsg.getText(); }
    public void explicitAdvt() { explicitToBeClickable(advt); }
    public void openAd() { advt.click(); }
    public String getFavCount() { return favCounter.getText(); }
    public void clickHelpLink() { helpLink.click(); }
    public String getCurrUrl() { return driver.getCurrentUrl();}
}
