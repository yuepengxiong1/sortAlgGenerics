import classes.ArrayHandler;
import classes.ReadWriteHandler;
import classes.SortingAlgorithms;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
 
        //if user passes nothing
        if (args.length == 0) {
            System.out.println("There was nothing passed into the program as an argument. Please provide a textfile or a numerical value");

        } else if (args.length == 1) { 
           String store = "randomlyGeneratedArrayof[10]Numbers.txt";
           List<Integer> list = new ArrayList<>();
           List<Integer> list2 = new ArrayList<>();

           //Check if the passed argument is a passed file or a numerical value
           if (store.contains(".txt") == true){
           // array = new int[ReadWriteHandler.getArraySize(store)]; //initialize the array with the size of the file
            list = ReadWriteHandler.readArrayfromFile(store);// read array from file and put into variable
            System.out.println("Is the intial array sorted? " + ArrayHandler.isSorted(list));
            list2.addAll(list); //this is because i dont know if when u use bubblesort, mergesort will be sorting the already sorted numbers.
            
            for (int i = 0; i < list.size(); i++){
                System.out.println(list.get(i));
            }
            System.out.println("next line is after");
            long bubbleStartTime = System.currentTimeMillis();
            SortingAlgorithms.bubbleSort(list); //sort the array
            
            for (int i = 0; i < list.size(); i++){
                System.out.println(list.get(i));
            }
            
            long bubbleEndTime = System.currentTimeMillis();
            System.out.println("Bubble Sort took " + (bubbleEndTime - bubbleStartTime) + "ms to sort the array");
            System.out.println("Is the final array sorted? " + ArrayHandler.isSorted(list));
            ReadWriteHandler.writeArraytoFile(list, "BubblesortedGivenArray.txt");//write the array to new file

            long mergeStartTime = System.currentTimeMillis();
            SortingAlgorithms.mergeSort(list2); //sort the array
            long mergeEndTime = System.currentTimeMillis();
            System.out.println("Merge Sort took " + (mergeEndTime - mergeStartTime) + "ms to sort the array");
            System.out.println("Is the final array sorted? " + ArrayHandler.isSorted(list2));
            ReadWriteHandler.writeArraytoFile(list2, "MergesortedGivenArray.txt");//write the array to new file

            if((mergeEndTime - mergeStartTime) < (bubbleEndTime - bubbleStartTime)){
                System.out.println("Merge sort is faster by: " + ((bubbleEndTime - bubbleStartTime) - (mergeEndTime - mergeStartTime) ) + "ms");
            } else if ((mergeEndTime - mergeStartTime) > (bubbleEndTime - bubbleStartTime)){
                System.out.println("Bubble sort is faster by: " + ((mergeEndTime - mergeStartTime) - (bubbleEndTime - bubbleStartTime)) + "ms");
            } else if ((mergeEndTime - mergeStartTime) == (bubbleEndTime - bubbleStartTime)){
                System.out.println("Both sorting methods took the same time.");
            } else {
                System.out.println("Seems like an error has occured comparing times.");
            }
            
            

            //if the passed argument is a numerical value and does not include .txt
            } else if (ArrayHandler.isNumeric(store) == true){
                list = new ArrayList<>();
                list2 = new ArrayList<>();
                Random random = new Random();

                System.out.println("Generated random array of size " + store);
                for (int i = 0; i < Integer.parseInt(store); i++){
                    list.add(random.nextInt(1,100));
                }
                ReadWriteHandler.writeArraytoFile(list, "randomlyGeneratedArrayof[" + store + "]Numbers.txt");//write the array to new file
                System.out.println("Is the intial array sorted? " + ArrayHandler.isSorted(list));
                list2.addAll(list);

                long bubbleStartTime = System.currentTimeMillis();
                SortingAlgorithms.bubbleSort(list); //sort the array
                long bubbleEndTime = System.currentTimeMillis();
                System.out.println("Bubble Sort took " + (bubbleEndTime - bubbleStartTime) + "ms to sort the array");
                System.out.println("Is the final array sorted? " + ArrayHandler.isSorted(list));
                ReadWriteHandler.writeArraytoFile(list, "BubblesortedGeneratedArray.txt");//write the array to new file

                long mergeStartTime = System.currentTimeMillis();
                SortingAlgorithms.mergeSort(list2); //sort the array
                long mergeEndTime = System.currentTimeMillis();
                 System.out.println("Merge Sort took " + (mergeEndTime - mergeStartTime) + "ms to sort the array");
                System.out.println("Is the final array sorted? " + ArrayHandler.isSorted(list2));
                ReadWriteHandler.writeArraytoFile(list2, "MergesortedGeneratedArray.txt");//write the array to new file

                if((mergeEndTime - mergeStartTime) < (bubbleEndTime - bubbleStartTime)){
                    System.out.println("Merge sort is faster by: " + ((bubbleEndTime - bubbleStartTime) - (mergeEndTime - mergeStartTime) ) + "ms");
                } else if ((mergeEndTime - mergeStartTime) > (bubbleEndTime - bubbleStartTime)){
                    System.out.println("Bubble sort is faster by: " + ((mergeEndTime - mergeStartTime) - (bubbleEndTime - bubbleStartTime)) + "ms");
                } else if ((mergeEndTime - mergeStartTime) == (bubbleEndTime - bubbleStartTime)){
                    System.out.println("Both sorting methods took the same time.");
                } else {
                    System.out.println("Seems like an error has occured comparing times.");
                }

            } else {
                System.out.println("Please provide a valid textfile or a numerical value");
            }
        }//end if 2 
    }//end if
}//end app
