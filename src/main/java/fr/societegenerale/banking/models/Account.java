package fr.societegenerale.banking.models;

import fr.societegenerale.banking.commons.OperationType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the Bank Account
 *
 * @author wassim abid
 */
public class Account {

    private Balance balance;
    private List<Operation> accountStatement;

    public Account(Balance balance) {
        this.balance = balance;
    }


    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public List<Operation> getAccountStatement() {
        return accountStatement;
    }

    public void addOperation(Operation operation) {
        if (getAccountStatement() == null) {
            List<Operation> newOperation = new ArrayList<>();
            newOperation.add(operation);
            this.accountStatement = newOperation;
        } else {
            getAccountStatement().add(operation);
        }
    }


    public Account diposit(Amount amountToAdd) {
        //Update the balance of the account
        setBalance(getBalance().addToBalance(amountToAdd));

        //Create an operation
        Operation operation = new Operation(OperationType.DEPOSIT, LocalDate.now(), amountToAdd,getBalance());

        //Add the new operation To the AccountStatement
        addOperation(operation);
        return this;
    }

    public Account withdrawal(Amount amountToRetreive) {
        //Update the balance of the account
        setBalance(getBalance().subtractFromBalance(amountToRetreive));

        //Create an operation
        Operation operation = new Operation(OperationType.WITHDRAWAL, LocalDate.now(), amountToRetreive, getBalance());

        //Add the new operation To the AccountStatement
        addOperation(operation);
        return this;
    }
}
