/**
 * FileReader class returns an ArrayList of tickets from a file.
 * If the file is blank, it creates an empty ticket ArrayList.
 */

package parking;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public List<Ticket> readFile(String filename) throws IOException, ClassNotFoundException {

        List<Ticket> tickets;
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            tickets = (List<Ticket>) ois.readObject();
            ois.close();
            return tickets;
        }
        catch (IOException e) {
            tickets = new ArrayList<>();
            return tickets;
        }

    }
}

