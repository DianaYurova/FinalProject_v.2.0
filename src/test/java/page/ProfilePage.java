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
    public WebElement userAccountInfo;

    public boolean isDisplayedBox() {
        return userAccountInfo.isDisplayed();
    }
}
