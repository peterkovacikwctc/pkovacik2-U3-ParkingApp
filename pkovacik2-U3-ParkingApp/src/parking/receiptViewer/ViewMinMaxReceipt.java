package parking.receiptViewer;

import parking.Ticket;

public class ViewMinMaxReceipt implements ViewReceipt {

    public void displayReceipt(Ticket ticket) {

        // set variables and modify times from 24 hour clock to 12 hour clock
        int checkInTime = ticket.getCheckInTime();
        int checkOutTime = modifyCheckOutTime(ticket.getCheckOutTime());

        // set AM and PM for check in and check out
        String checkInAMPM = SetAMPM(ticket.getCheckInTime());
        String checkOutAMPM = SetAMPM(ticket.getCheckOutTime());

        // set total hours
        int totalHours = ticket.getCheckOutTime() - ticket.getCheckInTime();

        // print receipt
        System.out.println("Best Value Parking Garage");
        System.out.println("=========================");
        System.out.println("Receipt for vehicle id " + ticket.getIdNumber());
        System.out.println();
        System.out.println(totalHours + " hours parked  " + checkInTime + checkInAMPM + " - " + checkOutTime
                + checkOutAMPM);
        System.out.println("$" + String.format("%.2f", ticket.getTicketFee()));
        System.out.println();
    }

    private String SetAMPM(int time) {

        if (time < 12)
            return "am";
        else
            return "pm";
    }

    private int modifyCheckOutTime(int time) {
        if (time > 12)
            return time - 12;
        else
            return time;
    }
}
