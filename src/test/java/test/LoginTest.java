package test;

import context.Context;
import org.testng.Assert;
import org.testng.annotations.Test;

import static context.Context.profilePage;

public class LoginTest extends BaseTest {

    @Test(groups = {"Positives"})
    public void loginTest() throws InterruptedException {
        String email = "diankatestmail@gmail.com";
        String password = "Dianka123";
        //String username = "diankatestmail";
        Context.login(email, password);
        Assert.assertTrue(profilePage.isDisplayedBox());
//        Context.displayProfileMenu();

    }

}
