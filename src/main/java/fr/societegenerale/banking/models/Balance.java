package fr.societegenerale.banking.models;

/**
 * Represents the balance of a bank account
 *
 * @author wassim abid
 */
public class Balance {

    private long value;

    public Balance(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }


    public Balance addToBalance(final Amount amount) {
        return new Balance(value+amount.getValue());
    }

    public Balance subtractFromBalance(final Amount amount) {
        return new Balance(value-amount.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Balance that = (Balance) o;
        return value == that.value;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "value=" + value +
                '}';
    }
}
