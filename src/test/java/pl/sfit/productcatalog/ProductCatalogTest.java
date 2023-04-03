package pl.sfit.productcatalog;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ProductCatalogTest {

    @Test
    void itExposeEmptyProductsList(){
        ProductCatalog catalog = thereIsProductCatalog();
        List<Product> products = catalog.allProducts();
        assertEmptyList(products);
    }

    private void assertEmptyList(List<Product> products) {
        assert 0 == products.size();
    }

    @Test
    void itAllowsToAddProduct(){
        //Arrange
        ProductCatalog catalog = thereIsProductCatalog();
        //Act
        String productId = catalog.addProduct("Lego 8398", "nice one");
        //Assert
        List<Product> products = catalog.allProducts();
        assert 1 == products.size();
    }

    private ProductCatalog thereIsProductCatalog() {

        return new ProductCatalog(
                new HashMapProductStorage();
        );
    }

    @Test
    void itAllowsToChangePrice(){
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct("Lego 8398", "nice one");
        catalog.changePrice(productId, BigDecimal.valueOf(20.20));
        Product loaded = catalog.loadById(productId);
        assertEquals(BigDecimal.valueOf(20.20),  loaded.getPrice());
    }
    @Test
    void itAllowsToAssignImage() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct("lego set 8083", "nice one");

        catalog.assignImage(productId, "foo/boo/nice_image.jpeg");

        Product loadedProduct = catalog.loadById(productId);
        assertEquals("foo/boo/nice_image.jpeg", loadedProduct.getImage());
    }

    @Test
    void itAllowsToPublishProduct() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct("lego set 8083", "nice one");
        catalog.changePrice(productId, BigDecimal.valueOf(10));
        catalog.assignImage(productId, "nice.jpeg");

        catalog.publishProduct(productId);

        List<Product> publishedProducts = catalog.allPublishedProducts();
        assertDoesNotThrow(() -> catalog.publishProduct(productId));
        assertEquals(1, publishedProducts.size());
    }

    @Test
    void publishedProductsAreEmptyForNewCatalog(){
        ProductCatalog catalog = thereIsProductCatalog();
        List<Product> products = catalog.allPublishedProducts();
        assert 1 = products.size();
    }


    @Test
    void itAllowsToLoadProductDetails(){
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct("Lego 8398", "nice one");

        Product loaded = catalog.loadById(productId);
        assert productId.equals(loaded.getId);
    }
//    @Test
//    void productCantBePublishedWithout
}
