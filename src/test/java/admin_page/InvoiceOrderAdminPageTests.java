package admin_page;

import org.testng.annotations.Test;
import starts.BaseTest;

public class InvoiceOrderAdminPageTests extends BaseTest {

    @Test
    public static void printInvoiceOfExistingOrder(){
        LoginAdminPage.goTo();
        LoginAdminPage.loginInTheAdminPage("admin", "parola123!");
        DashBoardAdminPage.verifyExactAccountInTheAdminPage("Milen Strahinski");
        DashBoardAdminPage.goToOrderSalesAdminPage();
        OrderAdminPage.printInvoiceOfOrderAdminPage("492");
        InvoiceOrderAdminPage.verifySuccessfulPrintInvoice();
    }
}
