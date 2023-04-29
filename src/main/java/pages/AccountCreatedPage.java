package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class AccountCreatedPage {

    SHAFT.GUI.WebDriver driver;

    private final By accountCreatedLocator = By.xpath("//b[contains(.,'Account Created')]");

    public AccountCreatedPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void VerifyThatACCOUNTCREATEDIsVisible() {

        driver.assertThat().element(accountCreatedLocator).isVisible().
                withCustomReportMessage("Verify that 'ACCOUNT CREATED!' is visible").perform();
    }

}