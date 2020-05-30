package parking.commerical;

import parking.FeeStrategy;
import parking.Ticket;

public class SpecialEventFee implements FeeStrategy {

    public double calculateFee(Ticket ticket) {
        return 20.00;
    }
}
