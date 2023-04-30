package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class AccountPage {

    SHAFT.GUI.WebDriver driver;

    private final By accountCreatedLocator = By.xpath("//h2[@data-qa='account-created']");
    private final By continueButton = By.linkText("Continue");
    private final By accountDeletedLocator = By.xpath("//b[contains(.,'Account Deleted!')]");

    public AccountPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void VerifyThatACCOUNTCREATEDIsVisible() {

        driver.assertThat().element(accountCreatedLocator).isVisible().
                withCustomReportMessage("Verify that 'ACCOUNT CREATED!' is visible").perform();
    }

    public HomePage clickContinueButton() {

        driver.element().click(continueButton);
        return new HomePage(driver);
    }

    public void verifyThatACCOUNTDELETEDIsVisible() {

        driver.assertThat().element(accountDeletedLocator).isVisible().
                withCustomReportMessage("Verify that 'Logged in as username' is visible").perform();
    }

}