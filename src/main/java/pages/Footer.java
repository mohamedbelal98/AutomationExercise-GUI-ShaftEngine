package pages;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;

public class Footer {

    SHAFT.GUI.WebDriver driver;

    private final By footerLocator = By.id("footer");
    private final By subscribeTextLocator = By.xpath("//div[@class='single-widget']/h2");
    private final By emailInput = By.id("susbscribe_email");
    private final By subscribeButton = By.id("subscribe");
    private final By subscribeMessageSuccessLocator = By.xpath("//div[@class='alert-success alert']");

    public Footer(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToFooter() {

        driver.element().scrollToElement(footerLocator);
    }

    public void verifySubscribeText() {

        driver.assertThat().element(subscribeTextLocator).isVisible().
                withCustomReportMessage("Verify text 'SUBSCRIPTION'").perform();

        Validations.assertThat().element(subscribeTextLocator).text().isEqualTo("SUBSCRIPTION").perform();
    }

    public void fillEmailAddressInput(String email) {

        driver.element().type(emailInput, email);
        driver.element().click(subscribeButton);
    }

    public void verifySuccessMessageForSubscribeIsVisible() {

        driver.assertThat().element(subscribeMessageSuccessLocator).isVisible().
                withCustomReportMessage(" Verify success message 'You have been successfully subscribed!' is visible").perform();

        Validations.assertThat().element(subscribeMessageSuccessLocator).text().isEqualTo("You have been successfully subscribed!").perform();
    }

}
