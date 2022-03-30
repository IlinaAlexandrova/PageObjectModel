package admin_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import starts.Browser;

import java.util.Set;

public class InvoiceOrderAdminPage {


    @FindBy(css = "h1")
    public static WebElement orderNumberInvoiceOrderAdminPage;

    static {
        PageFactory.initElements(Browser.driver, InvoiceOrderAdminPage.class);
    }

    public static void switchToWindowByTitle(String title) {
        Set<String> windowHandles = Browser.driver.getWindowHandles();
        for (String currentWindowHandle : windowHandles) {
            Browser.driver.switchTo().window(currentWindowHandle);
            if (Browser.driver.getTitle().equals(title))  {
                break;
            }
        }
    }

    public static void verifySuccessfulPrintInvoice(){
        switchToWindowByTitle("Invoice");
        DashBoardAdminPage.waitTenSeconds.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".table.table-bordered:nth-of-type(1)")));
        Assert.assertEquals(orderNumberInvoiceOrderAdminPage.getText(), "Order (#492)");
    }



}
