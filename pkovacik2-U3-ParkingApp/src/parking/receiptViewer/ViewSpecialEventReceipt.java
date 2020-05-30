package parking.receiptViewer;

import parking.Ticket;

public class ViewSpecialEventReceipt implements ViewReceipt  {

    public void displayReceipt(Ticket ticket) {
        System.out.println("Best Value Parking Garage");
        System.out.println("=========================");
        System.out.println("Receipt for vehicle id " + ticket.getIdNumber());
        System.out.println();
        System.out.println("Special Event " + " $" + String.format("%.2f", ticket.getTicketFee()));
        System.out.println();
    }
}
