package pages;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;

public class HomePage {

    SHAFT.GUI.WebDriver driver;

    //Locators
    private final By logoLocator = By.xpath("//img[@alt='Website for automation practice']");
    private final By signUpAndLoginLocator = By.xpath("//a[contains(. , ' Signup / Login')]");
    private final By loggedInAsLocator = By.xpath("//a[contains( . , ' Logged in as ')]");
    private final By deleteAccountButton = By.xpath("//a[contains( . , ' Delete Account')]");
    private final By logoutButton = By.xpath("//a[contains( . , ' Logout')]");
    private final By contactUsButton = By.xpath("//a[contains( . , ' Contact us')]");
    private final By testCasesButton = By.xpath("//a[contains( . , ' Test Cases')]");
    private final By productsButton = By.xpath("//a[contains( . , ' Products')]");
    private final By cartButton = By.xpath("//ul[@class='nav navbar-nav']/li[3]");

    //Constructor
    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Verify that home page is visible successfully
    public void verifyThatHomePageIsVisibleSuccessfully() {

        driver.assertThat().element(logoLocator).isVisible().
                withCustomReportMessage("Verify that home page is visible successfully").perform();
    }

    /**
     * click in signUpAndLogin button in the home page
     *
     * @return SignUpAndLogInPage
     */
    public SignUpAndLogInPage clickSignUpAndLoginButton() {

        driver.element().click(signUpAndLoginLocator);
        return new SignUpAndLogInPage(driver);
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

    /**
     * click in delete account button in the home page
     *
     * @return AccountPage
     */
    public AccountPage clickDeleteAccountButton() {

        driver.element().click(deleteAccountButton);
        return new AccountPage(driver);
    }

    /**
     * click in logOut button in the home page
     *
     * @return SignUpAndLogInPage
     */
    public SignUpAndLogInPage clickLogoutButton() {

        driver.element().click(logoutButton);
        return new SignUpAndLogInPage(driver);
    }

    /**
     * click in contactUs in the home page
     *
     * @return ContactUsPage
     */
    public ContactUsPage clickContactUsButton() {

        driver.element().click(contactUsButton);
        return new ContactUsPage(driver);
    }

    /**
     * click in testCases button in the home page
     *
     * @return TestCasesPage
     */
    public TestCasesPage clickTestCasesButton() {

        driver.element().click(testCasesButton);
        return new TestCasesPage(driver);
    }

    /**
     * click in product button in home page
     *
     * @return ProductsPage
     */
    public ProductsPage clickProductsButton() {

        driver.element().click(productsButton);
        return new ProductsPage(driver);
    }

    /**
     * click in cart button
     *
     * @return CartPage
     */
    public CartPage clickCartButton() {

        driver.element().click(cartButton);
        return new CartPage(driver);
    }

}