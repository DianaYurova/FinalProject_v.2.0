package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdPage extends  BasePage {

    public WebDriver driver;
    public WebElement webElement;

    public AdPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[@class= 'css-uomswa-BaseStyles']")
    private WebElement sendMsgBtn;

    @FindBy(xpath = "//textarea[@name= 'message.text']")
    private WebElement msgArea;

    @FindBy(xpath = "//button[@data-testid= 'submit-message-btn']")
    private WebElement submitSendMsg;

    @FindBy(xpath = "//div//p[text()='Сообщение отправлено']")
    public WebElement successNotification;

    public void sendMsg() { sendMsgBtn.click();}
    public void putCursorToInput() { msgArea.click(); }
    public void inputTextMsg(String text) { msgArea.sendKeys(text);}
    public void submitSendMsg() { submitSendMsg.click(); }
    public boolean notificationIsdisplayed() { successNotification.isDisplayed(); return false; }

}
