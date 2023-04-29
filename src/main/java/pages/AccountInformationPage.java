package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class AccountInformationPage {

    SHAFT.GUI.WebDriver driver;

    private final By pageTitle = By.xpath("(//h2[@class='title text-center']/child::b)[1]");
    private final By mrTitleInput = By.xpath("//input[@id='id_gender1']");
    private final By passwordInput = By.xpath("//input[@data-qa='password']");
    private final By selectDay = By.id("days");
    private final By selectMonth = By.id("months");
    private final By selectYear = By.id("years");
    private final By newsletterLocator = By.xpath("//input[@id='newsletter']");
    private final By specialOffersLocator = By.xpath("//input[@id='optin']");
    private final By firstNameInput = By.id("first_name");
    private final By lastNameInput = By.id("last_name");
    private final By companyInput = By.id("company");
    private final By address1Input = By.id("address1");
    private final By address2Input = By.id("address2");
    private final By countryInput = By.id("country");
    private final By stateInput = By.id("state");
    private final By cityInput = By.id("city");
    private final By zipcodeInput = By.id("zipcode");
    private final By mobileNumberInput = By.id("mobile_number");
    private final By createAccountButton = By.xpath("//button[@data-qa='create-account']");

    public AccountInformationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void VerifyThatENTERACCOUNTINFORMATIONIsVisible() {

        driver.assertThat().element(pageTitle).isVisible().
                withCustomReportMessage("Verify that 'ENTER ACCOUNT INFORMATION' is visible").perform();
    }

    public void fillAccountInformation(String password, String day, String month, String year) {

        driver.element().click(mrTitleInput);
        driver.element().type(passwordInput, password);
        driver.element().select(selectDay, day);
        driver.element().select(selectMonth, month);
        driver.element().select(selectYear, year);
        driver.element().click(newsletterLocator);
        driver.element().click(specialOffersLocator);
    }

    public void fillAddressInformation(String firstName, String lastName, String company, String address1, String address2, String country,
                                       String state, String city, String zipcode, String mobileNumber) {

        driver.element().type(firstNameInput, firstName);
        driver.element().type(lastNameInput, lastName);
        driver.element().type(companyInput, company);
        driver.element().type(address1Input, address1);
        driver.element().type(address2Input, address2);
        driver.element().select(countryInput, country);
        driver.element().type(stateInput, state);
        driver.element().type(cityInput, city);
        driver.element().type(zipcodeInput, zipcode);
        driver.element().type(mobileNumberInput, mobileNumber);
    }

    public AccountCreatedPage clickCreateAccountButton() {

        driver.element().click(createAccountButton);
        return new AccountCreatedPage(driver);
    }


}