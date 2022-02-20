package test;

import configuration.ConfigProperties;
import context.ContextWallet;
import org.testng.Assert;
import org.testng.annotations.Test;

import static context.ContextWallet.walletPage;

public class WalletTest extends BaseTest {

    @Test(priority = 17)
    public void rcheckPaymentPage() {
//        LoginTest.mloginZTest();
//        driver.get(ConfigProperties.getProperty("mainPage"));
        ContextWallet.checkPageAvailable();
        Assert.assertTrue(walletPage.presenceOfPaymentInfoMsg());
    }

    @Test(priority = 18)
    public void sanotherPaymentAmountAvailable() throws InterruptedException {
//        LoginTest.loginZTest();
//        driver.get(ConfigProperties.getProperty("mainPage"));
        ContextWallet.checkAnotherAmount();
        Assert.assertTrue(walletPage.presenceOfPaymentInfoMsg());
    }

    @Test(priority = 19)
    public void tprivatPaymentAvailable() throws InterruptedException {
//        LoginTest.loginZTest();
//        driver.get(ConfigProperties.getProperty("mainPage"));
        ContextWallet.checkPrivatPayment();
        Thread.sleep(5000);
        Assert.assertTrue(walletPage.getCurrUrl().contains("privat24"));
    }
}
