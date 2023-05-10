package testCases.testAuthentication;

import base.BaseTest;
import com.shaft.tools.io.JSONFileManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SignUpAndLogInPage;

public class TestLogin extends BaseTest {

    JSONFileManager jsonFileManager;

    @BeforeClass
    public void beforeClass() {

        jsonFileManager = new JSONFileManager("src/test/resources/testDataFiles/login.json");
    }




    @Test
    public void LoginUserWithCorrectEmailAndPassword() {

        homePage.getHomePageVerification().verifyThatHomePageIsVisibleSuccessfully();

        SignUpAndLogInPage signUpAndLogInPage = homePage.getHomePageHeader().clickSignUpAndLoginButton();

        signUpAndLogInPage.verifyLoginToYourAccountIsVisible();

        signUpAndLogInPage.loginToYourAccount(
                jsonFileManager.getTestData("email"),
                jsonFileManager.getTestData("password")
        );

        homePage =signUpAndLogInPage.clickLoginButton();

        homePage.getHomePageVerification().verifyThatLoggedInAsIsVisible(jsonFileManager.getTestData("name"));

        homePage.getHomePageHeader().clickLogoutButton();
    }

    @Test
    public void LoginUserWithIncorrectEmailAndPassword() {

        homePage.getHomePageVerification().verifyThatHomePageIsVisibleSuccessfully();

        SignUpAndLogInPage signUpAndLogInPage = homePage.getHomePageHeader().clickSignUpAndLoginButton();

        signUpAndLogInPage.verifyLoginToYourAccountIsVisible();

        signUpAndLogInPage.loginToYourAccount(
                jsonFileManager.getTestData("incorrectEmail"),
                jsonFileManager.getTestData("incorrectPassword")
        );

        signUpAndLogInPage.clickLoginButton();

        signUpAndLogInPage.verifyErrorYourEmailOrPasswordIsIncorrectIsVisible();

    }

}
