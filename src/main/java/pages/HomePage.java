package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class HomePage {

    SHAFT.GUI.WebDriver driver;

    private final By logoLocator = By.xpath("//img[@alt='Website for automation practice']");
    private final By signUpAndLoginLocator = By.xpath("//a[contains(. , ' Signup / Login')]");

    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    public void VerifyThatHomePageIsVisibleSuccessfully() {

        driver.assertThat().element(logoLocator).isVisible().
                withCustomReportMessage("Verify that home page is visible successfully").perform();
    }

    public SignUpAndLogInPage clickSignUpAndLoginButton() {

        driver.element().click(signUpAndLoginLocator);
        return new SignUpAndLogInPage(driver);
    }

}