package testCases.testCart;

import base.BaseTest;
import com.shaft.tools.io.JSONFileManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ProductsPage;

public class TestSearch extends BaseTest {

    JSONFileManager jsonFileManager;

    @BeforeClass
    public void beforeClass() {

        jsonFileManager = new JSONFileManager("src/test/resources/testDataFiles/search.json");
    }

    @Test
    public void SearchProduct() throws InterruptedException {

        homePage.getHomePageVerification().verifyThatHomePageIsVisibleSuccessfully();

        ProductsPage productsPage = homePage.getHomePageHeader().clickProductsButton();

        productsPage.saleImageIsVisible();

        productsPage.productsListIsVisible();

        productsPage.enterSearchInput(jsonFileManager.getTestData("searchWord"));

        productsPage.clickSearchButton();

        Thread.sleep(4000);

        //Verify the result of search is related to search word.
        productsPage.verifyAllTheProductsRelatedToSearchAreVisible(jsonFileManager.getTestData("searchWord"));
    }

}
