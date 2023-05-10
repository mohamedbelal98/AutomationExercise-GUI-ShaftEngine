package pages.homePageUtli;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class HomePageVerification {

    SHAFT.GUI.WebDriver driver;

    //Locators
    private final By logoLocator = By.xpath("//img[@alt='Website for automation practice']");
    private final By loggedInAsLocator = By.xpath("//a[contains( . , ' Logged in as ')]");

    public HomePageVerification(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Verify that home page is visible successfully
    public void verifyThatHomePageIsVisibleSuccessfully() {

        driver.assertThat().element(logoLocator).isVisible().
                withCustomReportMessage("Verify that home page is visible successfully").perform();
    }

    /**
     * Verify that 'Logged in as username' is visible
     *
     * @param name
     */
    public void verifyThatLoggedInAsIsVisible(String name) {

        driver.assertThat().element(loggedInAsLocator).isVisible().
                withCustomReportMessage(" Verify that 'Logged in as username' is visible").perform();

        driver.assertThat().element(loggedInAsLocator).text().isEqualTo(name).perform();
    }

}
