package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CartPage {

    SHAFT.GUI.WebDriver driver;

    //locators
    private final By numberOfItemInCart = By.xpath("//tr[@id]");
    private final By firstItemPriceText = By.xpath("//div[@id='cart_info']/table/tbody/tr[1]/td[3]/p");
    private final By secondItemPriceText = By.xpath("//div[@id='cart_info']/table/tbody/tr[2]/td[3]/p");
    public final By firstItemQuantity = By.xpath("//tr[@id='product-1']/td[4]/button");
    public final By secondItemQuantity = By.xpath("//tr[@id='product-2']/td[4]/button");
    private final By proceedToCheckout = By.xpath("//a[contains(. , 'Proceed To Checkout')]");
    private final By registerLoginButton = By.xpath("//div[@class='modal-body']/p[2]/a");
    private final By deleteButton = By.className("cart_quantity_delete");

    //Constructor
    public CartPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Verify the number of item in the cart and check the size of the list of product is he same I entered or not.
     *
     * @param numberOfItem enter number of item already added to cart to can verify number of item in cart is correct or not.
     */
    public void verifyNumberOfItemInCart(int numberOfItem) {

        List<WebElement> list = driver.getDriver().findElements(numberOfItemInCart);

        int size = list.size();

        System.out.println(size); //TODO delete this.

        if (numberOfItem != size) {

            Assert.fail("Number of Item in product not correct");
        }
    }

    /**
     * @return firstItemPriceText
     */
    public String verifyFirstItemPrice() {

        return driver.element().getText(firstItemPriceText);
    }

    /**
     * @return secondItemPriceText
     */
    public String verifySecondItemPrice() {

        return driver.element().getText(secondItemPriceText);
    }

    /**
     * Verify Quantity Number in the cart page is correct or not
     *
     * @param element        enter element locator to verify number in this product.
     * @param quantityNumber enter quantity of product to verify the number of product is correct or not.
     */
    public void verifyItemQuantityInCart(By element, int quantityNumber) {

        int number = Integer.parseInt(driver.element().getText(element));

        if (quantityNumber != number) {

            Assert.fail("Quantity Number is not correct");
        }
    }

    /**
     * click proceedToCheckout button
     *
     * @return CheckOutPage
     */
    public CheckOutPage clickProceedToCheckOut() {

        driver.element().click(proceedToCheckout);
        return new CheckOutPage(driver);
    }

    /**
     * Click registerLogin button
     *
     * @return SignUpAndLogInPage
     */
    public SignUpAndLogInPage clickRegisterLoginButton() {

        driver.element().click(registerLoginButton);
        return new SignUpAndLogInPage(driver);
    }

    //Delete product in the cart and wait to delete button to be inVisible
    public void deleteProductFromCart() {

        driver.element().click(deleteButton);

        WebDriverWait webDriverWait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));

        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(deleteButton));
    }

}
