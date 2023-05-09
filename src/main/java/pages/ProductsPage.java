package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ProductsPage {

    SHAFT.GUI.WebDriver driver;

    //Locators
    private final By saleImageLocator = By.id("sale_image");
    private final By allProductsList = By.className("product-image-wrapper");
    private final By viewProductsForFirstItem = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a");
    private final By searchInput = By.id("search_product");
    private final By searchButton = By.id("submit_search");
    private final By productNameList = By.xpath("//div[@class='productinfo text-center']/p");
    private final By firstItemPriceText = By.xpath("//div[@class='features_items']/div[2]/div/div/div/h2");
    private final By secondItemPriceText = By.xpath("//div[@class='features_items']/div[3]/div/div/div/h2");

    //Constructor
    public ProductsPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    /*
     * Verify all list of search product are loaded successfully in products page
     * Verify all product are related to search(Contain search word in product name)
     */
    public void verifyAllTheProductsRelatedToSearchAreVisible(String relatedSearchWord) {

        List<WebElement> listOfProducts = driver.getDriver().findElements(allProductsList);

        System.out.println(listOfProducts.size()); //TODO delete this

        for (WebElement element : listOfProducts) {

            element.isDisplayed();
        }

        List<WebElement> list = driver.getDriver().findElements(productNameList);

        for (WebElement element : list) {

            if (!element.getText().contains(relatedSearchWord)) {

                Assert.fail(element.getText() + "The result Not contain Search word (TOP) as Expected");
            }
        }

    }

    //Verify all products is visible and loaded
    public void productsListIsVisible() {

        List<WebElement> listOfProducts = driver.getDriver().findElements(allProductsList);

        for (WebElement element : listOfProducts) {

            element.isDisplayed();
        }
    }

    //Verify product page is loaded successfully
    public void saleImageIsVisible() {

        driver.assertThat().element(saleImageLocator).isVisible().
                withCustomReportMessage("Verify user is navigated to ALL PRODUCTS page successfully").perform();
    }

    /**
     * click in view product in first product item in product page
     *
     * @return SingleProductPage
     */
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

    /**
     * get first item price text
     *
     * @return firstItemPriceText
     */
    public String verifyFirstItemPrice() {

        return driver.element().getText(firstItemPriceText);
    }

    /**
     * get second item price text
     *
     * @return secondItemPriceText
     */
    public String verifySecondItemPrice() {

        return driver.element().getText(secondItemPriceText);
    }

}
