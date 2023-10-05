package tests.telecomunications.positive;

import org.junit.jupiter.api.Test;
import tests.base.BaseTest;
import static constants.Constant.MobileReplenishmentTestData.*;
import static constants.Constant.Urls.MOBILE_PAYMENT_URL;


public class MobilePhoneReplenishmentPositiveTest extends BaseTest {
    @Test
    public void checkIsRedirectToAuth(){
        basePage.goToUrl(MOBILE_PAYMENT_URL);
        mobilePhoneReplenishmentPage.selectCardFromWallet();
        basePage.isAuthWidgetPresent();
    }
    @Test
    public void checkMinimumReplenishmentAmount() throws InterruptedException {
        basePage.goToUrl(MOBILE_PAYMENT_URL);
        mobilePhoneReplenishmentPage
                .enterPhoneNumber(MOBILE_PAYMENT_PHONE_NUMBER)
                .clearAmount()
                .enterAmount("1")
                .enterCardFrom(MOBILE_PAYMENT_CARD)
                .enterCardExpDate(MOBILE_PAYMENT_CARD_EXP_DATE)
                .enterCardCvv(MOBILE_PAYMENT_CARD_CVV)
                .enterFirstName(MOBILE_PAYMENT_FIRST_NAME)
                .enterLastName(MOBILE_PAYMENT_LAST_NAME)
                .submitToTheCart()
                .checkPaymentDetailsIsPresentInTheCart("Mobile payment. Phone number +380686979712");
    }
}
