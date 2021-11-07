import fr.societegenerale.banking.models.Amount;
import fr.societegenerale.banking.models.Balance;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BalanceTest {


    /** Test d'addition d'un montant au balance du compte**/
    @Test
    public void add_to_balance_test(){
        Balance balance=new Balance(500l);
        balance=balance.addToBalance(new Amount(500l));
        assertEquals(new Balance(1000l),balance);
    }

    /** Test de soustraction d'un montant du balance du compte**/

    @Test
    public void subtract_from_balance_test(){
        Balance balance=new Balance(600l);
        balance=balance.subtractFromBalance(new Amount(500l));
        assertEquals(new Balance(100l),balance);
    }

    /** Test de soustraction d'un montant du balance du compte en rouge**/
    @Test
    public void subtract_from_balance_to_get_negatif_balance_test(){
        Balance balance=new Balance(600l);
        balance=balance.subtractFromBalance(new Amount(1000l));
        assertEquals(new Balance(-400l),balance);
    }
}
