package testCases;

import base.BaseTest;
import com.shaft.tools.io.JSONFileManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.AccountInformationPage;
import pages.HomePage;
import pages.SignUpAndLogInPage;

import java.util.Date;


public class TestRegister extends BaseTest {

    JSONFileManager jsonFileManager;
    Date date = new Date();
    String current_time = date.getTime() + "";


    @BeforeClass
    public void beforeClass() {

        jsonFileManager = new JSONFileManager("src/test/resources/testDataFiles/register.json");
    }

    @Test
    public void RegisterUser() {

        String email = jsonFileManager.getTestData("email") + current_time.substring(6) + "@test.com";

        homePage.VerifyThatHomePageIsVisibleSuccessfully();

        SignUpAndLogInPage signUpAndLogInPage = homePage.clickSignUpAndLoginButton();

        signUpAndLogInPage.verifySignUpAndLogInTextIsVisible();

        signUpAndLogInPage.newUserSignUp(
                jsonFileManager.getTestData("name"),
                email
        );

        AccountInformationPage accountInformationPage = signUpAndLogInPage.clickSignUpButton();

        accountInformationPage.VerifyThatENTERACCOUNTINFORMATIONIsVisible();

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

        AccountPage accountPage = accountInformationPage.clickCreateAccountButton();

        accountPage.VerifyThatACCOUNTCREATEDIsVisible();

        HomePage homePage1 = accountPage.clickContinueButton();

        homePage1.verifyThatLoggedInAsIsVisible();

        AccountPage accountPage1 = homePage1.clickDeleteAccountButton();

        accountPage1.verifyThatACCOUNTDELETEDIsVisible();

        accountPage1.clickContinueButton();

    }

}
