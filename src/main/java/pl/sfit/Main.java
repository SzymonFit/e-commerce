package pl.sfit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.sfit.productcatalog.HashMapProductStorage;
import pl.sfit.productcatalog.ProductCatalog;

import java.math.BigDecimal;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    ProductCatalog createMyProductCatalog() {
        ProductCatalog productCatalog = new ProductCatalog(new HashMapProductStorage());
        String product1 = productCatalog.addProduct("how to think less", "idk");
        productCatalog.changePrice(product1, BigDecimal.valueOf(10.10));
        productCatalog.assignImage(product1, "foo/niece/image.jpg");
        productCatalog.publishProduct(product1);
        return productCatalog;
    }
}
