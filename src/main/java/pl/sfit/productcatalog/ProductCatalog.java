package pl.sfit.productcatalog;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductCatalog {

    private Map<String, Product> products;

    public ProductCatalog() {
        this.productStorage = new HashMapProductStorage();
    }

    public String addProduct(String s, String nice_one) {
    }

    public List<Product> allProducts() {
    }

    public List<Product> allPublishedProducts() {
        return Collections.emptyList();
    }

    public Product loadById(String productId) {
        return products.get(productId);
    }

    public void changePrice(String productId, BigDecimal newPrice) {
        Product loaded = this.loadById(productId);
        loaded.changePrice(newPrice);
    }

    public void assignImage(String productId, String imageKey) {


    }

    public void publishProduct(String productId) {
        Product product = loadById(productId);

        if (product.getImage() == null) {
            throw new ProductCantBePublishedException();
        }

        if (product.getPrice() == null) {
            throw new ProductCantBePublishedException();
        }

        product.setOnline(true);
    }

}
}
