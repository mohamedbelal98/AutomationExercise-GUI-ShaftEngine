package pages.homePage;

import org.openqa.selenium.By;

public class HomePageElements {

    public static By logoLocator() {
        return By.xpath("//img[@alt='Website for automation practice']");
    }

    public static By loggedInAsLocator() {
        return By.xpath("//a[contains( . , ' Logged in as ')]");
    }

    public static By signUpAndLoginLocator() {
        return By.xpath("//a[contains(. , ' Signup / Login')]");
    }

    public static By deleteAccountButton() {
        return By.xpath("//a[contains( . , ' Delete Account')]");
    }

    public static By logoutButton() {
        return By.xpath("//a[contains( . , ' Logout')]");
    }

    public static By contactUsButton() {
        return By.xpath("//a[contains( . , ' Contact us')]");
    }

    public static By testCasesButton() {
        return By.xpath("//a[contains( . , ' Test Cases')]");
    }

    public static By productsButton() {
        return By.xpath("//a[contains( . , ' Products')]");
    }

    public static By cartButton() {
        return By.xpath("//ul[@class='nav navbar-nav']/li[3]");
    }

}
