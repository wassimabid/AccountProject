package fr.societegenerale.banking.exceptions;

/**
 * this exception will be thrown in case we deal with a zero or a negative amount
 *
 * @author wassim abid
 */
public class IllegalAmountException extends IllegalArgumentException {

    public IllegalAmountException(String message) {
        super(message);
    }
}
