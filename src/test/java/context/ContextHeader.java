package context;

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
}
