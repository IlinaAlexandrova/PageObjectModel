package admin_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import starts.Browser;

public class DashBoardAdminPage {

    public static WebDriverWait waitTenSeconds = new WebDriverWait(Browser.driver, 10);

    @FindBy(xpath = "//*[@id='user-profile']/..")
    public static WebElement usernameExactAccount;

    @FindBy(css = "#menu-customer .fa-user")
    public static WebElement customersMainMenu;

    @FindBy(css = "#menu-customer>ul>li>a")
    public static WebElement customersMenuCustomer;

    @FindBy(id="menu-sale")
    public static WebElement salesMainMenu;

    @FindBy(css = "#menu-sale>ul>li>a")
    public static WebElement ordersMenuCustomer;

    static {
        PageFactory.initElements(Browser.driver, DashBoardAdminPage.class);
    }

    /**
     * This method verify successful login with exact user
     * @param expectedUsernameName This is the user that we expect to be login
     */
    public static void verifyExactAccountInTheAdminPage(String expectedUsernameName){
        waitTenSeconds.until(ExpectedConditions.visibilityOf(usernameExactAccount));
        Assert.assertEquals(usernameExactAccount.getText(), expectedUsernameName);
    }

    /**
     * With this method goes to customer page of admin panel
     */
    public static void goToCustomerAdminPage(){
        waitTenSeconds.until(ExpectedConditions.visibilityOf(customersMainMenu));
        customersMainMenu.click();
        waitTenSeconds.until(ExpectedConditions.elementToBeClickable(customersMenuCustomer));
        customersMenuCustomer.click();
    }

    /**
     * With this method goes to orders page of admin panel
     */
    public static void goToOrderSalesAdminPage(){
        waitTenSeconds.until(ExpectedConditions.visibilityOf(salesMainMenu));
        salesMainMenu.click();
        waitTenSeconds.until(ExpectedConditions.elementToBeClickable(ordersMenuCustomer));
        ordersMenuCustomer.click();
    }

}
