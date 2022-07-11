import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class AddProductToBucketTest {
    public ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.driver.chrome", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://homebrandofficial.ru/wear");
    }

    @Test
    public void checkingAddProductToBucketXPath() {
        String productName = "ФУТБОЛКА ПОЛО ЧЕРНАЯ (М)";

        By element = By.xpath("//*[contains(@class,'js-store-filter-search')]");
        driver.findElement(element).sendKeys(productName);

        element = By.xpath("//*[contains(@class,'js-store-filter-search-btn')]");
        driver.findElement(element).click();

        element = By.xpath("//*[@class='js-product t-store__card t-store__stretch-col t-store__stretch-col_25 t-align_center t-item']");
        Assert.assertEquals(driver.findElements(element).size(), 1);

        element = By.xpath("//*[contains(@class,'js-store-prod-name')]");
        String actualProductName = driver.findElement(element).getText();
        Assert.assertEquals(actualProductName, productName);

        element = By.xpath("//*[contains(@class,'js-product-price')]");
        String actualPrice = driver.findElement(element).getText();
        Assert.assertEquals(actualPrice, "2 800");
    }

    @Test
    public void checkingAddProductToBucketCSS() {
        String productName = "ФУТБОЛКА ПОЛО ЧЕРНАЯ (М)";

        By element = By.cssSelector(".js-store-filter-search");
        driver.findElement(element).sendKeys(productName);

        element = By.cssSelector(".js-store-filter-search-btn");
        driver.findElement(element).click();

        element = By.xpath("//*[@class='js-product t-store__card t-store__stretch-col t-store__stretch-col_25 t-align_center t-item']");
        Assert.assertEquals(driver.findElements(element).size(), 1);

        element = By.cssSelector(".js-store-prod-name");
        String actualProductName = driver.findElement(element).getText();
        Assert.assertEquals(actualProductName, productName);

        element = By.cssSelector(".js-product-price");
        String actualPrice = driver.findElement(element).getText();
        Assert.assertEquals(actualPrice, "2 800");
    }

    @After
    public void afterTest(){
        driver.quit();
    }

}
