package pl.sfit.sales;

import java.math.BigDecimal;

public class Offer {
    BigDecimal total;
    Integer itemsCount;

    public Offer(){
        this.total = BigDecimal.ZERO;
        this.itemsCount = 0;
    }


}
