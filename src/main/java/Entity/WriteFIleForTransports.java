package Entity;

import DAO.TransportDAO;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFIleForTransports {
    public static void writeFile(String fileName){
        try {
            FileWriter myWriter = new FileWriter(fileName);
            String string = TransportDAO.TransportsSortedByStartDestinationAscending().toString().replace("Transport",'\n'+"Transport");
            myWriter.write(string);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
