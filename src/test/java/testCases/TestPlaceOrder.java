package testCases;

import base.BaseTest;
import com.shaft.tools.io.JSONFileManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import pages.comman.AddToCart;

import java.util.Date;

public class TestPlaceOrder extends BaseTest {

    JSONFileManager jsonFileManager;
    Date date = new Date();
    String current_time = date.getTime() + "";
    AddToCart addToCart;

    @BeforeClass
    public void beforeClass() {

        jsonFileManager = new JSONFileManager("src/test/resources/testDataFiles/placeOrder.json");
    }

    @Test
    public void RegisterWhileCheckout() throws InterruptedException {

        String email = jsonFileManager.getTestData("email") + current_time.substring(6) + "@test.com";

        addToCart = new AddToCart(super.driver);

        homePage.verifyThatHomePageIsVisibleSuccessfully();

        addToCart.hoverAndClickInFirstProduct();

        addToCart.clickOnContinueButton();

        addToCart.hoverAndClickInSecondProduct();

        CartPage cartPage = addToCart.clickViewCartButton();

        cartPage.clickProceedToCheckOut();

        SignUpAndLogInPage signUpAndLogInPage = cartPage.clickRegisterLoginButton();

        signUpAndLogInPage.verifyNewUserSignupIsVisible();

        signUpAndLogInPage.newUserSignUp(
                jsonFileManager.getTestData("name"),
                email
        );

        AccountInformationPage accountInformationPage = signUpAndLogInPage.clickSignUpButton();

        accountInformationPage.verifyThatENTERACCOUNTINFORMATIONIsVisible();

        accountInformationPage.fillAccountInformation(
                jsonFileManager.getTestData("password"),
                jsonFileManager.getTestData("day"),
                jsonFileManager.getTestData("month"),
                jsonFileManager.getTestData("year")
        );

        accountInformationPage.fillAddressInformation(
                jsonFileManager.getTestData("firstName"),
                jsonFileManager.getTestData("lastName"),
                jsonFileManager.getTestData("company"),
                jsonFileManager.getTestData("address1"),
                jsonFileManager.getTestData("address2"),
                jsonFileManager.getTestData("country"),
                jsonFileManager.getTestData("state"),
                jsonFileManager.getTestData("city"),
                jsonFileManager.getTestData("zipcode"),
                jsonFileManager.getTestData("mobileNumber")
        );

        Thread.sleep(3000);

        AccountPage accountPage = accountInformationPage.clickCreateAccountButton();

        accountPage.verifyThatAccountCreatedIsVisible();

        HomePage homePage1 = accountPage.clickContinueButton();

        homePage1.verifyThatLoggedInAsIsVisible(jsonFileManager.getTestData("loginName"));

        CartPage cartPage1 = homePage1.clickCartButton();

        CheckOutPage checkOutPage = cartPage1.clickProceedToCheckOut();

        checkOutPage.verifyAddressDetailsAndReviewYourOrder();

        checkOutPage.fillDescription("Random Description");

        PaymentPage paymentPage = checkOutPage.clickPlaceOrderButton();

        paymentPage.verifyPaymentTextIsVisible();

        paymentPage.fillPaymentDetails(
                jsonFileManager.getTestData("NameOfCard"),
                jsonFileManager.getTestData("CardNumber"),
                jsonFileManager.getTestData("cvc"),
                jsonFileManager.getTestData("monthNumber"),
                jsonFileManager.getTestData("year")
        );

        AccountPage accountPage1 = paymentPage.clickPayAndConfirmOrder();

        accountPage1.verifyThatOrderPlacedIsVisible();

    }

}
