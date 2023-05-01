package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

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

}