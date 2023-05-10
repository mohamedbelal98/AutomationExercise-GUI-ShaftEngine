package pages.homePageUtli;

import com.shaft.driver.SHAFT;

public class HomePage {

    SHAFT.GUI.WebDriver driver;
    HomePageVerification homePageVerification;
    HomePageHeader homePageHeader;


    //Constructor
    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.homePageVerification = new HomePageVerification(driver);
        this.homePageHeader = new HomePageHeader(driver);
    }

    public HomePageVerification getHomePageVerification() {

        return homePageVerification;
    }

    public HomePageHeader getHomePageHeader() {

        return homePageHeader;
    }

}