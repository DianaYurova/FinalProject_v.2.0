package context;

import page.LoginPage;
import page.MainPage;
import page.ProfilePage;

import static test.BaseTest.driver;

public class ContextLogin {

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

    public static String getEmailErrorMsg() {
       return loginPage.getEmailErrorText();
    }

    public static String getPassErrorMsg() { return loginPage.getPassErrorText(); }
}
