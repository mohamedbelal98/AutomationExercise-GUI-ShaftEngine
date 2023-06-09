package pages;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;
import pages.homePage.HomePage;

public class ContactUsPage {

    SHAFT.GUI.WebDriver driver;

    //Locators
    private final By getInTouchTextLocator = By.xpath("//h2[contains( . , 'Get In Touch')]");
    private final By nameInput = By.name("name");
    private final By emailInput = By.name("email");
    private final By subjectInput = By.name("subject");
    private final By messageInput = By.name("message");
    private final By uploadFileInput = By.name("upload_file");
    private final By submitButton = By.xpath("//input[@data-qa='submit-button']");
    private final By successMessage = By.xpath("//div[@class='status alert alert-success']");
    private final By homeButton = By.xpath("//*[@class='btn btn-success']");

    //Constructor
    public ContactUsPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    public void verifyGetInTouchIsVisible() {

        driver.assertThat().element(getInTouchTextLocator).isVisible().
                withCustomReportMessage(" Verify 'GET IN TOUCH' is visible").perform();

        Validations.assertThat().element(getInTouchTextLocator).text().isEqualTo("GET IN TOUCH").perform();
    }

    /**
     * @param name     enter name.
     * @param email    enter email.
     * @param subject  enter subject.
     * @param message  enter message.
     * @param filePath put path for file to upload.
     */
    public void fillNameEmailSubjectAndMessage(String name, String email, String subject, String message, String filePath) {

        driver.element().type(nameInput, name);
        driver.element().type(emailInput, email);
        driver.element().type(subjectInput, subject);
        driver.element().type(messageInput, message);
        driver.element().typeFileLocationForUpload(uploadFileInput, filePath);
    }

    public void clickSubmitButton() {

        driver.element().click(submitButton);
    }

    public void acceptAlert() {

        driver.alert().acceptAlert();
    }

    // Verify success message 'Success! Your details have been submitted successfully.' is visible
    public void VerifySuccessMessageSuccessYourDetailsHaveBeenSubmittedSuccessfullyIsVisible() {

        driver.assertThat().element(successMessage).isVisible().
                withCustomReportMessage("Verify success message 'Success! Your details have been submitted successfully.' is visible").perform();

        Validations.assertThat().element(successMessage).text().isEqualTo("Success! Your details have been submitted successfully.").perform();
    }

    /**
     * click in home page button
     *
     * @return HomePage
     */
    public HomePage clickHomeButton() {

        driver.element().click(homeButton);
        return new HomePage(driver);
    }

}
