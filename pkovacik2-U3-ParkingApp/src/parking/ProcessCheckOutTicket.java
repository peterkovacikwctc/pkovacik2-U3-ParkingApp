/**
 * The ProcessCheckOutTicket is a class used within the
 * CheckOutMachine class. The processTicket() method
 * calls the methods in this class and writes the information
 * to the ticket.
 *
 * This class is seperated from the CheckOutMachine to make
 * the code more organized and easier to read.
 */

package parking;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProcessCheckOutTicket {

    private final int CheckOutStart = 13;
    private final int CheckOutEnd = 23;
    private Ticket ticket;
    private TicketType ticketType;
    private int checkInTime;
    private int checkOutTime;
    int choice;
    Scanner keyboard = new Scanner(System.in);

    public ProcessCheckOutTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private void displayCheckOutMenu() {
        System.out.println("Best Value Parking Garage");
        System.out.println("=========================");
        System.out.println("1 - Check-Out");
        System.out.println("2 - Lost Ticket");
        System.out.println("=>_");
    }

    private void getCheckOutMenuResults() {
        try {
            choice = keyboard.nextInt();
            keyboard.nextLine();
            System.out.println();
        }
        catch (InputMismatchException e) { // returns invalid number
            choice = 5;
        }
    }

    private int generateCheckOutTime() {
        return (int)(Math.random() * ((CheckOutEnd - CheckOutStart) + 1)) + CheckOutStart;
    }

    private void setTicketType() {
        if (choice == 2)
            ticketType = TicketType.LostTicket;
        else
            ticketType = ticket.getTicketType();
    }

    public Ticket processTicket() {
        displayCheckOutMenu();
        getCheckOutMenuResults();
        setTicketType();
        checkOutTime = generateCheckOutTime();

        ticket.setCheckOutTime(checkOutTime);
        ticket.setTicketType(ticketType);
        return ticket;
    }





    // a.)
    // constructor takes ticket for information from
    // the check-in machine

    // b.)
    // write to ticket:
    // 1.) check out time
    // 2.) keep ticket type (MinMax or SpecialEvent)
    // or change to Lost


}
