package pages.comman;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import pages.CartPage;

public class AddToCart {

    SHAFT.GUI.WebDriver driver;

    //Locators
    private final By firstProductItem = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[1]");
    private final By addToCartForFirstProductItem = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/a");
    private final By secondProductItem = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[3]/div/div[1]/div[1]");
    private final By addToCartForSecondProductItem = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[3]/div/div[1]/div[2]/div/a");
    private final By continueButton = By.xpath("//button[@class='btn btn-success close-modal btn-block']");
    private final By viewCartButton = By.xpath("//div[@class='modal-body']/p/a");

    //Constructor
    public AddToCart(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void hoverAndClickInFirstProduct() {

        driver.element().hover(firstProductItem);
        driver.element().click(addToCartForFirstProductItem);
    }

    public void hoverAndClickInSecondProduct() {

        driver.element().hover(secondProductItem);
        driver.element().click(addToCartForSecondProductItem);
    }

    public void clickOnContinueButton() {

        driver.element().click(continueButton);
    }

    /**
     * click in cart button
     *
     * @return CartPage
     */
    public CartPage clickViewCartButton() {

        driver.element().click(viewCartButton);
        return new CartPage(driver);
    }

}
