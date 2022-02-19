package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BasePage{

    public WebDriver driver;

    public ProfilePage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(className = "myaccount-pageinfo-container")
    private WebElement userAccountInfo;

    @FindBy(xpath = "//a[@class='olx-button olx-button--secondary paybalance-box__topup-button']")
    private WebElement topUpBtn;

    public boolean isDisplayedBox() {
        return userAccountInfo.isDisplayed();
    }
    public void clickTopUpBtn() { topUpBtn.click(); }
}
