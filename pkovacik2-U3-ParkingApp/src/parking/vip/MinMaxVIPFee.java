package parking.vip;

import parking.FeeStrategy;
import parking.Ticket;

public class MinMaxVIPFee implements FeeStrategy {

    public double calculateFee(Ticket ticket) {

        int hoursParked = ticket.getCheckOutTime() - ticket.getCheckInTime();
        double minimumFee = 25.00;
        double additionalHour = 5.00;
        double maximumCharge = 70.00;

        if (hoursParked <= 3) {
            return minimumFee;
        } else if (hoursParked <= 12) {
            return minimumFee + ((hoursParked - 3) * additionalHour);
        } else {
            return maximumCharge;
        }
    }
}
