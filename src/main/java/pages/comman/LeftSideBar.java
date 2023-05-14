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
    private final By brandText = By.xpath("//div[@class='brands_products']/h2");
    private final By poloBrandLink = By.xpath("//div[@class='brands-name']/ul/li[1]");
    private final By HAndMBrandLink = By.xpath("//div[@class='brands-name']/ul/li[2]");


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


    public void verifyBrandTextIsVisible() {

        driver.assertThat().element(brandText).isVisible().
                withCustomReportMessage("Verify brand text is visible successfully.").perform();

        Validations.assertThat().element(brandText).text().isEqualTo("BRANDS").
                withCustomReportMessage("Verify brand text is Correct.").perform();
    }

    public ProductsPage clickPoloBrandLink() {

        driver.element().click(poloBrandLink);
        return new ProductsPage(driver);
    }

    public ProductsPage clickHAndMBrandLink() {

        driver.element().click(HAndMBrandLink);
        return new ProductsPage(driver);
    }

}
