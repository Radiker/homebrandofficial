package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    private final By ADD_TO_BUCKET_BUTTON = By.cssSelector(".js-store-prod-popup-buy-btn-txt");

    public ProductPage clickAddToBucketButton() {
        $(ADD_TO_BUCKET_BUTTON).click();
        return this;
    }
}
