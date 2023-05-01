package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SingleProductPage {

    SHAFT.GUI.WebDriver driver;

    private final By productNameLocator = By.xpath("//div[@class='product-information']/child::h2");
    private final By categoryLocator = By.xpath("//div[@class='product-information']/child::p[1]");
    private final By priceLocator = By.xpath("//div[@class='product-information']/span/span");
    private final By availabilityLocator = By.xpath("//div[@class='product-information']/child::p[2]");
    private final By conditionLocator = By.xpath("//div[@class='product-information']/child::p[3]");
    private final By brandLocator = By.xpath("//div[@class='product-information']/child::p[4]");

    public SingleProductPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

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

}
