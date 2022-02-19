package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WalletPage extends BasePage {

    public WebDriver driver;

    public WalletPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@type = 'submit']")
    private WebElement submitPaymentAmountBtn;

    @FindBy(xpath = "//li[@data-test = 'start-card-payment']")
    private WebElement payByCreditCard;

    @FindBy(xpath = "//p[@class='css-1d76riw-Text eu5v0x0']")
    private WebElement paymentInfoMsg;

    @FindBy(xpath = "//input[@data-plutus = '59999']")
    private WebElement biggestAmount;

    public void clickSubmitPaymentAmountBtn() { submitPaymentAmountBtn.click(); }
    public void selectPayByCC() { payByCreditCard.click(); }
    public boolean presenceOfPaymentInfoMsg() { return paymentInfoMsg.isDisplayed(); }
    public void selectBiggestPaymentAmount() { biggestAmount.click(); }
    public void explicitBiggestAmountToBeClickable() { explicitToBeClickable(biggestAmount); }
}
