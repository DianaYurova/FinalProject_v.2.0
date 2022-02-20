package test;

import configuration.ConfigProperties;
import context.ContextHeader;
import org.testng.Assert;
import org.testng.annotations.Test;

import static context.ContextHeader.mainPage;

public class  HeaderTest extends BaseTest {

    @Test(priority = 0)
    public void languageCheck() {
        driver.get(ConfigProperties.getProperty("mainPage"));
        ContextHeader.getNameOfSelectedLang();
        String language = "язык";
        String messages = "Сообщения";
        ContextHeader.nameOfMessageMenu(language);
        Assert.assertEquals(ContextHeader.nameOfMessageMenu(language), messages);
    }
//
//    @Test(priority = 1)
//    public void languageChange() throws InterruptedException {
//        driver.get(ConfigProperties.getProperty("mainPage"));
//        ContextHeader.changeSelectedLang();
//        String language1 = "мова";
//        String messages1 = "Повідомлення";
//        ContextHeader.nameOfMessageMenu(language1);
//        Assert.assertTrue(ContextHeader.nameOfMessageMenu(language1).equals(messages1));
//        Thread.sleep(5000);
//        mainPage.clickLangItem1();
//    }

    @Test(priority = 2)
    public void checkFooterRedirect() {
        driver.get(ConfigProperties.getProperty("mainPage"));
        ContextHeader.checkLink();
        Assert.assertTrue(mainPage.getCurrUrl().contains("help"));
    }
}
