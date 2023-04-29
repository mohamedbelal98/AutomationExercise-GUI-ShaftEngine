package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SignUpAndLogInPage {

    SHAFT.GUI.WebDriver driver;

    private final By signUpAndLogInText = By.xpath("//div[@class='signup-form']//child::h2");
    private final By nameInput = By.xpath("//input[@name='name']");
    private final By signUpEmailInput = By.xpath("//input[@data-qa='signup-email']");
    private final By signUpButton = By.xpath("//button[@data-qa='signup-button']");

    public SignUpAndLogInPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void VerifySignUpAndLogInTextIsVisible() {

        driver.assertThat().element(signUpAndLogInText).isVisible().
                withCustomReportMessage("Verify 'New User Signup!' is visible").perform();
    }

    public void newUserSignUp(String name, String email) {

        driver.element().type(nameInput, name);
        driver.element().type(signUpEmailInput, email);
    }

    public AccountInformationPage clickSignUpButton() {

        driver.element().click(signUpButton);
        return new AccountInformationPage(driver);
    }

}
