package admin_page;

import org.testng.annotations.Test;
import starts.BaseTest;

public class OrdersAdminPageTests extends BaseTest {

    @Test
    public static void changeOrderHistory(){
        LoginAdminPageTests.loginSuccessfully();
        DashBoardAdminPage.goToOrderSalesAdminPage();
        OrderAdminPage.successfullyChangeHistoryOrderAdminPageOfExistingOrder("492");
        OrderAdminPage.verifySuccessfullyChangeOrderHistory();
    }

}
