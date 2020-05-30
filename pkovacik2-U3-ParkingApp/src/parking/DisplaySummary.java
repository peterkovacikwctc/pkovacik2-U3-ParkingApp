package parking;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DisplaySummary {

    private int minMaxNumber;
    private double minMaxTotalFees;
    private int specialEventsNumber;
    private double specialEventsTotalFees;
    private int lostTicketNumber;
    private double lostTicketTotalFees;
    private double overallTotalFees;



    private void computeSummary(List<Ticket> tickets) {

        for (Ticket ticket : tickets) {

            if (ticket.getTicketType() == TicketType.MinMax) {
                minMaxNumber++;
                minMaxTotalFees += ticket.getTicketFee();
            }
            else if (ticket.getTicketType() == TicketType.SpecialEvent) {
                specialEventsNumber++;
                specialEventsTotalFees += ticket.getTicketFee();
            }
            else {
                lostTicketNumber++;
                lostTicketTotalFees += ticket.getTicketFee();
            }

            overallTotalFees += ticket.getTicketFee();
        }
    }

    public void viewSummary (List<Ticket> tickets) {
        computeSummary(tickets);

        System.out.println("Best Value Parking Garage");
        System.out.println("==========================");
        System.out.println("Activity to Date");
        System.out.println("");
        System.out.println("$" + String.format("%.2f", minMaxTotalFees) + " was collected from " + minMaxNumber + " Check Ins");
        System.out.println("$" + String.format("%.2f", specialEventsTotalFees) + " was collected from " + specialEventsNumber + " Special Events");
        System.out.println("$" + String.format("%.2f", lostTicketTotalFees) + " was collected from " + lostTicketNumber + " Lost Tickets");
        System.out.println();
        System.out.println("$" + String.format("%.2f", overallTotalFees) + " was collected overall");
        System.out.println();
    }

    public void viewEmptySummary () {
        System.out.println("Best Value Parking Garage");
        System.out.println("==========================");
        System.out.println("No Activity to Date");
        System.out.println("");
    }
}
