package test;

import configuration.ConfigProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;

import static context.Context.mainPage;

public abstract class BaseTest {

    public static WebDriver driver;
    public static WebElement webElement;

    @BeforeMethod(alwaysRun = true)
    public static void setup() {
//        System.setProperty("webdriver.chrome.driver", ConfigProperties.getProperty("chromedriver"));
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver();
//        driver.manage().deleteAllCookies();
//        driver.get("chrome://settings/clearBrowserData");
//        driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.get(ConfigProperties.getProperty("mainPage"));
        mainPage.explicitCookiesBtn();
        mainPage.closeCookiesWarning();
    }
    @AfterMethod(alwaysRun = true)
    public static void after() {
        driver.close();
        // driver.quit();

    }
}
