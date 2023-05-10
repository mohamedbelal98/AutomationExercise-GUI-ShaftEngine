package testCases.testAuthentication;

import base.BaseTest;
import com.shaft.tools.io.JSONFileManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SignUpAndLogInPage;

public class TestLogout extends BaseTest {

    JSONFileManager jsonFileManager;

    @BeforeClass
    public void beforeClass() {

        jsonFileManager = new JSONFileManager("src/test/resources/testDataFiles/logout.json");
    }

    @Test
    public void logOutUser() {

        homePage.getHomePageVerification().verifyThatHomePageIsVisibleSuccessfully();

        SignUpAndLogInPage signUpAndLogInPage = homePage.getHomePageHeader().clickSignUpAndLoginButton();

        signUpAndLogInPage.verifyLoginToYourAccountIsVisible();

        signUpAndLogInPage.loginToYourAccount(
                jsonFileManager.getTestData("email"),
                jsonFileManager.getTestData("password")
        );

        homePage = signUpAndLogInPage.clickLoginButton();

        homePage.getHomePageVerification().verifyThatLoggedInAsIsVisible(jsonFileManager.getTestData("name"));

        SignUpAndLogInPage signUpAndLogInPage1 = homePage.getHomePageHeader().clickLogoutButton();

        signUpAndLogInPage1.verifyNewUserSignupIsVisible();
    }

}
