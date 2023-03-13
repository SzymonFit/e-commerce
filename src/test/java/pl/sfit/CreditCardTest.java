package pl.sfit.creditcard;

import org.junit.jupiter.api.Test;

public class CreditCardTest {

    @Test
    void itAllowsToAssignCreditLimit(){
        //Arrange
        CreditCard card = new CreditCard("1234-4567");
        //Act
        card.assignCredit(1000);
        //Assert
        assert card.getBalance() == 1000;
    }
}
