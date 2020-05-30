/**
 * The FileWriter class records the List of tickets to a file.
 */

package parking;

import java.io.*;
import java.util.List;

public class FileWriter {

    public void writeFile (String filename, List<Ticket> tickets) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(tickets);
        oos.close();
    }
}

