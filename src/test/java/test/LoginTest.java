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
import static context.Context.profilePage;

public class LoginTest  extends  BaseTest{

    public static WebDriver driver;
    public static WebElement webElement;

    @Test(groups = {"Positives"})
    public void loginTest() {
        String email = "diankatestmail@gmail.com";
        String password = "Dianka123";
        Context.login(email, password);
        Assert.assertTrue(profilePage.isDisplayedBox());
    }

}
