package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    public WebDriver driver;

    public MainPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
