package pages.telecomunications;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;


public class MobilePhoneReplenishmentPage extends BasePage {
    public MobilePhoneReplenishmentPage(WebDriver driver) {
        super(driver);
    }
    private final By buttonWallet = By.xpath("//div[contains(text(), 'My wallet')]");
    private final By inputPhoneNumber = By.xpath("//input[@data-qa-node='phone-number']");
    private final By inputAmount = By.xpath("//input[@data-qa-node='amount']");
    private final By inputCardFrom = By.xpath("//input[@data-qa-node='numberdebitSource']");
    private final By inputCardExpDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
    private final By inputCardCvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
    private final By buttonSubmitToTheCard = By.xpath("//button[@data-qa-node='submit']");
    private final By paymentDetail = By.xpath("//div[@data-qa-node='details']");
    private final By inputFirstName = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
    private final By inputLastName = By.xpath("//input[@data-qa-node='lastNamedebitSource']");



    /**
 * Choose a card from the wallet
 * */
    public MobilePhoneReplenishmentPage selectCardFromWallet() {
        driver.findElement(buttonWallet).click();
        return this;
    }
    /**
     * Enter phone number excluding country code
     * @param number phone number
     * */
    public MobilePhoneReplenishmentPage enterPhoneNumber(String number) {
        driver.findElement(inputPhoneNumber).sendKeys(number);
        return this;
    }
    /**
     * Clear amount field
     * */
    public MobilePhoneReplenishmentPage clearAmount() {
        driver.findElement(inputAmount).sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.DELETE));
        return this;
    }
    /**
     * Enter minimal amount
     * */
    public MobilePhoneReplenishmentPage enterAmount(String amount) {
        driver.findElement(inputAmount).sendKeys(amount);
        return this;
    }
    /**
     * Enter card number
     * @param cardNumber
     * */
    public MobilePhoneReplenishmentPage enterCardFrom(String cardNumber) {
        driver.findElement(inputCardFrom).sendKeys(cardNumber);
        return this;
    }
    /**
     * Enter expired date of the card
     * @param expDate expired date in format MM/yy
     * */
    public MobilePhoneReplenishmentPage enterCardExpDate(String expDate) {
        driver.findElement(inputCardExpDate).sendKeys(expDate);
        return this;
    }
    /**
     * Enter CVV-code of the card
     * @param cvv cvv-code
     * */
    public MobilePhoneReplenishmentPage enterCardCvv(String cvv) {
        driver.findElement(inputCardCvv).sendKeys(cvv);
        return this;
    }

    /**
     * Enter first name of the cardholder
     * @param firstName name of CardHolder
     * */
    public MobilePhoneReplenishmentPage enterFirstName(String firstName) {
        waitElementIsVisible(driver.findElement(inputFirstName));
        driver.findElement(inputFirstName).sendKeys(firstName);
        return this;
    }
    /**
     * Enter last name of the cardholder
     * @param lastName name of CardHolder
     * */
    public MobilePhoneReplenishmentPage enterLastName(String lastName) {
        driver.findElement(inputLastName).sendKeys(lastName);
        return this;
    }

    /**
     * Click on button "Add to cart"
     * */
    public MobilePhoneReplenishmentPage submitToTheCart() {
        waitElementIsVisible(driver.findElement(buttonSubmitToTheCard));
        driver.findElement(buttonSubmitToTheCard).click();
        return this;
    }
    /**
     * Check is the payment details is present or not
     * @param text
     * */
    public MobilePhoneReplenishmentPage checkPaymentDetailsIsPresentInTheCart(String text) {
        waitElementIsVisible(driver.findElement(paymentDetail));
        WebElement details = driver.findElement(paymentDetail);
        Assertions.assertEquals(text, details.getText());
        return this;
    }
}
