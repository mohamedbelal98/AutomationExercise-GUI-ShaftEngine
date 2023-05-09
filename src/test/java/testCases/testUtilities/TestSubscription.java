package testCases.testUtilities;

import base.BaseTest;
import com.shaft.tools.io.JSONFileManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.comman.Footer;

public class TestSubscription extends BaseTest {

    JSONFileManager jsonFileManager;
    Footer footer;

    @BeforeClass
    public void beforeClass() {

        jsonFileManager = new JSONFileManager("src/test/resources/testDataFiles/subscription.json");
    }

    @Test
    public void verifySubscriptionInHomePage() {

        footer = new Footer(super.driver);

        homePage.verifyThatHomePageIsVisibleSuccessfully();

        footer.scrollToFooter();

        footer.verifySubscribeText();

        footer.fillEmailAddressInput(jsonFileManager.getTestData("email"));

        footer.verifySuccessMessageForSubscribeIsVisible();
    }

    @Test
    public void verifySubscriptionInCartPage() {

        footer = new Footer(super.driver);

        homePage.verifyThatHomePageIsVisibleSuccessfully();

        homePage.verifyThatHomePageIsVisibleSuccessfully();

        homePage.clickCartButton();

        footer.scrollToFooter();

        footer.verifySubscribeText();

        footer.fillEmailAddressInput(jsonFileManager.getTestData("email"));

        footer.verifySuccessMessageForSubscribeIsVisible();
    }

}
