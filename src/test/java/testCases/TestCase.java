package testCases;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.TestCasesPage;

public class TestCase extends BaseTest {

    @Test
    public void VerifyTestCasesPage() {

        homePage.verifyThatHomePageIsVisibleSuccessfully();

        TestCasesPage testCasesPage = homePage.clickTestCasesButton();

        testCasesPage.VerifyUserIsNavigatedToTestCasesPageSuccessfully();
    }
}
