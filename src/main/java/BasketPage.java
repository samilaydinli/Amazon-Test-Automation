import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasketPage extends BasePage {

    By productNameLocator = new By.ByCssSelector("span.a-size-base-plus.a-color-base.sc-product-title.sc-grid-item-product-title > span > span.a-truncate-cut");

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkIfProductAdded() {
        return getProducts().size() > 0;
    }

    private List<WebElement> getProducts(){
        return findAll(productNameLocator);
    }
}
