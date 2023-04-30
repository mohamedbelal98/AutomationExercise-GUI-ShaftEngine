package testCases;

import base.BaseTest;
import com.shaft.tools.io.JSONFileManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignUpAndLogInPage;

public class TestLogout extends BaseTest {

    JSONFileManager jsonFileManager;

    @BeforeClass
    public void beforeClass() {

        jsonFileManager = new JSONFileManager("src/test/resources/testDataFiles/logout.json");
    }

    @Test
    public void logOutUser() {

        homePage.VerifyThatHomePageIsVisibleSuccessfully();

        SignUpAndLogInPage signUpAndLogInPage = homePage.clickSignUpAndLoginButton();

        signUpAndLogInPage.verifyLoginToYourAccountIsVisible();

        signUpAndLogInPage.loginToYourAccount(
                jsonFileManager.getTestData("email"),
                jsonFileManager.getTestData("password")
        );

        HomePage homePage1 = signUpAndLogInPage.clickLoginButton();

        homePage1.verifyThatLoggedInAsIsVisible();

        SignUpAndLogInPage signUpAndLogInPage1 = homePage1.clickLogoutButton();

        signUpAndLogInPage1.verifySignUpAndLogInTextIsVisible();
    }

}
