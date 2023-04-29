package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SignUpAndLogInPage {

    SHAFT.GUI.WebDriver driver;

    private final By signUpAndLogInText = By.xpath("//div[@class='signup-form']//child::h2");
    private final By nameInput = By.xpath("//input[@name='name']");
    private final By signUpEmailInput = By.xpath("//input[@data-qa='signup-email']");
    private final By signUpButton = By.xpath("//button[@data-qa='signup-button']");
    private final By LoginToYourAccountText = By.xpath("//div[@class='login-form']/child::h2");
    private final By loginEmailAddressInput = By.xpath("//input[@data-qa='login-email']");
    private final By loginPasswordInput = By.xpath("//input[@data-qa='login-password']");
    private final By loginButton = By.xpath("//button[@data-qa='login-button']");
    private final By errorMessageForLogin = By.xpath("//p[@style='color: red;']");

    public SignUpAndLogInPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void verifySignUpAndLogInTextIsVisible() {

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

    public void verifyLoginToYourAccountIsVisible() {

        driver.assertThat().element(LoginToYourAccountText).isVisible().
                withCustomReportMessage("Verify 'New User Signup!' is visible").perform();
    }

    public void loginToYourAccount(String email, String password) {

        driver.element().type(loginEmailAddressInput, email);
        driver.element().type(loginPasswordInput, password);
    }

    public HomePage clickLoginButton() {

        driver.element().click(loginButton);
        return new HomePage(driver);
    }

    public void verifyErrorYourEmailOrPasswordIsIncorrectIsVisible(){

        driver.assertThat().element(errorMessageForLogin).isVisible().
                withCustomReportMessage("Verify error 'Your email or password is incorrect!' is visible").perform();
    }

}
