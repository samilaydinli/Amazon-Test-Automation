import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


public class Test_Add_Product_To_Card extends  BaseTest{

    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    BasketPage basketPage;

    @Test
    @Order(1)
    public void search_a_Product(){
        homePage= new HomePage(driver);
        homePage.acceptCookies();
        productsPage = new ProductsPage(driver);
        homePage.searchBox().search("Laptop");
        Assertions.assertTrue(productsPage.isOnProductPage() , "Not on Products Page  !");
    }

    @Test
    @Order(2)
    public void select_a_Product(){
        productDetailPage = new ProductDetailPage(driver);
        productsPage.selectProduct(1);
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage() , "Not on Product Detail Page !");
    }

    @Test
    @Order(3)
    public void add_product_to_basket() throws InterruptedException {
        productDetailPage.addToBasket();
        Assertions.assertTrue(homePage.isProductCountUp() , "Product counter did not increse. ");
    }

    @Test
    @Order(4)
    public void go_to_basket(){
        basketPage = new BasketPage(driver);
        homePage.goToBasket();
        Assertions.assertTrue(basketPage.checkIfProductAdded() , "Product couldn't be added to Basket !");
    }
}
