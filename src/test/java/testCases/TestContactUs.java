package testCases;

import base.BaseTest;
import com.shaft.tools.io.JSONFileManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class TestContactUs extends BaseTest {

    JSONFileManager jsonFileManager;

    @BeforeClass
    public void beforeClass() {

        jsonFileManager = new JSONFileManager("src/test/resources/testDataFiles/contactUs.json");
    }

    @Test
    public void ContactUsForm() {

        homePage.verifyThatHomePageIsVisibleSuccessfully();

        ContactUsPage contactUsPage = homePage.clickContactUsButton();

        contactUsPage.verifyGetInTouchIsVisible();

        contactUsPage.fillNameEmailSubjectAndMessage(
                jsonFileManager.getTestData("name"),
                jsonFileManager.getTestData("email"),
                jsonFileManager.getTestData("subject"),
                jsonFileManager.getTestData("message"),
                "src/test/resources/Utilities/testPhoto.webp"
        );

        contactUsPage.clickSubmitButton();

        contactUsPage.acceptAlert();

        contactUsPage.VerifySuccessMessageSuccessYourDetailsHaveBeenSubmittedSuccessfullyIsVisible();

        HomePage homePage1 = contactUsPage.clickHomeButton();

        homePage1.verifyThatHomePageIsVisibleSuccessfully();
    }

}
