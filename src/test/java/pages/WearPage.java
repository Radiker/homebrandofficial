package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static tests.BaseTest.cfg;

public class WearPage {

    private final By SORT_BUTTON = By.cssSelector(".t-store__sort-select");
    private final By PRODUCTS_PRICE_TEXT = By.cssSelector(".js-product-price[data-product-price-def]");
    private final By STORE_PROD_NAME = By.cssSelector(".js-store-prod-name");
    private final By OPTION = By.cssSelector("option");

    public WearPage openPage() {
        open(cfg.baseUrl() + "/wear");
        return this;
    }

    public WearPage selectSortProduct(String value) {
        $(SORT_BUTTON).click();
        $(SORT_BUTTON).$$("option").filterBy(attribute("value", value)).first().click();
        return this;
    }

    public WearPage checkFirstPrice(String expectedPrice) {
        $$(PRODUCTS_PRICE_TEXT).first().shouldHave(text(expectedPrice));
        return this;
    }

    public WearPage clickStoreProduct(String productName) {
        $$(STORE_PROD_NAME).shouldHave(sizeGreaterThan(0)).filterBy(text(productName)).first().click();
        return this;
    }
}
