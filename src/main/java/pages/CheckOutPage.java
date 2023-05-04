package pages;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;

public class CheckOutPage {

    SHAFT.GUI.WebDriver driver;

    //Locators
    private final By addressDetailsLocator = By.xpath("//div[@class='container']/div[2]/h2");
    private final By reviewYourOrderLocator = By.xpath("//div[@class='container']/div[4]/h2");
    private final By descriptionLocator = By.className("form-control");
    private final By placeOrderButton = By.xpath("//a[contains( . , 'Place Order')]");

    public CheckOutPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void verifyAddressDetailsAndReviewYourOrder() {

        driver.assertThat().element(addressDetailsLocator).isVisible().
                withCustomReportMessage("Verify Address Details").perform();

        Validations.assertThat().element(addressDetailsLocator).text().isEqualTo("Address Details").perform();

        driver.assertThat().element(reviewYourOrderLocator).isVisible().
                withCustomReportMessage("Verify Review Your Order").perform();

        Validations.assertThat().element(reviewYourOrderLocator).text().isEqualTo("Review Your Order").perform();
    }

    public void fillDescription(String description) {

        driver.element().type(descriptionLocator, description);
    }

    public void clickPlaceOrderButton() {

        driver.element().click(placeOrderButton);
    }

}
