package testCases.testCart;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.comman.AddToCart;

public class TestRemove extends BaseTest {

    AddToCart addToCart;

    @Test
    public void RemoveProductsFromCart() {

        addToCart = new AddToCart(super.driver);

        homePage.verifyThatHomePageIsVisibleSuccessfully();

        addToCart.hoverAndClickInFirstProduct();

        addToCart.clickOnContinueButton();

        CartPage cartPage = homePage.clickCartButton();

        cartPage.deleteProductFromCart();

        //Verify that product in cart is empty
        cartPage.verifyNumberOfItemInCart(0);
    }

}
