package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CandidatePage extends BasePage{

    public WebDriver driver;

    public CandidatePage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getElementByXpathContainsText(String xpath)
    {
        return driver.findElement(new By.ByXPath(xpath));
    }

    @FindBy(xpath = "//button[@data-testid = 'select-profil']")
    private WebElement candidateProfile;

    @FindBy(xpath = "//button[@data-testid = 'dashboard-summary-tooltip-button']")
    private WebElement acceptInfoMsgBtn;

    @FindBy(xpath = "//button[@data-cy = 'edit-basic-info']")
    private WebElement editProfileBtn;

    @FindBy(xpath = "//input[@aria-labelledby = 'firstName-label']")
    private WebElement firstNameInputField;

    @FindBy(xpath = "//input[@aria-labelledby = 'lastName-label']")
    private WebElement lastNameInputField;

    @FindBy(xpath = "//input[@aria-labelledby = 'phoneNumber-label']")
    private WebElement phoneInputField;

    @FindBy(xpath = "//input[@aria-labelledby = 'emailAddress-label']")
    private WebElement emailInputField;

    @FindBy(xpath = "//select[@aria-labelledby = 'yearOfBirth-label']/option[@value = '2000']")
    private WebElement yearOfBirth;

    @FindBy(xpath = "//button[@data-testid = 'submit-btn']")
    private WebElement submitbtn;

    @FindBy(xpath = "//p[@class = 'basicinfofields__firstnamelastname css-utexlf']")
    private static WebElement nameAndLastname;

    @FindBy(xpath = "//button[@data-cy = 'delete-profile']")
    private WebElement deleteProfileBtn;

    @FindBy(xpath = "//h1[@id = 'modal_label']")
    private WebElement modalLeft;

    @FindBy(xpath = "//button[@class = 'css-10939bk-BaseStyles']")
    private WebElement yesDeleteBtn;

    public void openCandidateProfileTab() { candidateProfile.click(); }
    public void clickAcceptInfoMsgBtn() { acceptInfoMsgBtn.click(); }
    public void clickEditProfileBtn() { editProfileBtn.click(); }

    public void setFirstName (String firstName) {
        firstNameInputField.clear();
        firstNameInputField.sendKeys(firstName); }
    public void setLastName (String lastName) {
        lastNameInputField.clear();
        lastNameInputField.sendKeys(lastName); }
    public void setPhone (String phone) {
        phoneInputField.clear();
        phoneInputField.sendKeys(phone); }
    public void setEmail (String emailToInput) {
        emailInputField.clear();
        emailInputField.sendKeys(emailToInput); }

    public void selectYearOfBirth () { yearOfBirth.click(); }
    public void clickSubmitBtn() { submitbtn.click(); }
    public String getNameAndLastName() { return nameAndLastname.getText(); }
    public void deleteProfile() {
        deleteProfileBtn.click();
        WebElement waitModal = (new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                    .visibilityOf(modalLeft)));
        yesDeleteBtn.click();
    }
    public String getNameAndLastNameAtr() { return nameAndLastname.getAttribute("value"); }
}
