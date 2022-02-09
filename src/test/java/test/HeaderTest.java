package test;

import configuration.ConfigProperties;
import context.Context;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static context.Context.mainPage;

public class HeaderTest extends BaseTest {

    @Test
    public void languageChange() {
        Context.getNameOfSelectedLang();
        String language = "язык";
        String messages = "Сообщения";
        Context.nameOfMesageMenu(language);
        Assert.assertEquals(Context.nameOfMesageMenu(language), messages);
    }
}
