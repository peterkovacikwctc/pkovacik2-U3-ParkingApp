package parking.vip;

import parking.FeeStrategy;
import parking.Ticket;

public class LostTicketVIPFee implements FeeStrategy {

    public double calculateFee(Ticket ticket) {
        return 100.00;
    }
}
