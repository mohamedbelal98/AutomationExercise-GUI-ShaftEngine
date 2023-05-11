package testCases.testCart;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ProductsPage;
import pages.SingleProductPage;

public class TestProducts extends BaseTest {

    @Test
    public void VerifyAllProductsAndProductDetailPage() {

        homePage.getHomePageVerification().verifyThatHomePageIsVisibleSuccessfully();

        ProductsPage productsPage = homePage.getHomePageHeader().clickProductsButton();

        productsPage.saleImageIsVisible();

        productsPage.verifyTitleForProductPage("ALL PRODUCTS");

        productsPage.productsListIsVisible();

        SingleProductPage singleProductPage = productsPage.clickOnViewProductsForFirstProduct();

        singleProductPage.verifyProductDetailsIsVisible();
    }

}
