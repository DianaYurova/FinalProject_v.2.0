package context;

import page.LoginPage;
import page.MainPage;
import page.ProfilePage;

import static test.BaseTest.driver;

public class Context {

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
    public static void displayProfileMenu() {
//        mainPage.explicitPageReload();
        mainPage.openProfileMenu();
        mainPage.clickOnProfileMenu();
//        mainPage.getUsername();
    }

    public static void getNameOfSelectedLang() {

        if (!mainPage.isLangItemSelected()) {
            mainPage.clickLangItem();
        }
        mainPage.getTextOfLangItem();
    }

    public static String nameOfMesageMenu(String value) {
        if (mainPage.getTextOfLangItem().equals(value)) {
            return mainPage.getNameOfMessageMenu();
        } else {
            System.out.println("error");
        }
        return null;
    }
}
