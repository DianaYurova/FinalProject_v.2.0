package context;

import org.openqa.selenium.JavascriptExecutor;
import page.*;

import static test.BaseTest.driver;

public class ContextWallet {

//    public static WebElement dynamicElement4;

    public static MainPage mainPage = new MainPage(driver);
    public static LoginPage loginPage = new LoginPage(driver);
    public static ProfilePage profilePage = new ProfilePage(driver);
    public static SearchPage searchPage =  new SearchPage(driver);
    public static CandidatePage candidatePage =  new CandidatePage(driver);
    public static WalletPage walletPage = new WalletPage(driver);

    public static void checkPageAvailable() {
        mainPage.openProfileMenu();
        mainPage.clickPaymentLink();
        profilePage.clickTopUpBtn();
        walletPage.clickSubmitPaymentAmountBtn();
        walletPage.selectPayByCC();

    }

    public static void checkAnotherAmount() throws InterruptedException {
        mainPage.openProfileMenu();
        mainPage.clickPaymentLink();
        profilePage.clickTopUpBtn();
        Thread.sleep(3000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 2100);");
//        dynamicElement4 = new WebDriverWait(driver, Duration.ofSeconds(10))
//                    .until(ExpectedConditions.presenceOfElementLocated
//                            (By.xpath("//input[@data-plutus = '59999']")));
        Thread.sleep(3000);
        walletPage.explicitBiggestAmountToBeClickable();
        walletPage.selectBiggestPaymentAmount();
        walletPage.clickSubmitPaymentAmountBtn();
        walletPage.selectPayByCC();
    }

    public static void checkPrivatPayment() {
        mainPage.openProfileMenu();
        mainPage.clickPaymentLink();
        profilePage.clickTopUpBtn();
        walletPage.selectPrivat24Payment();
        walletPage.clickSubmitPaymentAmountBtn();
    }
}
