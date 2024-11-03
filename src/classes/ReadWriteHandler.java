package classes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteHandler {
    static int lineCounter = 0;
    
    //write array to file using buffered writer. For each element in array, write it to file
    public static <E> void writeArraytoFile(List<E> array, String filename){
        try (BufferedWriter output = new BufferedWriter(new FileWriter(new File(filename)))){
            for(int i = 0; i < array.size(); i++){
                output.write(array.get(i) + "\n");
            }
            output.close();
        } catch(Exception e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
    
    //read array from file using buffered reader. Must use getArraySize method first to get the size of array
    public static <E> List<E> readArrayfromFile(String filename){
        List<E> array = new ArrayList<>();
        try (BufferedReader file = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = file.readLine()) != null) {
                // Assuming E has a constructor that takes a String
                array.add((E) line); // This cast may need to be adjusted based on the actual type of E
            }

        } catch(Exception e){
            System.err.println("An error occurred while reading from the file: " + e.getMessage());
        }
        return array;
        
    }

    //get the size of the array in the file
    public static int getArraySize(String filename){
        try (BufferedReader file = new BufferedReader(new FileReader(filename))){
            String line = file.readLine();
            //loop to count the lines so we can initilize the max size of array
            while(line != null){
                lineCounter++;
                line = file.readLine();
            }
        return lineCounter;
        } catch(Exception e){
            System.err.println("An error occurred while reading from the file: " + e.getMessage());
            return lineCounter = 0;
        }
        
    }
}


