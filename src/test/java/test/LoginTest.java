package test;

import context.ContextLogin;
import org.testng.Assert;
import org.testng.annotations.Test;

import static context.ContextLogin.*;

public class LoginTest  extends  BaseTest{

    @Test
    public void loginTest() {
        String email = "diankatestmail@gmail.com";
        String password = "Dianka123";
        ContextLogin.login(email, password);
        Assert.assertTrue(profilePage.isDisplayedBox());
    }
    @Test
    public void loginWrongPass() {
        String email = "diankatestmail@gmail.com";
        String password = "Dianka";
        String errorMessage = "Неверный логин или пароль";
        ContextLogin.login(email, password);
        Assert.assertEquals (getPassErrorMsg(), errorMessage);
    }

    @Test
    public void loginMissedEmail() {
//        String email = "diankatestmail@gmail.com";
        String password = "Dianka";
        String errorMessage = "Поле обязательно для заполнения";
        ContextLogin.loginNoEmail(password);
        Assert.assertEquals (getEmailErrorMsg(), errorMessage);
    }

    @Test
    public void loginMissedPass() {
        String email = "diankatestmail@gmail.com";
//        String password = "Dianka";
        String errorMessage = "Поле обязательно для заполнения";
        ContextLogin.loginNoPass(email);
        Assert.assertEquals (getPassErrorMsg(), errorMessage);
    }
}
