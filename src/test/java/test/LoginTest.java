package test;

import context.ContextLogin;
import org.testng.Assert;
import org.testng.annotations.Test;

import static context.ContextLogin.*;

public class LoginTest extends BaseTest{

    @Test(priority = 12)
    public static void loginZTest() {
        String email = "diankatestmail@gmail.com";
        String password = "Dianka123";
        ContextLogin.login(email, password);
        Assert.assertTrue(profilePage.isDisplayedBox());
    }
    @Test(priority = 11)
    public void loginWrongPass() {
        String email = "diankatestmail@gmail.com";
        String password = "Dianka1234567";
        String errorMessage = "Неверный логин или пароль";
        ContextLogin.login(email, password);
        Assert.assertEquals (getPassErrorMsg(), errorMessage);
    }

    @Test(priority = 9)
    public void loginMissedEmail() {
//        String email = "diankatestmail@gmail.com";
        String password = "Dianka";
        String errorMessage = "Поле обязательно для заполнения";
        ContextLogin.loginNoEmail(password);
        Assert.assertEquals (getEmailErrorMsg(), errorMessage);
    }

    @Test(priority = 10)
    public void loginMissedPass() {
        String email = "diankatestmail@gmail.com";
//        String password = "Dianka";
        String errorMessage = "Поле обязательно для заполнения";
        ContextLogin.loginNoPass(email);
        Assert.assertEquals (getPassErrorMsg(), errorMessage);
    }

    @Test(priority = 8)
    public void checkFbRedirect() {
        ContextLogin.clickFbBtn();
        Assert.assertTrue(loginPage.getCurrUrl().contains("facebook"));
    }
}
