package test;

import context.ContextLogin;
import org.testng.Assert;
import org.testng.annotations.Test;

import static context.ContextLogin.*;

public class LoginTest extends BaseTest{

    @Test(priority = 12)
    public static void mloginZTest() {
        String email = "diankatestmail@gmail.com";
        String password = "Dianka123";
        ContextLogin.login(email, password);
        Assert.assertTrue(profilePage.isDisplayedBox());
    }
    @Test(priority = 11)
    public void lloginWrongPass() {
        String email = "diankatestmail@gmail.com";
        String password = "Dianka1234567";
        String errorMessage = "Неверный логин или пароль";
        ContextLogin.login(email, password);
        Assert.assertEquals (getPassErrorMsg(), errorMessage);
    }

    @Test(priority = 9)
    public void jloginMissedEmail() {
//        String email = "diankatestmail@gmail.com";
        String password = "Dianka";
        String errorMessage = "Поле обязательно для заполнения";
        ContextLogin.loginNoEmail(password);
        Assert.assertEquals (getEmailErrorMsg(), errorMessage);
    }

    @Test(priority = 10)
    public void kloginMissedPass() {
        String email = "diankatestmail@gmail.com";
//        String password = "Dianka";
        String errorMessage = "Поле обязательно для заполнения";
        ContextLogin.loginNoPass(email);
        Assert.assertEquals (getPassErrorMsg(), errorMessage);
    }

    @Test(priority = 8)
    public void icheckFbRedirect() {
        ContextLogin.clickFbBtn();
        Assert.assertTrue(loginPage.getCurrUrl().contains("facebook"));
    }
}
