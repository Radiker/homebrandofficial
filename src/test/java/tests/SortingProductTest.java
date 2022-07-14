package tests;

import org.junit.Test;
import pages.BucketPage;
import pages.HomePage;
import pages.ProductPage;
import pages.WearPage;

public class SortingProductTest extends BaseTest {

    @Test
    public void checkingSortProductByCost() {
        HomePage homePage = new HomePage();
        homePage.openPage()
                .clickGoToWear();

        WearPage wearPage = new WearPage();
        wearPage.selectSortProduct("price:asc").checkFirstPrice("1 000");
    }

    @Test
    public void checkingFillingDataInBasket() {
        HomePage homePage = new HomePage();
        homePage.openPage()
                .clickGoToWear();

        WearPage wearPage = new WearPage();
        wearPage.clickStoreProduct("ФУТБОЛКА ПОЛО ЧЕРНАЯ (М)");

        ProductPage productPage = new ProductPage();
        productPage.clickAddToBucketButton();

        BucketPage bucketPage = new BucketPage();
        bucketPage.sendName("Иванов Иван Иванович");
        bucketPage.sendPhone("0000000000");
        bucketPage.sendRegion("Россия");
        bucketPage.sendAddress("Москва, Ленина 1");

        bucketPage.sendReceiverName("Иванов Иван Иванович");
        bucketPage.sendStreet("Ленина");
        bucketPage.sendHouse("1");
        bucketPage.sendOffice("1");

        bucketPage.clickOrderButton();
        bucketPage.checkPhoneErrorText("Укажите, пожалуйста, корректный номер телефона");
        bucketPage.checkMainErrorText("Укажите, пожалуйста, корректный номер телефона");
    }

}
