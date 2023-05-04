package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CartPage {

    SHAFT.GUI.WebDriver driver;

    //locators
    private final By numberOfItemInCart = By.xpath("//tr[@id]");
    private final By firstItemPriceText = By.xpath("//div[@id='cart_info']/table/tbody/tr[1]/td[3]/p");
    private final By secondItemPriceText = By.xpath("//div[@id='cart_info']/table/tbody/tr[2]/td[3]/p");
    public final By firstItemQuantity = By.xpath("//tr[@id='product-1']/td[4]/button");
    public final By secondItemQuantity = By.xpath("//tr[@id='product-2']/td[4]/button");

    //Constructor
    public CartPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Verify the number of item in the cart and check the size of the list of product is he same I entered or not.
     *
     * @param numberOfItem
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
     * @param element
     * @param quantityNumber
     */
    public void verifyItemQuantityInCart(By element, int quantityNumber) {

        int number = Integer.parseInt(driver.element().getText(element));

        if (quantityNumber != number) {

            Assert.fail("Quantity Number is not correct");
        }
    }

}
