package test;

import context.ContextHeader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class  HeaderTest extends BaseTest {

    @Test
    public void languageCheck() {
        ContextHeader.getNameOfSelectedLang();
        String language = "язык";
        String messages = "Сообщения";
        ContextHeader.nameOfMessageMenu(language);
        Assert.assertEquals(ContextHeader.nameOfMessageMenu(language), messages);
    }

    @Test
    public void languageChange() throws InterruptedException {
        ContextHeader.changeSelectedLang();
        String language1 = "мова";
        String messages1 = "Повідомлення";
        ContextHeader.nameOfMessageMenu(language1);
        Assert.assertTrue(ContextHeader.nameOfMessageMenu(language1).equals(messages1));
    }
}
