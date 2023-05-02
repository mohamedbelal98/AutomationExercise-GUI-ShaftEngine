package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ProductsPage {

    SHAFT.GUI.WebDriver driver;
    private final By saleImageLocator = By.id("sale_image");
    private final By allProductsList = By.className("product-image-wrapper");
    private final By viewProductsForFirstItem = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a");
    private final By searchInput = By.id("search_product");
    private final By searchButton = By.id("submit_search");
    private final By productNameList = By.xpath("//div[@class='productinfo text-center']/p");

    public ProductsPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void saleImageIsVisible() {

        driver.assertThat().element(saleImageLocator).isVisible().
                withCustomReportMessage("Verify user is navigated to ALL PRODUCTS page successfully").perform();
    }

    public void productsListIsVisible() {

        List<WebElement> listOfProducts = driver.getDriver().findElements(allProductsList);

        for (WebElement element : listOfProducts) {

            element.isDisplayed();
        }
    }

    public SingleProductPage clickOnViewProductsForFirstProduct() {

        driver.element().click(viewProductsForFirstItem);
        return new SingleProductPage(driver);
    }

    public void enterSearchInput(String searchWord) {

        driver.element().type(searchInput, searchWord);
    }

    public void clickSearchButton() {

        driver.element().click(searchButton);
    }

    public void verifyAllTheProductsRelatedToSearchAreVisible() {

        List<WebElement> listOfProducts = driver.getDriver().findElements(allProductsList);

        System.out.println(listOfProducts.size());//TODO delete this

        for (WebElement element : listOfProducts) {

            element.isDisplayed();
        }

        List<WebElement> list = driver.getDriver().findElements(productNameList);

        for (WebElement element : list) {

            if (!element.getText().contains("Top")) {

                Assert.fail(element.getText() + "Not contain Top word as Expected");
            }
        }

    }

}
