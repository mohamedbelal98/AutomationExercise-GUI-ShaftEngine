package testCases;

import base.BaseTest;
import com.shaft.tools.io.JSONFileManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CartPage;

public class TestSubscription extends BaseTest {

    JSONFileManager jsonFileManager;

    @BeforeClass
    public void beforeClass() {

        jsonFileManager = new JSONFileManager("src/test/resources/testDataFiles/subscription.json");
    }

    @Test
    public void verifySubscriptionInHomePage(){

        homePage.verifyThatHomePageIsVisibleSuccessfully();

        homePage.scrollToFooter();

        homePage.verifySubscribeText();

        homePage.fillEmailAddressInput("email");

        homePage.VerifySuccessMessageForSubscribeIsVisible();
    }

    @Test
    public void verifySubscriptionInCartPage() {

        homePage.verifyThatHomePageIsVisibleSuccessfully();

        homePage.verifyThatHomePageIsVisibleSuccessfully();

        CartPage cartPage = homePage.clickCartButton();

        cartPage.scrollToFooter();

        cartPage.verifySubscribeText();

        cartPage.fillEmailAddressInput("email");

        cartPage.VerifySuccessMessageForSubscribeIsVisible();
    }

}
