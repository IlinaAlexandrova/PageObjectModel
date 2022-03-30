package admin_page;

import org.testng.annotations.Test;
import starts.BaseTest;

public class LoginAdminPageTests extends BaseTest {

    @Test
    public static void loginSuccessfully(){
        LoginAdminPage.goTo();
        LoginAdminPage.loginInTheAdminPage("admin", "parola123!");
        DashBoardAdminPage.verifyExactAccountInTheAdminPage("Milen Strahinski");
    }


}
