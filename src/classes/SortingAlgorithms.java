package classes;

import java.util.ArrayList;
import java.util.List;

public class SortingAlgorithms {
    public static <E extends Comparable<E>> void bubbleSort(List<E> array){
        
        //first loop is number of passes
        for(int i=0; i< array.size() - 1; i++){
            boolean swapped = false; // for each pass, check if there is a swap that occured from previous pass, if not, array is sorted
            //second loop to compare each element
            for(int j=0; j < array.size() - i - 1; j++){
                //compare array at now and next index
                //if array at j is bigger, swap
                System.out.println("Array.get(" + j + "): " + array.get(j));
                System.out.println("Array.get(" + j + " + 1): " + array.get(j + 1));
                System.out.println(array.get(j).compareTo(array.get(j + 1)));
                if(array.get(j).compareTo(array.get(j + 1)) > 0){ //>
                    E temp = array.get(j);// saves the value of array[j] to temp
                    array.set(j, array.get(j + 1));// repleaces the value of array[j] with array[j+1]
                    array.set(j + 1, temp); // replaces the value of array[j+1] with temp
                    swapped = true; // if there is a swap, set swapped to true
                }
            }
            //if there is no swap, break the loop
            if (!swapped){
                break;
            }
        }
    }
        public static <E extends Comparable<E>> void mergeSort(List<E> list) {
            mergeSort(list, 0, list.size());
        }

        public static <E extends Comparable<E>> void mergeSort(List<E> list, int startIndex, int endIndex) {
            // Check if there is 1 element or less, exit if true
            if (endIndex - startIndex <= 1) {
                return;
            }
            int middleIndex = (startIndex + endIndex) / 2;
            mergeSort(list, startIndex, middleIndex); // First split of start to middle
            mergeSort(list, middleIndex, endIndex); // Second split of middle to end
            merge(list, startIndex, middleIndex, endIndex);
        }

        public static <E extends Comparable<E>> void merge(List<E> list, int startIndex, int middleIndex, int endIndex) {
            int i = startIndex, j = middleIndex; // i for left array. starting point of first, j for right array. starting point of second
            List<E> tempArray = new ArrayList<>();

            while (i < middleIndex && j < endIndex) {
                if (list.get(i).compareTo(list.get(j)) <= 0) { // If one is bigger, this compareTo will return a pos number
                    tempArray.add(list.get(i));
                    i++;
                } else {
                    tempArray.add(list.get(j));
                    j++;
                }
            }

            // For when one side is completed, for first array
            while (i < middleIndex) {
                tempArray.add(list.get(i));
                i++;
            }

            // Same thing but for second array
            while (j < endIndex) {
                tempArray.add(list.get(j));
                j++;
            }

            for (i = startIndex; i < endIndex; i++) {
                list.set(i, tempArray.get(i - startIndex));
            }
        }
/* 
    public static void mergeSort(int[] array){
        mergeSort(array, 0, array.length);
    }
    public static void mergeSort(int[] array, int startIndex, int endIndex){
        if(endIndex - startIndex <= 1){
            return;
        }
        int middleIndex = (startIndex + endIndex) / 2;
        mergeSort(array, startIndex, middleIndex); //first split of start to middle
        mergeSort(array, middleIndex, endIndex);// second split of middle to end
        merge(array,startIndex,middleIndex,endIndex);
    }
    public static void merge(int[] array, int startIndex, int middleIndex, int endIndex){
        int i = startIndex, j = middleIndex, k = 0; //i for left array. starting point of first, j for right array. starting point of second, k for temp array
        int[] tempArray = new int[endIndex-startIndex];
        while(i < middleIndex && j < endIndex){
            if(array[i] <= array[j]){
                tempArray[k] = array[i];
                i++;
            } else {
                tempArray[k] = array[j];
                j++;
            }
            k++;
        }
        //for when one side is completed, for first array
        while(i < middleIndex){
            tempArray[k] = array[i];
            i++;
            k++;
        }
        //same thing but for second array
        while(j < endIndex){
            tempArray[k] = array[j];
            j++;
            k++;
        }
        for (i = startIndex; i < endIndex; i++){
            array[i] = tempArray[i - startIndex];
        }
    }
*/
}
