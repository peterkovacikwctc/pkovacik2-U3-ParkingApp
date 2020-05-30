package parking.commerical;

import parking.FeeStrategy;
import parking.Ticket;

public class MinMaxFee implements FeeStrategy {



    public double calculateFee(Ticket ticket) {

        int hoursParked = ticket.getCheckOutTime() - ticket.getCheckInTime();
        double minimumFee = 5.00;
        double additionalHour = 1.00;
        double maximumCharge = 15.00;


        if (hoursParked <= 3) {
            return minimumFee;
        } else if (hoursParked <= 12) {
            return minimumFee + ((hoursParked - 3) * additionalHour);
        } else {
            return maximumCharge;
        }
    }
}
