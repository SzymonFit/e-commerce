package pl.sfit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.sfit.productcatalog.HashMapProductStorage;
import pl.sfit.productcatalog.ProductCatalog;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    ProductCatalog createMyProductCatalog() {


    }
}
