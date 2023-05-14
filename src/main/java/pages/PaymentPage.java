package pages;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;

public class PaymentPage {

    SHAFT.GUI.WebDriver driver;

    //Locators
    private final By paymentText = By.xpath("//div[@class='step-one']/h2");
    private final By nameOfCardInput = By.name("name_on_card");
    private final By cardNumberInput = By.name("card_number");
    private final By cvcInput = By.name("cvc");
    private final By expirationMonthInput = By.name("expiry_month");
    private final By expirationYearInput = By.name("expiry_year");
    private final By payAndConfirmOrder = By.xpath("//button[@data-qa='pay-button']");

    //Constructor
    public PaymentPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void verifyPaymentTextIsVisible() {

        driver.assertThat().element(paymentText).isVisible().
                withCustomReportMessage("Verify Payment Text in payment page is visible").perform();

        Validations.assertThat().element(paymentText).text().isEqualTo("Payment").perform();
    }

    /**
     * @param nameOfCard      enter card name.
     * @param cardNumber      enter card number like visa.
     * @param cvc             enter cvc number.
     * @param expirationMonth enter date for expiration month.
     * @param expirationYear  enter date for expiration year.
     */
    public void fillPaymentDetails(String nameOfCard, String cardNumber, String cvc, String expirationMonth, String expirationYear) {

        driver.element().type(nameOfCardInput, nameOfCard);
        driver.element().type(cardNumberInput, cardNumber);
        driver.element().type(cvcInput, cvc);
        driver.element().type(expirationMonthInput, expirationMonth);
        driver.element().type(expirationYearInput, expirationYear);
    }

    /**
     * click payAndConfirmOrder button
     *
     * @return AccountPage
     */
    public AccountPage clickPayAndConfirmOrder() {

        driver.element().click(payAndConfirmOrder);
        return new AccountPage(driver);
    }


}
