package pages.comman;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;
import pages.ProductsPage;

public class LeftSideBar {

    SHAFT.GUI.WebDriver driver;

    //Locators
    private final By categoryText = By.xpath("//div[@class='left-sidebar']/h2");
    private final By womanCategoryButton = By.xpath("//div[@class='panel panel-default'][1]/div/h4/a");
    private final By dressSubCategory = By.xpath("//div[@id='Women']/div/ul/li[1]/a");
    private final By menCategoryButton = By.xpath("//div[@class='panel panel-default'][2]/div/h4/a");
    private final By jeansSubCategory = By.xpath("//div[@id='Men']/div/ul/li[2]/a");


    public LeftSideBar(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void verifyCategoryTextIsVisible() {

        driver.assertThat().element(categoryText).isVisible().
                withCustomReportMessage("Verify Category text is visible successfully.").perform();

        Validations.assertThat().element(categoryText).text().isEqualTo("CATEGORY").
                withCustomReportMessage("Verify Category text is Correct.").perform();
    }

    public void clickWomanCategoryButton() {

        driver.element().click(womanCategoryButton);
    }

    public ProductsPage clickDressButton() {

        driver.element().click(dressSubCategory);
        return new ProductsPage(driver);
    }

    public void clickMenCategoryButton() {

        driver.element().click(menCategoryButton);
    }

    public ProductsPage clickJeansButton() {

        driver.element().click(jeansSubCategory);
        return new ProductsPage(driver);
    }


}
