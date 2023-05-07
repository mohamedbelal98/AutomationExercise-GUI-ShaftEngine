package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class AccountPage {

    SHAFT.GUI.WebDriver driver;

    //Locator
    private final By accountCreatedLocator = By.xpath("//b[contains( . , 'Account Created!')]");
    private final By continueButton = By.linkText("Continue");
    private final By accountDeletedLocator = By.xpath("//b[contains(.,'Account Deleted!')]");
    private final By orderPlacedLocator = By.xpath("//b[contains( . , 'Order Placed!')]");

    //Constructor
    public AccountPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Verify that 'ACCOUNT CREATED!' is visible
    public void verifyThatAccountCreatedIsVisible() {

        driver.assertThat().element(accountCreatedLocator).isVisible().
                withCustomReportMessage("Verify that 'ACCOUNT CREATED!' is visible").perform();
    }

    /**
     * Click 'Continue' button
     *
     * @return HomePage
     */
    public HomePage clickContinueButton() {

        driver.element().click(continueButton);
        return new HomePage(driver);
    }

    //Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
    public void verifyThatAccountDeletedIsVisible() {

        driver.assertThat().element(accountDeletedLocator).isVisible().
                withCustomReportMessage("Verify that 'Logged in as username' is visible").perform();
    }

    public void verifyThatOrderPlacedIsVisible() {

        driver.assertThat().element(orderPlacedLocator).isVisible().
                withCustomReportMessage("Verify that 'Logged in as username' is visible").perform();
    }

}