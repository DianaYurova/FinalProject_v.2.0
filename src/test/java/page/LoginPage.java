package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy (xpath = "//section//button[@id= 'se_userLogin']")
    private WebElement enterBtn;

    @FindBy (xpath = "//label[@for='userEmail'][@class='error']")
    private WebElement errorUserEmailField;

    @FindBy (xpath = "//label[@for='userPass'][@class='error']")
    private WebElement errorUserPassField;

    @FindBy(xpath = "//section//li[@data-content= 'login']")
    private WebElement loginBox;

    @FindBy(xpath = "//section[@class= 'login-page has-animation']//a[@id = 'fblogin']")
    private WebElement fbBtn;

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
    public String getEmailErrorText() { return errorUserEmailField.getText(); }
    public String getPassErrorText() { return errorUserPassField.getText(); }
    public boolean loginBoxIsDisplayed() {  return loginBox.isDisplayed(); }
    public void clickFBBtn() { fbBtn.click(); }
    public String getCurrUrl() { return driver.getCurrentUrl();}
}
