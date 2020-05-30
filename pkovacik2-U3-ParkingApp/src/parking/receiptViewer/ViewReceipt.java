/**
 * This interface utilizes the strategy pattern to view
 * various types of receipts.
 */

package parking.receiptViewer;

import parking.Ticket;

public interface ViewReceipt {

    public void displayReceipt(Ticket ticket);
}
