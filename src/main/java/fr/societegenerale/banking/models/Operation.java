package fr.societegenerale.banking.models;

import fr.societegenerale.banking.commons.OperationType;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents the bank operation (Deposit or withdrawal)
 *
 * @author wassim abid
 */
public class Operation {

    private OperationType operationType;
    private LocalDate operationDate;
    private Amount amount;
    private Balance balance;

    public  Operation(OperationType operationType, LocalDate operationDate, Amount amount, Balance balance){
        this.operationType=operationType;
        this.operationDate=operationDate;
        this.amount=amount;
        this.balance=balance;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Operation that = (Operation) o;
        return operationType == that.operationType &&
                Objects.equals(operationDate, that.operationDate) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(balance, that.balance);
    }


    @Override
    public String toString() {
        return "Operation{" +
                "operationType=" + operationType +
                ",operationDate =" + operationDate +
                ", amount=" + amount +
                ", balance=" + balance +
                '}';
    }

}
