package admin_page;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import starts.BaseTest;

public class CustomerAdminPageTests extends BaseTest {

    @DataProvider
    public Object[][] testData(){
        String[][] testDataArray =
                {
                        {"Ivan", "Ivanov", "ivanov@bg.bg", "0582152654", "par123"},
                        {"Mitko", "Dimitrov", "mite@fggf.bg", "3256156987", "1236hf"},
                        {"Lili", "Ivanova", "lileto@kh.bgnj", "5698745632", "fdjifgr5"},
                };
        return testDataArray;
    }

    @Test (dataProvider = "testData")
    public static void addSuccessfullyNewCustomerByAdmin(){
        LoginAdminPageTests.loginSuccessfully();
        CustomerAdminPage.addNewCustomerAdminPage("Georgi", "Georgiev", "gogo@gmail.com", "0885669552", "parola5");
        CustomerAdminPage.verifyNewCustomerSuccessfullyAdded();
    }

    @Test
    public static void addAddressToExistingCustomer(){
        LoginAdminPageTests.loginSuccessfully();
        DashBoardAdminPage.goToCustomerAdminPage();
        CustomerAdminPage.addAddressOfExistingCustomerAdminPage("ilina3alexandrova@gmail.com", "Ilina", "Alexandrova", "6 Munchen", "Sofia", "Bulgaria", "Sofia - town");
        CustomerAdminPage.verifyNewCustomerSuccessfullyAdded();
    }



}
