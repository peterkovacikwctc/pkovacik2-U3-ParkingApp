/**
 * Each of the concrete classes that implement the
 * FeeStrategy class have the calculateFee() method,
 * which is used to calculate the ticket fee.
 */

package parking;

public interface FeeStrategy {

    double calculateFee(Ticket ticket);

}
