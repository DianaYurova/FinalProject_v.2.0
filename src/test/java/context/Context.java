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

        mainPage.explicitCookiesBtn();
        mainPage.closeCookiesWarning();
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
}
