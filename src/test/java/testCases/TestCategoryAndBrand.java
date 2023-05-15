package testCases;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ProductsPage;
import pages.comman.LeftSideBar;

public class TestCategoryAndBrand extends BaseTest {

    LeftSideBar leftSideBar;

    @Test
    public void ViewCategoryProducts() {

        leftSideBar = new LeftSideBar(super.driver);

        homePage.verifyThatHomePageIsVisibleSuccessfully();

        leftSideBar.verifyCategoryTextIsVisible();

        leftSideBar.clickWomanCategoryButton();

        ProductsPage productsPage = leftSideBar.clickDressButton();

        productsPage.verifyTitleForProductPage("WOMEN - DRESS PRODUCTS");

        leftSideBar.clickMenCategoryButton();

        leftSideBar.clickJeansButton();

        productsPage.verifyTitleForProductPage("MEN - JEANS PRODUCTS");
    }

    @Test
    public void ViewBrandProducts() {

        leftSideBar = new LeftSideBar(super.driver);

        homePage.verifyThatHomePageIsVisibleSuccessfully();

        leftSideBar.verifyBrandTextIsVisible();

        ProductsPage productsPage = leftSideBar.clickPoloBrandLink();

        productsPage.verifyTitleForProductPage("BRAND - POLO PRODUCTS");

        productsPage = leftSideBar.clickHAndMBrandLink();

        productsPage.verifyTitleForProductPage("BRAND - H&M PRODUCTS");
    }

}
