package testCases.testUtilities;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.TestCasesPage;

public class TestCase extends BaseTest {

    @Test
    public void VerifyTestCasesPage() {

        homePage.getHomePageVerification().verifyThatHomePageIsVisibleSuccessfully();

        TestCasesPage testCasesPage = homePage.getHomePageHeader().clickTestCasesButton();

        testCasesPage.VerifyUserIsNavigatedToTestCasesPageSuccessfully();
    }
}
