/**
 * The CheckInMachine class represents the check in machine.
 * It uses the processTicket() method to generate ticket information
 * and write it to the ticket.
 */

package parking;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static parking.TicketType.MinMax;
import static parking.TicketType.SpecialEvent;

public class CheckInMachine {

    private final int CheckInStart = 7;
    private final int CheckInEnd = 12;
    private Ticket ticket;
    private int checkInTime;
    private int idNumber;
    private TicketType ticketType;
    Scanner keyboard = new Scanner(System.in);
    int choice;

    public CheckInMachine() {
        ticket = new Ticket();
    }

    public void displayCheckInMenu() {
        System.out.println("Best Value Parking Garage");
        System.out.println("=========================");
        System.out.println("1 - Check-In");
        System.out.println("2 - Special Event");
        System.out.println("3 - Close Garage");
        System.out.println("=>_");
    }

    public int getCheckInMenuResults() {
        try {
            choice = keyboard.nextInt();
        }
        catch (InputMismatchException e) { // returns invalid number
            choice = 5;
        }
        keyboard.nextLine();
        System.out.println();
        return choice;
    }

    public void generateCheckInTime() {
        checkInTime = (int)(Math.random() * ((CheckInEnd - CheckInStart) + 1)) + CheckInStart;
    }

    public void setIdNumber(List<Ticket> tickets) {
        if (tickets == null) {
            idNumber = 100;
        }
        else {
            int i;
            for (i = 1; i <= tickets.size(); i++) {
            }
            idNumber = i + 100;
        }
    }

    public void setTicketType() {
        if (choice == 1)
            ticketType = MinMax;
        else if (choice == 2)
            ticketType = SpecialEvent;
    }



    public Ticket processTicket(List<Ticket> tickets) {

        generateCheckInTime();
        setIdNumber(tickets);
        setTicketType();

        ticket.setCheckInTime(checkInTime);
        ticket.setIdNumber(idNumber);
        ticket.setTicketType(ticketType);
        return ticket;
    }
    // write to ticket:
    // 1.) time in
    // 2.) date in
    // 3.) id number
    // 4.) ticket type (MinMax or SpecialEvent)
}
