package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static page.BasePage.explicitToBeClickable;

public class LoginPage extends BasePage {

    public WebDriver driver;
    public WebElement webElement;

    public LoginPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//input[@id = 'userEmail'][1]")
    private WebElement emailField;

    @FindBy (xpath = "//input[@id = 'userPass'][1]")
    private WebElement passwordField;

    @FindBy (id = "se_userLogin")
    private WebElement enterBtn;

    public void inputEmailValue(String value) {
        emailField.sendKeys(value);
    }
    public void inputPasswordValue(String password) {
        passwordField.sendKeys(password);
    }
    public void explicitEnterBtn() {explicitToBeClickable(enterBtn);}
    public void clickEnterBtn() {
        enterBtn.click();
    }
}
