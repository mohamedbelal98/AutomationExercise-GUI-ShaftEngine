package testCases;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ProductsPage;
import pages.SingleProductPage;

public class TestProducts extends BaseTest {

    @Test
    public void VerifyAllProductsAndProductDetailPage() {

        homePage.verifyThatHomePageIsVisibleSuccessfully();

        ProductsPage productsPage = homePage.clickProductsButton();

        productsPage.saleImageIsVisible();

        productsPage.productsListIsVisible();

        SingleProductPage singleProductPage = productsPage.clickOnViewProductsForFirstProduct();

        singleProductPage.verifyProductDetailsIsVisible();
    }

}
