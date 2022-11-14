import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage extends BasePage{

        By addToBasketButtonLocator = By.id("submit.add-to-cart");
        By basket = By.id("attach-sidesheet-view-cart-button");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailPage() {
        return isDisplayed(addToBasketButtonLocator);
    }

    public void addToBasket() {
        click(addToBasketButtonLocator);
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(basket));
    }
}
