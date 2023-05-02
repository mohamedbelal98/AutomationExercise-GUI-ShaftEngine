package pages;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;
import pages.*;

public class HomePage {

    SHAFT.GUI.WebDriver driver;

    private final By logoLocator = By.xpath("//img[@alt='Website for automation practice']");
    private final By signUpAndLoginLocator = By.xpath("//a[contains(. , ' Signup / Login')]");
    private final By loggedInAsLocator = By.xpath("//a[contains( . , ' Logged in as ')]");
    private final By deleteAccountButton = By.xpath("//a[contains( . , ' Delete Account')]");
    private final By logoutButton = By.xpath("//a[contains( . , ' Logout')]");
    private final By contactUsButton = By.xpath("//a[contains( . , ' Contact us')]");
    private final By testCasesButton = By.xpath("//a[contains( . , ' Test Cases')]");
    private final By productsButton = By.xpath("//a[contains( . , ' Products')]");
    private final By cartButton = By.xpath("//ul[@class='nav navbar-nav']/li[3]");
    private final By footerLocator = By.id("footer");
    private final By emailInput = By.id("susbscribe_email");
    private final By subscribeButton = By.id("subscribe");
    private final By subscribeMessageSuccessLocator = By.xpath("//div[@class='alert-success alert']");
    private final By subscribeTextLocator = By.xpath("//div[@class='single-widget']/h2");

    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    public void verifyThatHomePageIsVisibleSuccessfully() {

        driver.assertThat().element(logoLocator).isVisible().
                withCustomReportMessage("Verify that home page is visible successfully").perform();
    }

    public SignUpAndLogInPage clickSignUpAndLoginButton() {

        driver.element().click(signUpAndLoginLocator);
        return new SignUpAndLogInPage(driver);
    }

    public void verifyThatLoggedInAsIsVisible() {

        driver.assertThat().element(loggedInAsLocator).isVisible().
                withCustomReportMessage(" Verify that 'Logged in as username' is visible").perform();
    }

    public AccountPage clickDeleteAccountButton() {

        driver.element().click(deleteAccountButton);
        return new AccountPage(driver);
    }

    public SignUpAndLogInPage clickLogoutButton() {

        driver.element().click(logoutButton);
        return new SignUpAndLogInPage(driver);
    }

    public ContactUsPage clickContactUsButton() {

        driver.element().click(contactUsButton);
        return new ContactUsPage(driver);
    }

    public TestCasesPage clickTestCasesButton() {

        driver.element().click(testCasesButton);
        return new TestCasesPage(driver);
    }

    public ProductsPage clickProductsButton() {

        driver.element().click(productsButton);
        return new ProductsPage(driver);
    }

    public void scrollToFooter() {

        driver.element().scrollToElement(footerLocator);
    }

    public void fillEmailAddressInput(String email) {

        driver.element().type(emailInput, email);
        driver.element().click(subscribeButton);
    }

    public void VerifySuccessMessageForSubscribeIsVisible() {

        driver.assertThat().element(subscribeMessageSuccessLocator).isVisible().
                withCustomReportMessage(" Verify success message 'You have been successfully subscribed!' is visible").perform();

        Validations.assertThat().element(subscribeMessageSuccessLocator).text().isEqualTo("You have been successfully subscribed!").perform();
    }

    public void verifySubscribeText() {

        driver.assertThat().element(subscribeTextLocator).isVisible().
                withCustomReportMessage("Verify text 'SUBSCRIPTION'").perform();

        Validations.assertThat().element(subscribeTextLocator).text().isEqualTo("SUBSCRIPTION").perform();
    }

    public CartPage clickCartButton() {

        driver.element().click(cartButton);
        return new CartPage(driver);
    }

}