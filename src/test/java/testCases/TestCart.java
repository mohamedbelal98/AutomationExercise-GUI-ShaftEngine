package testCases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;

import java.util.Objects;

public class TestCart extends BaseTest {

    @Test
    public void addProductsInCart() throws InterruptedException {

        int numberOfProductWillAdd = 2;

        //Verify that home page is visible successfully.
        homePage.verifyThatHomePageIsVisibleSuccessfully();

        //Click 'Products' button.
        ProductsPage productsPage = homePage.clickProductsButton();

        //Save the first product price in the product page.
        String firstItemPrice = productsPage.verifyFirstItemPrice();
        System.out.println(firstItemPrice);

        //Save the second product price in the product page.
        String secondItemPrice = productsPage.verifySecondItemPrice();
        System.out.println(secondItemPrice);

        //Add first product item to cart.
        productsPage.hoverAndClickInFirstProduct();

        //Click continue button to continue shopping.
        productsPage.clickOnContinueButton();

        //Add second product item to cart.
        productsPage.hoverAndClickInSecondProduct();

        //Click continue button to continue shopping.
        productsPage.clickOnContinueButton();

        //Add second product item to cart.
        productsPage.hoverAndClickInSecondProduct();

        //ClickView cart button to go to cart page.
        CartPage cartPage = productsPage.clickViewCartButton();

        Thread.sleep(4000);

        //verify the number of product in the cart is correct or not.
        cartPage.verifyNumberOfItemInCart(numberOfProductWillAdd);

        //Verify the price of the products is the same in product page and cart page is correct or not(if not fail the test case).
        if (!Objects.equals(firstItemPrice, cartPage.verifyFirstItemPrice()) && !Objects.equals(secondItemPrice, cartPage.verifySecondItemPrice())) {

            Assert.fail("Price not the same in product page and cart page");
        }

        //Verify the quantity of the first product.
        cartPage.verifyItemQuantityInCart(cartPage.firstItemQuantity, 1);

        //Verify the quantity of the first product.
        cartPage.verifyItemQuantityInCart(cartPage.secondItemQuantity, 2);

    }

}
