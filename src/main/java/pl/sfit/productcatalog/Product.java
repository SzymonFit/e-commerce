package pl.sfit.productcatalog;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {
    private final String uuid;
    private final String name;
    private final String desc;
    private BigDecimal price;
    private String image;


    public Product(UUID uuid, String name, String desc) {
        this.uuid = uuid.toString();
        this.name = name;
        this.desc = desc;
    }

    public String getId() {
        return uuid;
    }

    public UUID getUUID() {
        return UUID.fromString(uuid);
    }

    public String getName() {
        return name;
    }

    public void changePrice(BigDecimal newPrice) {
        price = newPrice;
    }

    BigDecimal getPrice(){
        return price;
    }

    public String getImage() {
        return image;
    }

    public void setOnline(boolean b) {
    }

    public static boolean getOnline(Product product) {
    }
}
