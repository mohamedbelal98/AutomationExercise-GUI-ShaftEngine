package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SingleProductPage {

    SHAFT.GUI.WebDriver driver;

    //Locators
    private final By productNameLocator = By.xpath("//div[@class='product-information']/child::h2");
    private final By categoryLocator = By.xpath("//div[@class='product-information']/child::p[1]");
    private final By priceLocator = By.xpath("//div[@class='product-information']/span/span");
    private final By availabilityLocator = By.xpath("//div[@class='product-information']/child::p[2]");
    private final By conditionLocator = By.xpath("//div[@class='product-information']/child::p[3]");
    private final By brandLocator = By.xpath("//div[@class='product-information']/child::p[4]");
    private final By writeYourReviewText = By.xpath("//div[@class='col-sm-12']/ul/li[1]");
    private final By nameInput = By.id("name");
    private final By emailInput = By.id("email");
    private final By reviewInput = By.id("review");
    private final By submitButton = By.id("button-review");
    private final By successReviewMessage = By.xpath("//div[@class='alert-success alert']/span");

    //Constructor
    public SingleProductPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    /*
     * Verify that product detail is visible: product name, category, price, availability, condition, brand
     */
    public void verifyProductDetailsIsVisible() {

        driver.assertThat().element(productNameLocator).isVisible().
                withCustomReportMessage("Verify that detail detail is visible: product name").perform();

        driver.assertThat().element(categoryLocator).isVisible().
                withCustomReportMessage("Verify that detail detail is visible: category").perform();

        driver.assertThat().element(priceLocator).isVisible().
                withCustomReportMessage("Verify that detail detail is visible: price").perform();

        driver.assertThat().element(availabilityLocator).isVisible().
                withCustomReportMessage("Verify that detail detail is visible: availability").perform();

        driver.assertThat().element(conditionLocator).isVisible().
                withCustomReportMessage("Verify that detail detail is visible: condition").perform();

        driver.assertThat().element(brandLocator).isVisible().
                withCustomReportMessage("Verify that detail detail is visible: Brand").perform();
    }

    public void VerifyWriteYourReviewIsVisible() {

        driver.assertThat().element(writeYourReviewText).isVisible().
                withCustomReportMessage("Verify 'Write Your Review' is visible").perform();

        driver.assertThat().element(writeYourReviewText).text().isEqualTo("WRITE YOUR REVIEW").perform();
    }

    /**
     * Fill data in review section.
     *
     * @param name   enter name.
     * @param email  enter email address with right format.
     * @param review enter review.
     */
    public void fillReviewInput(String name, String email, String review) {

        driver.element().type(nameInput, name);
        driver.element().type(emailInput, email);
        driver.element().type(reviewInput, review);
    }


    public void clickSubmitButton() {

        driver.element().click(submitButton);
    }

    public void verifySuccessReviewMessageIsAppear() {

        driver.assertThat().element(successReviewMessage).isVisible().
                withCustomReportMessage("Verify success message 'Thank you for your review.").perform();

        driver.assertThat().element(successReviewMessage).text().isEqualTo("Thank you for your review.").perform();
    }

}
