package admin_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import starts.Browser;

public class CustomerAdminPage {

    @FindBy(xpath = "//*[@data-original-title='Add New']/.")
    public static WebElement buttonAddNewCustomer;

    @FindBy(id="input-firstname")
    public static WebElement firstNameNewCustomer;

    @FindBy(id="input-lastname")
    public static WebElement lastNameNewCustomer;

    @FindBy(id="input-email")
    public static WebElement emailNewCustomer;

    @FindBy(id="input-telephone")
    public static WebElement phoneNewCustomer;

    @FindBy(id="input-password")
    public static WebElement passwordNewCustomer;

    @FindBy(id="input-confirm")
    public static WebElement confirmPasswordNewCustomer;

    @FindBy(id="input-newsletter")
    public static WebElement newsletterSelectNewCustomer;

    @FindBy(xpath = "//*[@data-original-title='Save']/.")
    public static WebElement saveButtonNewCustomer;

    @FindBy(css=".alert-success")
    public static WebElement successAddedCustomer;

    @FindBy(id="button-filter")
    public static WebElement buttonFilterCustomerAdminPage;

    @FindBy(xpath = "//*[@data-original-title='Edit']/.")
    public static WebElement buttonEditCustomerAdminPage;

    @FindBy(css="#address-add .fa-plus-circle")
    public static WebElement buttonAddAddressCustomerAdminPage;

    @FindBy(id = "input-firstname1")
    public static WebElement firstnameNewAddressCustomerAdminPage;

    @FindBy(id = "input-lastname1")
    public static WebElement lastnameNewAddressCustomerAdminPage;

    @FindBy(id = "input-address-11")
    public static WebElement addressNewAddressCustomerAdminPage;

    @FindBy(id = "input-city1")
    public static WebElement cityNewAddressCustomerAdminPage;

    @FindBy(id = "input-country1")
    public static WebElement countryNewAddressCustomerAdminPage;

    @FindBy(id = "input-zone1")
    public static WebElement regionNewAddressCustomerAdminPage;

    @FindBy(name = "address[1][default]")
    public static WebElement radioButtonDefaultAddressNewAddressCustomerAdminPage;

    static {
        PageFactory.initElements(Browser.driver, CustomerAdminPage.class);
    }

    /**
     * This method creates new customer by admin
     * @param firstnameParam This is the first name of the customer
     * @param lastnameParam This is the last name of the customer
     * @param emailParam This is the email of the customer
     * @param phoneParam This is the phonenumber of the customer
     * @param passwordParam This is the password of the customer
     */

    public static void addNewCustomerAdminPage(String firstnameParam, String lastnameParam, String emailParam, String phoneParam, String passwordParam) {
        DashBoardAdminPage.goToCustomerAdminPage();
        buttonAddNewCustomer.click();
        firstNameNewCustomer.sendKeys(firstnameParam);
        lastNameNewCustomer.sendKeys(lastnameParam);

        if (emailParam.contains("@") && emailParam.contains(".")) {
            emailNewCustomer.sendKeys(emailParam);
        } else {
            emailNewCustomer.clear();
        }

        phoneNewCustomer.sendKeys(phoneParam);
        passwordNewCustomer.sendKeys(passwordParam);
        confirmPasswordNewCustomer.sendKeys(passwordParam);

        Select newsletterSelect = new Select(newsletterSelectNewCustomer);
        newsletterSelect.selectByValue("1");

        saveButtonNewCustomer.click();
    }

    /**
     * This method verify successful adding of new customer
     */
    public static void verifyNewCustomerSuccessfullyAdded(){
        Assert.assertTrue(successAddedCustomer.getText().contains("Success"));
    }

    public static void addAddressOfExistingCustomerAdminPage(String emailParam, String firstnameNewAddress,String lastnameNewAddress, String addressNewAddress, String cityNewAddress, String countryNewAddress, String regionNewAddress ){
        DashBoardAdminPage.goToCustomerAdminPage();

        emailNewCustomer.sendKeys(emailParam);
        buttonFilterCustomerAdminPage.click();
        buttonEditCustomerAdminPage.click();
        buttonAddAddressCustomerAdminPage.click();

        DashBoardAdminPage.waitTenSeconds.until(ExpectedConditions.visibilityOf(firstnameNewAddressCustomerAdminPage));
        firstnameNewAddressCustomerAdminPage.sendKeys(firstnameNewAddress);
        lastnameNewAddressCustomerAdminPage.sendKeys(lastnameNewAddress);
        addressNewAddressCustomerAdminPage.sendKeys(addressNewAddress);
        cityNewAddressCustomerAdminPage.sendKeys(cityNewAddress);

        DashBoardAdminPage.waitTenSeconds.until(ExpectedConditions.visibilityOf(countryNewAddressCustomerAdminPage));
        Select country = new Select(countryNewAddressCustomerAdminPage);
        DashBoardAdminPage.waitTenSeconds.until(ExpectedConditions.visibilityOfAllElements(countryNewAddressCustomerAdminPage));
        country.selectByVisibleText(countryNewAddress);

        DashBoardAdminPage.waitTenSeconds.until(ExpectedConditions.visibilityOf(regionNewAddressCustomerAdminPage));
        Select region = new Select(regionNewAddressCustomerAdminPage);
        DashBoardAdminPage.waitTenSeconds.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[value='505']")));
        region.selectByVisibleText(regionNewAddress);

        if (!radioButtonDefaultAddressNewAddressCustomerAdminPage.isSelected()){
            radioButtonDefaultAddressNewAddressCustomerAdminPage.click();
        }

        saveButtonNewCustomer.click();

    }


}
