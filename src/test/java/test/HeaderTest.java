package test;

import context.ContextHeader;
import context.ContextLogin;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTest extends BaseTest {

    @Test
    public void languageChange() {
        ContextHeader.getNameOfSelectedLang();
        String language = "язык";
        String messages = "Сообщения";
        ContextHeader.nameOfMessageMenu(language);
        Assert.assertEquals(ContextHeader.nameOfMessageMenu(language), messages);
    }
}
