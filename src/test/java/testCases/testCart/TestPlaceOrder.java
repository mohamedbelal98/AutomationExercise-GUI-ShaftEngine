package testCases.testCart;

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

        homePage.getHomePageVerification().verifyThatHomePageIsVisibleSuccessfully();

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

        homePage = accountPage.clickContinueButton();

        homePage.getHomePageVerification().verifyThatLoggedInAsIsVisible(jsonFileManager.getTestData("loginName"));

        cartPage = homePage.getHomePageHeader().clickCartButton();

        CheckOutPage checkOutPage = cartPage.clickProceedToCheckOut();

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

        accountPage = paymentPage.clickPayAndConfirmOrder();

        accountPage.verifyThatOrderPlacedIsVisible();

    }

    @Test
    public void RegisterBeforeCheckout() throws InterruptedException {

        String email = jsonFileManager.getTestData("email") + current_time.substring(6) + "@test.com";

        addToCart = new AddToCart(super.driver);

        homePage.getHomePageVerification().verifyThatHomePageIsVisibleSuccessfully();

        SignUpAndLogInPage signUpAndLogInPage = homePage.getHomePageHeader().clickSignUpAndLoginButton();

        signUpAndLogInPage.verifyNewUserSignupIsVisible();

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

        homePage = accountPage.clickContinueButton();

        homePage.getHomePageVerification().verifyThatLoggedInAsIsVisible(jsonFileManager.getTestData("loginName"));

        addToCart.hoverAndClickInFirstProduct();

        addToCart.clickOnContinueButton();

        addToCart.hoverAndClickInSecondProduct();

        addToCart.clickOnContinueButton();

        CartPage cartPage = homePage.getHomePageHeader().clickCartButton();

        CheckOutPage checkOutPage = cartPage.clickProceedToCheckOut();

        checkOutPage.verifyAddressDetailsAndReviewYourOrder();

        checkOutPage.fillDescription("Random Description");

        PaymentPage paymentPage = checkOutPage.clickPlaceOrderButton();

        paymentPage.fillPaymentDetails(
                jsonFileManager.getTestData("NameOfCard"),
                jsonFileManager.getTestData("CardNumber"),
                jsonFileManager.getTestData("cvc"),
                jsonFileManager.getTestData("monthNumber"),
                jsonFileManager.getTestData("year")
        );

        accountPage = paymentPage.clickPayAndConfirmOrder();

        accountPage.verifyThatOrderPlacedIsVisible();

        accountPage = homePage.getHomePageHeader().clickDeleteAccountButton();

        accountPage.verifyThatAccountDeletedIsVisible();

        accountPage.clickContinueButton();

    }

}
