package testCases.testUtilities;

import base.BaseTest;
import com.shaft.tools.io.JSONFileManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ProductsPage;
import pages.SingleProductPage;

public class TestReview extends BaseTest {

    JSONFileManager jsonFileManager;

    @BeforeClass
    public void beforeClass() {

        jsonFileManager = new JSONFileManager("src/test/resources/testDataFiles/review.json");
    }

    @Test
    public void AddReviewOnProduct() {

        homePage.getHomePageVerification().verifyThatHomePageIsVisibleSuccessfully();

        ProductsPage productsPage = homePage.getHomePageHeader().clickProductsButton();

        productsPage.saleImageIsVisible();

        productsPage.verifyTitleForProductPage("ALL PRODUCTS");

        productsPage.productsListIsVisible();

        SingleProductPage singleProductPage = productsPage.clickOnViewProductsForFirstProduct();

        singleProductPage.VerifyWriteYourReviewIsVisible();

        singleProductPage.fillReviewInput(
                jsonFileManager.getTestData("name"),
                jsonFileManager.getTestData("email"),
                jsonFileManager.getTestData("review")
        );

        singleProductPage.verifySuccessReviewMessageIsAppear();

    }

}
