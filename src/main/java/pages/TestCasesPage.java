package pages;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;

public class TestCasesPage {

    SHAFT.GUI.WebDriver driver;

    //Locator
    private final By testCasesText = By.xpath("//span[@style='color: red;']");

    //Constructor
    public TestCasesPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Verify user is navigated to test cases page successfully
    public void VerifyUserIsNavigatedToTestCasesPageSuccessfully() {

        driver.assertThat().element(testCasesText).isVisible().
                withCustomReportMessage("Verify user is navigated to test cases page successfully").perform();

        Validations.assertThat().element(testCasesText).text().isEqualTo("Below is the list of test Cases for you to practice the Automation. Click on the scenario for detailed Test Steps:").perform();
    }

}
