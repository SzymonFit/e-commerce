package pl.sfit.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal balance;
    private BigDecimal credit;
    private BigDecimal limit;

    public CreditCard(String cardNumber) {

    }

    public void assignCredit(BigDecimal creditAmount) {
        if (isBelowThreshold(creditAmount)) {
            throw new CreditLimitBelowThresholdException();
        }
        if (isAlreadyAssigned()){
            throw new CreditAssignedTwiceException();
        }
        this.balance = creditAmount;
        this.credit = creditAmount;

    }

    private boolean isAlreadyAssigned() {
        return credit != null;
    }

    private boolean isBelowThreshold(BigDecimal creditAmount) {
        return creditAmount.compareTo(BigDecimal.valueOf(100)) < 0;
    }

    public BigDecimal getBalance() {
        return balance;
    }
    public void withdrawMoney(BigDecimal value) {
        if (value.compareTo(balance) < 0){
            this.balance = this.balance.subtract(value);
        }
        if(value.compareTo(limit) < 0){
            throw new
        }

    }

    public void assignLimit (BigDecimal limit) {
        this.limit = limit;
    }
}