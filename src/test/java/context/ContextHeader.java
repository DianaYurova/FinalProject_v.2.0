package context;

import page.LoginPage;
import page.MainPage;
import page.ProfilePage;

import static test.BaseTest.driver;

public class ContextHeader {

    public static MainPage mainPage = new MainPage(driver);
    public static LoginPage loginPage = new LoginPage(driver);
    public static ProfilePage profilePage = new ProfilePage(driver);

    public static void login(String email, String password) {
        mainPage.clickProfileBtn();
        loginPage.inputEmailValue(email);
        loginPage.inputPasswordValue(password);
        loginPage.explicitEnterBtn();
        loginPage.clickEnterBtn();
    }

    public static void loginNoEmail(String password) {
        mainPage.clickProfileBtn();
        loginPage.inputPasswordValue(password);
        loginPage.explicitEnterBtn();
        loginPage.clickEnterBtn();
    }

    public static void loginNoPass(String email) {
        mainPage.clickProfileBtn();
        loginPage.inputEmailValue(email);
        loginPage.explicitEnterBtn();
        loginPage.clickEnterBtn();
    }

    public static void getEmailErrorMsg() {
        loginPage.getEmailErrorText();
    }

    public static void getPassErrorMsg() {
        loginPage.getPassErrorText();
    }

    public static void displayProfileMenu() {
        mainPage.openProfileMenu();
        mainPage.clickOnProfileMenu();
    }

    public static void getNameOfSelectedLang() {

        if (!mainPage.isLangItemSelected()) {
            mainPage.clickLangItem();
        }
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
