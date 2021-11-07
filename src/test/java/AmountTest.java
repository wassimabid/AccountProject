import fr.societegenerale.banking.exceptions.IllegalAmountException;
import fr.societegenerale.banking.models.Amount;
import org.junit.Test;

public class AmountTest {

    //Il n y a pas un montant de valeur 0
    @Test(expected = IllegalAmountException.class)
    public void create_a_zero_amount() {
        Amount.creatSafeAmout(0L);
    }

    //Il n y a pas un montant de valeur negatif
    @Test(expected = IllegalAmountException.class)
    public void create_a_negatif_amount() {
        Amount.creatSafeAmout(-5L);
    }
}
