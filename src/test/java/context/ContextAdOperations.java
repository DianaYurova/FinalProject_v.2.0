package context;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.*;

import java.time.Duration;

import static test.BaseTest.driver;

public class ContextAdOperations {

    public static MainPage mainPage = new MainPage(driver);
    public static LoginPage loginPage = new LoginPage(driver);
    public static ProfilePage profilePage = new ProfilePage(driver);
    public static SearchPage searchPage =  new SearchPage(driver);
    public static CandidatePage candidatePage =  new CandidatePage(driver);
    public static AdPage adPage = new AdPage(driver);

    public static void sendMsgToAuthor(String text) {
        adPage.sendMsg();
        adPage.inputTextMsg(text);
        adPage.submitSendMsg();
    }

    public static void tryToSendMsg(String text) throws InterruptedException {
//        adPage.sendMsg();
        Thread.sleep(3000);
        adPage.inputTextMsg(text);
//        adPage.submitSendMsg();
//        Thread.sleep(1000);
//        adPage.putCursorToInput();
    }

    public static void waitForNotification() {
        WebElement notification = (new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
            .visibilityOf(adPage.successNotification)));
    }

    public static String textOfLastMsg() { return mainPage.getTextOfLastMsg(); }
    public static boolean isNotificationDisplayed() { return adPage.notificationIsdisplayed(); }
    public static String getFavoriteCountBefore() { return mainPage.getFavCount(); }
    public static String getFavoriteCountAfter() { return mainPage.getFavCount(); }
}
