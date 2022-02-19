package test;

import context.ContextWallet;
import org.testng.Assert;
import org.testng.annotations.Test;

import static context.ContextWallet.walletPage;

public class WalletTest extends BaseTest {

    @Test
    public void checkPaymentPage() {
        LoginTest.loginZTest();
        ContextWallet.checkPageAvailable();
        Assert.assertTrue(walletPage.presenceOfPaymentInfoMsg());
    }

    @Test
    public void anotherPaymentAmountAvailable() throws InterruptedException {
        LoginTest.loginZTest();
        ContextWallet.checkAnotherAmount();
        Assert.assertTrue(walletPage.presenceOfPaymentInfoMsg());
    }
}
