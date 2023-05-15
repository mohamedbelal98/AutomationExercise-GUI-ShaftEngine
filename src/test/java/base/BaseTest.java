package base;

import com.shaft.driver.SHAFT;
import org.testng.annotations.BeforeClass;
import pages.homePage.HomePage;

public class BaseTest {

    public SHAFT.GUI.WebDriver driver;
    protected HomePage homePage;

    private static final String BASE_URL = "https://automationexercise.com/";

    @BeforeClass
    public void setUp() {

        driver = new SHAFT.GUI.WebDriver();

        driver.browser().navigateToURL(BASE_URL);

        homePage = new HomePage(driver);
    }

//    @AfterClass
//    public void tearDown() {
//
//        driver.quit();
//    }

}
