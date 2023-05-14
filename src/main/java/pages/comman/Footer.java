package pages.comman;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;

public class Footer {

    SHAFT.GUI.WebDriver driver;

    //locators
    private final By footerLocator = By.id("footer");
    private final By subscribeTextLocator = By.xpath("//div[@class='single-widget']/h2");
    private final By emailInput = By.id("susbscribe_email");
    private final By subscribeButton = By.id("subscribe");
    private final By subscribeMessageSuccessLocator = By.xpath("//div[@class='alert-success alert']");

    //Constructor
    public Footer(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Scroll down to footer of the page.
    public void scrollToFooter() {

        driver.element().scrollToElement(footerLocator);
    }

    //Verify text SUBSCRIPTION is visible.
    public void verifySubscribeText() {

        driver.assertThat().element(subscribeTextLocator).isVisible().
                withCustomReportMessage("Verify text 'SUBSCRIPTION'").perform();

        Validations.assertThat().element(subscribeTextLocator).text().isEqualTo("SUBSCRIPTION").perform();
    }

    /**
     * @param email click Subscribe Button
     */
    public void fillEmailAddressInput(String email) {

        driver.element().type(emailInput, email);
        driver.element().click(subscribeButton);
    }

    //Verify success message 'You have been successfully subscribed!' is visible
    public void verifySuccessMessageForSubscribeIsVisible() {

        driver.assertThat().element(subscribeMessageSuccessLocator).isVisible().
                withCustomReportMessage(" Verify success message 'You have been successfully subscribed!' is visible").perform();

        Validations.assertThat().element(subscribeMessageSuccessLocator).text().isEqualTo("You have been successfully subscribed!").perform();
    }

}
