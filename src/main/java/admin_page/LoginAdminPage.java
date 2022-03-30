package admin_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import starts.Browser;

public class LoginAdminPage {

    @FindBy(id="input-username")
    public static WebElement usernameAdmin;

    @FindBy(id="input-password")
    public static WebElement passwordAdmin;

    @FindBy(className = "btn-primary")
    public static WebElement loginButtonAdmin;

    static{
        PageFactory.initElements(Browser.driver, LoginAdminPage.class);
    }

    /**
     * This method opens admin page
     */
    public static void goTo(){
        Browser.driver.get("http://shop.pragmatic.bg/admin/");
    }

    /**
     * This method logs in the admin page
     * @param adminUsernameParam this is the admin username
     * @param adminPasswordParam this is the admin password
     */
    public static void loginInTheAdminPage(String adminUsernameParam, String adminPasswordParam){
        usernameAdmin.sendKeys(adminUsernameParam);
        passwordAdmin.sendKeys(adminPasswordParam);
        loginButtonAdmin.click();
    }









}
