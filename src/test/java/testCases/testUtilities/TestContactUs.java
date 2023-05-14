package testCases.testUtilities;

import base.BaseTest;
import com.shaft.tools.io.JSONFileManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class TestContactUs extends BaseTest {

    JSONFileManager jsonFileManager;

    @BeforeClass
    public void beforeClass() {

        jsonFileManager = new JSONFileManager("src/test/resources/testDataFiles/contactUs.json");
    }

    @Test
    public void ContactUsForm() {

        homePage.getHomePageVerification().verifyThatHomePageIsVisibleSuccessfully();

        ContactUsPage contactUsPage = homePage.getHomePageHeader().clickContactUsButton();

        contactUsPage.verifyGetInTouchIsVisible();

        contactUsPage.fillNameEmailSubjectAndMessage(
                jsonFileManager.getTestData("name"),
                jsonFileManager.getTestData("email"),
                jsonFileManager.getTestData("subject"),
                jsonFileManager.getTestData("message"),
                "src/test/resources/Util/testPhoto.webp"
        );

        contactUsPage.clickSubmitButton();

        contactUsPage.acceptAlert();

        contactUsPage.VerifySuccessMessageSuccessYourDetailsHaveBeenSubmittedSuccessfullyIsVisible();

        homePage = contactUsPage.clickHomeButton();

        homePage.getHomePageVerification().verifyThatHomePageIsVisibleSuccessfully();
    }

}
