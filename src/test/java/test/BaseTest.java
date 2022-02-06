package test;

import configuration.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public abstract class BaseTest {
    public static WebDriver driver;
    public static WebElement webElement;


    @BeforeClass(alwaysRun = true)
    public static void setup() {
//        System.setProperty("webdriver.chrome.driver", ConfigProperties.getProperty("chromedriver"));
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.get(ConfigProperties.getProperty("mainPage"));
//        driver.findElement(By.name(".cookie-close abs cookiesBarClose")).click();
    }
    @AfterClass(alwaysRun = true)
    public static void after() {
        driver.close();

    }
}
