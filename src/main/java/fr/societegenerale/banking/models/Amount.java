package fr.societegenerale.banking.models;

import fr.societegenerale.banking.exceptions.IllegalAmountException;


/**
 * Represents the Amount of a bank operation (Deposit or withdrawal)
 *
 * @author wassim abid
 */
public class Amount {

    private long value;

    public Amount(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    //to create a real amount
    public static Amount creatSafeAmout(long value) {
        if (value <= 0) {
            throw new IllegalAmountException("An Amount is always positive");
        }
        return new Amount(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Amount that = (Amount) o;
        return value == that.value;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "value=" + value +
                '}';
    }
}
