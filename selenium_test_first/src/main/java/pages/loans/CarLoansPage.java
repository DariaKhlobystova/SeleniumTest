package pages.loans;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class CarLoansPage extends BasePage {
    public CarLoansPage(WebDriver driver) {
        super(driver);
    }

    private final By tabAgreements = By.xpath("//div[contains(text(), 'Agreements')]");
    private final By amountFieldCarCost = By.xpath("//input[@data-qa-node='amount']");
    private final By amountFieldPrepaidExpense = By.xpath("//input[@data-qa-node='prepaid']");
    private final By phoneCodeButton = By.xpath("//button[@data-qa-node='phone-code']");
    private final By searchPhoneCodeField = By.xpath("//input[@placeholder='Search']");
    private final By phoneNumberField = By.xpath("//input[@data-qa-node='phone-code']");
    private final By applyOrderButton = By.xpath("//button[@type='button']");
    private final By selectedUsedAutoTab = By.xpath("//div[@data-qa-node='type']");
    private final By confirmForm = By.xpath("//div[contains(text(), 'One-time password has been forwarded to yor phone')]");
    private final By buttonCountryRussia = By.xpath("//div[@name='Russia']");



    /**
     * Selecting a tab agreements
     * */

    public CarLoansPage selectAgreementsTab() {
        driver.findElement(tabAgreements).click();
        return this;
    }

    /**
     * Test display of the form confirmation of transaction
     * */

    public CarLoansPage checkIsDisplayedConfirm() {
        waitElementIsVisible(driver.findElement(confirmForm));
        return this;
    }

    /**
     * Enter the amount of the cat value
     * @param amount the full cost of a car
     * */

    public CarLoansPage enterAmountFieldCArCost (String amount) {
        WebElement amountField = driver.findElement(amountFieldCarCost);
        clearAndType(amountField, amount);
        return this;
    }

    /**
     * Enter the advance amount for the loan
     * @param amount the amount of the advance payment
     * */
    public CarLoansPage enterAmountFieldPrepaidExpense(String amount) {
        WebElement amountField = driver.findElement(amountFieldPrepaidExpense);
        clearAndType(amountField, amount);
        return this;
    }
    /**
     * Filling in the mobile number to apply
     * @param phoneNumber mobile number to apply
     * */
    public CarLoansPage enterPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).clear();
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        return this;
    }
    /**
     * Search country code for the mobile communication
     * @param phoneNumber mobile number to apply
     * */
    public CarLoansPage searchPhoneCountryCodeField(String phoneNumber) {
        driver.findElement(searchPhoneCodeField).clear();
        driver.findElement(searchPhoneCodeField).sendKeys(phoneNumber);
        return this;
    }
    /**
     * Selection of drop down list of codes of countries, mobile communications
     * * */
    public CarLoansPage selectPhoneCodeButton() {
        driver.findElement(phoneCodeButton).click();
        return this;
    }

    /**
     * Confirmation of application for credit
     * * */
    public CarLoansPage submitOrderButton() {
        driver.findElement(applyOrderButton).click();
        return this;
    }

    /**
     * Check that the selected tab is "With mileage"
     * * */
    public CarLoansPage checkSelectedTabWithMileageAuto() {
        waitElementIsVisible(driver.findElement(selectedUsedAutoTab));
        return this;
    }
    /**
     * Select country code from the drop-down list
     * * */
    public CarLoansPage selectCountryRussiaFromList() {
        driver.findElement(buttonCountryRussia).click();
        return this;
    }

}
