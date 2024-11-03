package classes;

import java.util.Random;
import java.util.List;

public class ArrayHandler {
    //checks if the array is sorted. Returns true if it is sorted, false otherwise
    public static <E extends Comparable<E>> boolean isSorted(List<E> array){
        for(int i = 0; i < array.size() - 1; i++){
            //check for each element, if the current element is greater than the next element, return false
            if(array.get(i).compareTo(array.get(i + 1)) == -1){
                return false; 
            }
        }
        //otherwise return true if the array is sorted
        return true;
    }

    //generate a random array of passed integer size, return the array
    public static int[] generateRandomArray(int size){
        Random random = new Random();
        int array[] = new int[size];   
        for(int i = 0; i < size; i++){
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static boolean isNumeric(String argPassed){
        try {
            Integer.parseInt(argPassed);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
