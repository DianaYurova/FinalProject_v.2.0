package test;

import configuration.ConfigProperties;
import context.ContextAdOperations;
import context.ContextLogin;
import context.ContextSearch;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdOperationsTest extends BaseTest {

    @Test(priority = 13)
    public void sendMessage() throws InterruptedException {
//        LoginTest.loginZTest();
        driver.get("https://www.olx.ua/d/obyavlenie/prodam-svoyu-3k-s-kapitalnym-remontom-novye-doma-dvorets-sporta-IDM9AyO.html#173513b8eb");
        String text = "test 22";
        ContextAdOperations.sendMsgToAuthor(text);
//        ContextAdOperations.waitForNotification();
//        Assert.assertTrue(ContextAdOperations.isNotificationDisplayed());
        driver.get("https://www.olx.ua/myaccount/answers/");
//        ContextHeader.checkIfMsgSent();
        Assert.assertEquals(ContextAdOperations.textOfLastMsg(), text);
    }

    @Test(priority = 3)
    public void sendMessageByUnauthorizedUser() throws InterruptedException {
        driver.get(ConfigProperties.getProperty("mainPage"));
        ContextSearch.byCategory();
        ContextSearch.openRandomAd();
        String text = "123";
        ContextAdOperations.tryToSendMsg(text);
        Assert.assertTrue(ContextLogin.isLoginBoxDisplayed());
    }

}
