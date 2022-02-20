package context;

import org.openqa.selenium.JavascriptExecutor;
import page.LoginPage;
import page.MainPage;
import page.ProfilePage;

import static test.BaseTest.driver;

public class ContextHeader {

    public static MainPage mainPage = new MainPage(driver);
    public static LoginPage loginPage = new LoginPage(driver);
    public static ProfilePage profilePage = new ProfilePage(driver);

    public static void displayProfileMenu() {
        mainPage.openProfileMenu();
        mainPage.clickOnProfileMenu();
    }

    public static void getNameOfSelectedLang() {

        if (!mainPage.isLangItemSelected()) {
            mainPage.clickLangItem1();
        }
        mainPage.getTextOfLangItem();
    }

    public static void changeSelectedLang() throws InterruptedException {

        if(!mainPage.isLangItemSelected()) {
            mainPage.clickLangItem2();
        }
        mainPage.explicitHeaderToBeVisible();
//        Thread.sleep(5000);
        mainPage.getTextOfLangItem();
    }

    public static String nameOfMessageMenu(String value) {
        if (mainPage.getTextOfLangItem().equals(value)) {
            return mainPage.getNameOfMessageMenu();
        } else {
            System.out.println("error");
        }
        return null;
    }

    public static void checkIfMsgSent() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, 250);");
//        mainPage.explicitMyMessagesBecomeClickable();
//        Thread.sleep(1000);
        mainPage.clickOnMessagesMenu();
//        mainPage.openMyMessages();
    }

    public static void checkLink() {
        mainPage.clickHelpLink();
    }
}
