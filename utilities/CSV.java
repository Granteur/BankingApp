package bankingapp.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CSV {

    // read data from a CSV file & return as a list
    // each element in list will be an array
    // static so it can be accessed at any time
    public static List<String[]> read(String file) {
        // using linked list bc its easy to add elements
        List<String[]> data = new LinkedList<String[]>();
        String dataRow;
        // when you open a new file, you need to add a Try-Catch block
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            //reads to the end of only one line so we added a while loop
            while ((dataRow = br.readLine()) != null){
            //splits each by each comma and put tha data into an array
                String[] dataRecords = dataRow.split(",");
                data.add(dataRecords);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not read file.");
            e.printStackTrace();
        }
        return data;
    }
    
}