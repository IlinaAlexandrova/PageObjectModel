package starts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

   @BeforeMethod
   public static void setup(){
        Browser.setupBrowser();
   }

    @AfterMethod
    public static void quit(){
        Browser.quitBrowser();
    }

}
