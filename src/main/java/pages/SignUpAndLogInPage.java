package pages;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;
import pages.homePage.HomePage;

public class SignUpAndLogInPage {

    SHAFT.GUI.WebDriver driver;

    //Locators
    private final By signUpAndLogInText = By.xpath("//div[@class='signup-form']//child::h2");
    private final By nameInput = By.xpath("//input[@name='name']");
    private final By signUpEmailInput = By.xpath("//input[@data-qa='signup-email']");
    private final By signUpButton = By.xpath("//button[@data-qa='signup-button']");
    private final By LoginToYourAccountText = By.xpath("//div[@class='login-form']/child::h2");
    private final By loginEmailAddressInput = By.xpath("//input[@data-qa='login-email']");
    private final By loginPasswordInput = By.xpath("//input[@data-qa='login-password']");
    private final By loginButton = By.xpath("//button[@data-qa='login-button']");
    private final By errorMessage = By.xpath("//p[@style='color: red;']");

    //Constructor
    public SignUpAndLogInPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Verify 'New User Signup!' is visible
    public void verifyNewUserSignupIsVisible() {

        driver.assertThat().element(signUpAndLogInText).isVisible().
                withCustomReportMessage("Verify 'New User Signup!' is visible").perform();

        Validations.assertThat().element(signUpAndLogInText).text().isEqualTo("New User Signup!").perform();
    }

    /**
     * @param name
     * @param email
     */
    public void newUserSignUp(String name, String email) {

        driver.element().type(nameInput, name);
        driver.element().type(signUpEmailInput, email);
    }

    /**
     * Click in signUp button
     *
     * @return AccountInformationPage
     */
    public AccountInformationPage clickSignUpButton() {

        driver.element().click(signUpButton);
        return new AccountInformationPage(driver);
    }

    //Verify 'Login to your account' is visible
    public void verifyLoginToYourAccountIsVisible() {

        driver.assertThat().element(LoginToYourAccountText).isVisible().
                withCustomReportMessage("Verify 'New User Signup!' is visible").perform();

        Validations.assertThat().element(LoginToYourAccountText).text().isEqualTo("Login to your account").perform();
    }

    /**
     * @param email    enter email to login.
     * @param password enter password to login.
     */
    public void loginToYourAccount(String email, String password) {

        driver.element().type(loginEmailAddressInput, email);
        driver.element().type(loginPasswordInput, password);
    }

    /**
     * click login Button
     *
     * @return HomePage
     */
    public HomePage clickLoginButton() {

        driver.element().click(loginButton);
        return new HomePage(driver);
    }

    //Verify error 'Your email or password is incorrect!' is visible
    public void verifyErrorYourEmailOrPasswordIsIncorrectIsVisible() {

        driver.assertThat().element(errorMessage).isVisible().
                withCustomReportMessage("Verify error 'Your email or password is incorrect!' is visible").perform();

        Validations.assertThat().element(errorMessage).text().isEqualTo("Your email or password is incorrect!").perform();
    }

    //Verify error 'Email Address already exist!' is visible
    public void verifyErrorEmailAddressAlreadyExistIsVisible() {

        driver.assertThat().element(errorMessage).isVisible().
                withCustomReportMessage("Verify error 'Your email or password is incorrect!' is visible").perform();

        Validations.assertThat().element(errorMessage).text().isEqualTo("Email Address already exist!").perform();
    }

}
