import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    SearchBox searchBox;
    By basketCountLocator = By.id("nav-cart-count");
    By basketContainerLocator = By.id("attach-sidesheet-view-cart-button");
    By cookiesLocator = By.id("sp-cc-accept");

    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }

    public SearchBox searchBox(){
        return this.searchBox;
    }

    public boolean isProductCountUp() {
        return getBasketCount() > 0;
    }

    public void goToBasket() {
        click(basketContainerLocator);
    }

    private int getBasketCount(){
        return Integer.parseInt(find(basketCountLocator).getText());
    }

    public void acceptCookies(){
        if(isDisplayed(cookiesLocator)){
            click(cookiesLocator);
        }
    }
}
