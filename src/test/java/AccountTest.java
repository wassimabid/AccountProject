import fr.societegenerale.banking.models.Account;

import static java.util.Arrays.asList;
import static  org.junit.Assert.*;

import fr.societegenerale.banking.models.Amount;
import fr.societegenerale.banking.models.Balance;
import fr.societegenerale.banking.models.Operation;
import fr.societegenerale.banking.commons.OperationType;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    /** Test d'un depot **/
    @Test
    public void deposit_account_test(){
        Account account=new Account(new Balance(200l));
        account.diposit(Amount.creatSafeAmout(200L));
        assertEquals(new Balance(400L),account.getBalance());
    }

    /** Test d'un retrait **/
    @Test
    public void withdrawal_account_test(){
        Account account=new Account(new Balance(500l));
        account.withdrawal(Amount.creatSafeAmout(200L));
        assertEquals(new Balance(300L),account.getBalance());
    }

    /** Test d'un retrait  en rouge**/
    @Test
    public void withdrawal_account_with_amount_greate_then_balance_test(){
        Account account=new Account(new Balance(500l));
        account.withdrawal(Amount.creatSafeAmout(800L));
        assertEquals(new Balance(-300L),account.getBalance());
    }


    /** Test d'affichage de Le relevé de compte (Liste des opérations effectués) **/
    @Test
    public void get_a_not_empty_account_statement_test(){
        Account account=new Account(new Balance(100l));

        account.diposit(Amount.creatSafeAmout(100l));
        account.withdrawal(Amount.creatSafeAmout(50l));
        account.diposit(Amount.creatSafeAmout(450l));

        assertThat(account.getAccountStatement()).isEqualTo(asList(
                new Operation(OperationType.DEPOSIT, LocalDate.now(), Amount.creatSafeAmout(100l),new Balance(200l)),
                new Operation(OperationType.WITHDRAWAL,LocalDate.now(),Amount.creatSafeAmout(50l),new Balance(150l)),
                new Operation(OperationType.DEPOSIT,LocalDate.now(),Amount.creatSafeAmout(450l),new Balance(600l))
        ));
    }

    @Test
    public void get_empty_account_statement_test(){
        Account account=new Account(new Balance(100l));
        assertThat(account.getAccountStatement()).isNull();

    }

}
