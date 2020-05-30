package parking.commerical;

import parking.FeeStrategy;
import parking.Ticket;

public class LostTicketFee implements FeeStrategy {

    public double calculateFee(Ticket ticket) {
        return 25.00;
    }
}
