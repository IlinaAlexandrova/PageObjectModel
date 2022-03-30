package admin_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import starts.Browser;

public class OrderAdminPage {


    @FindBy(id = "input-order-id")
    public static WebElement orderID;

    @FindBy(id = "button-filter")
    public static WebElement buttonFilterOrderPage;

    @FindBy(xpath = "//*[@data-original-title='View']/.")
    public static WebElement buttonViewOrderAdminPage;


    @FindBy(id = "input-order-status")
    public static WebElement changeOrderStatusOrderAdminPage;

    @FindBy(id = "input-notify")
    public static WebElement checkboxNotifyCustomerOrderAdminPage;

    @FindBy(id = "button-history")
    public static WebElement buttonAddHistoryOrdersAdminPage;

    @FindBy(css = ".alert-success")
    public static WebElement successfullyChangeHistoryOrderAdminPage;

    @FindBy(xpath = "//*[@data-original-title='Print Invoice']")
    public static WebElement buttonPrintInvoiceOfOrderAdminPage;

    static {
        PageFactory.initElements(Browser.driver, OrderAdminPage.class);
    }

    /**
     * This method changes succesfully order history of existing order
     * @param orderIDParam order with this orderID will be changed
     */
    public static void successfullyChangeHistoryOrderAdminPageOfExistingOrder(String orderIDParam){
        DashBoardAdminPage.goToOrderSalesAdminPage();
        orderID.sendKeys(orderIDParam);
        buttonFilterOrderPage.click();

        buttonViewOrderAdminPage.click();

        DashBoardAdminPage.waitTenSeconds.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[value='16']")));
        Select changeOrderStatus = new Select(changeOrderStatusOrderAdminPage);
        changeOrderStatus.selectByValue("3");

        if (!checkboxNotifyCustomerOrderAdminPage.isSelected()){
            checkboxNotifyCustomerOrderAdminPage.click();
        }

        buttonAddHistoryOrdersAdminPage.click();

    }

    /**
     * This method verifies success of changing order history
     */
    public static void verifySuccessfullyChangeOrderHistory(){
        DashBoardAdminPage.waitTenSeconds.until(ExpectedConditions.visibilityOf(successfullyChangeHistoryOrderAdminPage));
        Assert.assertTrue(successfullyChangeHistoryOrderAdminPage.getText().contains("Success"));
    }

    /**
     * This method prints invoice by its order number
     * @param orderIDParam - the order number of the invoice you want to print
     */
    public static void printInvoiceOfOrderAdminPage(String orderIDParam){
        DashBoardAdminPage.goToOrderSalesAdminPage();
        orderID.sendKeys(orderIDParam);
        buttonFilterOrderPage.click();

        buttonViewOrderAdminPage.click();
        buttonPrintInvoiceOfOrderAdminPage.click();
    }

}
