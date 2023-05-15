package testCases.testCart;

import base.BaseTest;
import com.shaft.tools.io.JSONFileManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;
import pages.SignUpAndLogInPage;
import pages.comman.AddToCart;

public class TestSearch extends BaseTest {

    AddToCart addToCart;
    JSONFileManager jsonFileManager;

    @BeforeClass
    public void beforeClass() {

        jsonFileManager = new JSONFileManager("src/test/resources/testDataFiles/search.json");
    }

    @Test
    public void SearchProduct() throws InterruptedException {

        homePage.verifyThatHomePageIsVisibleSuccessfully();

        ProductsPage productsPage = homePage.clickProductsButton();

        productsPage.saleImageIsVisible();

        productsPage.productsListIsVisible();

        productsPage.enterSearchInput(jsonFileManager.getTestData("searchWord"));

        productsPage.clickSearchButton();

        Thread.sleep(4000);

        //Verify the result of search is related to search word.
        productsPage.verifyAllTheProductsRelatedToSearchAreVisible(jsonFileManager.getTestData("searchWord"));
    }

    @Test
    public void SearchProductsAndVerifyCartAfterLogin() {

        addToCart = new AddToCart(super.driver);

        homePage.verifyThatHomePageIsVisibleSuccessfully();

        ProductsPage productsPage = homePage.clickProductsButton();

        productsPage.saleImageIsVisible();

        productsPage.verifyTitleForProductPage("ALL PRODUCTS");

        productsPage.productsListIsVisible();

        productsPage.enterSearchInput(jsonFileManager.getTestData("BlueTop"));

        productsPage.clickSearchButton();

        productsPage.verifyAllTheProductsRelatedToSearchAreVisible(jsonFileManager.getTestData("BlueTop"));

        addToCart.hoverAndClickInFirstProduct();

        CartPage cartPage = addToCart.clickViewCartButton();

        cartPage.verifyNumberOfItemInCart(1);

        SignUpAndLogInPage signUpAndLogInPage = homePage.clickSignUpAndLoginButton();

        signUpAndLogInPage.verifyLoginToYourAccountIsVisible();

        signUpAndLogInPage.loginToYourAccount(
                jsonFileManager.getTestData("email"),
                jsonFileManager.getTestData("password")
        );

        homePage = signUpAndLogInPage.clickLoginButton();

        cartPage = homePage.clickCartButton();

        cartPage.verifyNumberOfItemInCart(1);

    }

}
