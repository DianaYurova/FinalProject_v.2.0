package test;

import configuration.ConfigProperties;
import context.ContextWallet;
import org.testng.Assert;
import org.testng.annotations.Test;

import static context.ContextWallet.walletPage;

public class WalletTest extends BaseTest {

    @Test(priority = 17)
    public void checkPaymentPage() {
//        LoginTest.loginZTest();
        driver.get(ConfigProperties.getProperty("mainPage"));
        ContextWallet.checkPageAvailable();
        Assert.assertTrue(walletPage.presenceOfPaymentInfoMsg());
    }

    @Test(priority = 18)
    public void anotherPaymentAmountAvailable() throws InterruptedException {
//        LoginTest.loginZTest();
        driver.get(ConfigProperties.getProperty("mainPage"));
        ContextWallet.checkAnotherAmount();
        Assert.assertTrue(walletPage.presenceOfPaymentInfoMsg());
    }

    @Test(priority = 19)
    public void privatPaymentAvailable() throws InterruptedException {
//        LoginTest.loginZTest();
        driver.get(ConfigProperties.getProperty("mainPage"));
        ContextWallet.checkPrivatPayment();
        Thread.sleep(5000);
        Assert.assertTrue(walletPage.getCurrUrl().contains("privat24"));
    }
}
