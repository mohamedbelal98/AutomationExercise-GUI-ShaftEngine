package pages.homePage;

import com.shaft.driver.SHAFT;
import pages.*;

public class HomePage {

    SHAFT.GUI.WebDriver driver;

    //Constructor
    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void verifyThatHomePageIsVisibleSuccessfully() {

        driver.assertThat().element(HomePageElements.logoLocator()).isVisible().
                withCustomReportMessage("Verify that home page is visible successfully").perform();
    }

    /**
     * Verify that 'Logged in as username' is visible
     *
     * @param name enter name for account to verify this name is correct or not.
     */
    public void verifyThatLoggedInAsIsVisible(String name) {

        driver.assertThat().element(HomePageElements.loggedInAsLocator()).isVisible().
                withCustomReportMessage(" Verify that 'Logged in as username' is visible").perform();

        driver.assertThat().element(HomePageElements.loggedInAsLocator()).text().isEqualTo(name).perform();
    }


    /**
     * click in signUpAndLogin button in the home page
     *
     * @return SignUpAndLogInPage
     */
    public SignUpAndLogInPage clickSignUpAndLoginButton() {

        driver.element().click(HomePageElements.signUpAndLoginLocator());
        return new SignUpAndLogInPage(driver);
    }


    /**
     * click in delete account button in the home page
     *
     * @return AccountPage
     */
    public AccountPage clickDeleteAccountButton() {

        driver.element().click(HomePageElements.deleteAccountButton());
        return new AccountPage(driver);
    }

    /**
     * click in logOut button in the home page
     *
     * @return SignUpAndLogInPage
     */
    public SignUpAndLogInPage clickLogoutButton() {

        driver.element().click(HomePageElements.logoutButton());
        return new SignUpAndLogInPage(driver);
    }

    /**
     * click in contactUs in the home page
     *
     * @return ContactUsPage
     */
    public ContactUsPage clickContactUsButton() {

        driver.element().click(HomePageElements.contactUsButton());
        return new ContactUsPage(driver);
    }

    /**
     * click in testCases button in the home page
     *
     * @return TestCasesPage
     */
    public TestCasesPage clickTestCasesButton() {

        driver.element().click(HomePageElements.testCasesButton());
        return new TestCasesPage(driver);
    }

    /**
     * click in product button in home page
     *
     * @return ProductsPage
     */
    public ProductsPage clickProductsButton() {

        driver.element().click(HomePageElements.productsButton());
        return new ProductsPage(driver);
    }

    /**
     * click in cart button
     *
     * @return CartPage
     */
    public CartPage clickCartButton() {

        driver.element().click(HomePageElements.cartButton());
        return new CartPage(driver);
    }

}
