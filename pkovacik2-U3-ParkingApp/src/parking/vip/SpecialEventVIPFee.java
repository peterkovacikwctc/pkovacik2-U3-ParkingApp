package parking.vip;

import parking.FeeStrategy;
import parking.Ticket;

public class SpecialEventVIPFee implements FeeStrategy {


    public double calculateFee(Ticket ticket) {
        return 75.00;
    }
}
