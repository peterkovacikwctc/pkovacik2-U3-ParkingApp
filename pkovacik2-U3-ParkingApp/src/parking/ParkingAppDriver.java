/**
 * <h1>Parking Garage App</h1>
 *
 * The Parking Garage App automates parking and exit functions
 * at a commercial parking garage. It can adapted to any parking
 * garage, and it includes an additional configuration for a
 * VIP parking garage.
 *
 * This program uses three design patterns:
 *
 * 1.) factory pattern - implements different parking fees
 *
 * 2.) singleton pattern - used in the FeeStrategyFactoryCommercial
 * and FeeStrategyFactoryVIP to make a single factory. In both
 * cases, the "classic Singleton" style is used.
 *
 * 3.) strategy pattern - used to display various types of receipts
 *
 *
 * @author  Peter Kovacik
 * @version 1.0
 * @since   2020-05-29
 */


package parking;

import parking.commerical.FeeStrategyFactoryCommercial;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingAppDriver implements Serializable {

    public static void main(String[] args) {

        FeeStrategyFactory factory = FeeStrategyFactoryCommercial.getInstance();

        CheckInMachine checkInMachine;
        CheckOutMachine checkOutMachine;

        Ticket ticket;
        List<Ticket> tickets = new ArrayList<>();
        String filename = "TicketFile.txt";

        FileReader fileReader = new FileReader();
        try {
            tickets = fileReader.readFile(filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        boolean parkAgain = true;
        while (parkAgain) {

            checkInMachine = new CheckInMachine();
            checkInMachine.displayCheckInMenu();
            int checkInChoice = checkInMachine.getCheckInMenuResults();

            // check in (1 - ticket type is MinMax, 2 - ticket type is SpecialEvent)
            if (checkInChoice == 1 || checkInChoice == 2) {

                ticket = checkInMachine.processTicket(tickets); // updates ticket for check in

                checkOutMachine = new CheckOutMachine();
                ticket = checkOutMachine.processTicket(ticket); // updates ticket for check out

                // calculates fee and adds fee to ticket
                FeeStrategy strategy = factory.implement(ticket.getTicketType());
                ticket.setTicketFee(strategy.calculateFee(ticket));

                // prints receipt
                checkOutMachine.printReceipt(ticket);

                // add new ticket to list
                tickets.add(ticket);
            }

            // close garages
            else if (checkInChoice == 3) {
                // display results without adding ticket
                parkAgain = false;
                DisplaySummary summary = new DisplaySummary();
                if (tickets == null) {
                    summary.viewEmptySummary();
                } else {
                    summary.viewSummary(tickets);
                }
            }

            // invalid choice at check in menu
            else {
                System.out.println("You have entered an invalid choice.");
                System.out.println();
            }
        }

        // write ticket list to file
        FileWriter fileWriter = new FileWriter();
        try {
            fileWriter.writeFile(filename, tickets);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
