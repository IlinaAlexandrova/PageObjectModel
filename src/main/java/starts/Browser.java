package starts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Browser {

    public static WebDriver driver;

    @BeforeMethod
    public static void setupBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Petar\\Desktop\\Selenium\\BrowsersDrivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public static void quitBrowser(){
        driver.quit();
    }
}
