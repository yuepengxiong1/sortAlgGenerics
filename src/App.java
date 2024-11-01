
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {

    //E is placeholder for data type. Comparealbe E to check if the elements are comparable. If return 1, left is bigger than right
    // equal to each other, return 0, right is bigger than left, return -1, check comparable generic
    //E is bounded by Comparable E.
    public static <E extends Comparable<E>> void mergeSort(E[] list ){
        mergeSort(list, 0, list.length);
    }

    public static <E extends Comparable<E>> void mergeSort(E[] list, int startIndex, int endIndex){
        //check if there is 1 element or less, exit if true
        if(endIndex - startIndex <= 1){
            return;
        }
        int middleIndex = (startIndex + endIndex) / 2;
        mergeSort(list, startIndex, middleIndex); //first split of start to middle
        mergeSort(list, middleIndex, endIndex);// second split of middle to end
        merge(list,startIndex,middleIndex,endIndex);
    }
    
    public static <E extends Comparable<E>> void merge(E[] list, int startIndex, int middleIndex, int endIndex){
        int i = startIndex, j = middleIndex; //k = 0; //i for left array. starting point of first, j for right array. starting point of second, k for temp array
        List<E> tempArray = new ArrayList<E>();

        while(i < middleIndex && j < endIndex){
            if(list[i].compareTo(list[j]) <= 0){ //if one is bigger, this compareto will return a pos number
                tempArray.add(list[i]);
                i++;
            } else {
                tempArray.add(list[j]);
                j++;
            }
          
        }

        //for when one side is completed, for first array
        while(i < middleIndex){
            tempArray.add(list[i]);
            i++;
           
        }

        //same thing but for second array
        while(j < endIndex){
            tempArray.add(list[j]);
            j++;
            
        }

        for (i = startIndex; i < endIndex; i++){
            list[i] = tempArray.get(i - startIndex);
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
    public static void bubbleSort(int[] array){
        int comparisons = 0;
        int passes = 0;
        //first loop is number of passes
        for(int i=0; i< array.length - 1; i++){
            boolean swapped = false; // for each pass, check if there is a swap that occured from previous pass, if not, array is sorted
            //second loop to compare each element
            for(int j=0; j < array.length - i - 1; j++){
                //compare array at now and next index
                //if array at j is bigger, swap
                if(array[j] > array[j+1]){
                    int temp = array[j];// saves the value of array[j] to temp
                    array[j] = array[j+1];// repleaces the value of array[j] with array[j+1]
                    array[j+1] = temp; // replaces the value of array[j+1] with temp
                    swapped = true; // if there is a swap, set swapped to true
                    comparisons++;
                }
            }
            //if there is no swap, break the loop
            if (!swapped){
                break;
            }
        }
    }

    public static <E extends Comparable<E>> boolean isSorted(E[] array){
        for(int i = 0; i < array.length - 1; i++){
            //check for each element, if the current element is greater than the next element, return false
            if(array[i].compareTo(array[i - 1]) > 0){
                return false; 
            }
        }
        //otherwise return true if the array is sorted
        return true;
    }
    public static boolean isSorted(int array[]){
        for(int i = 0; i < array.length - 1; i++){
            //check for each element, if the current element is greater than the next element, return false
            if(array[i] > array[i+1]){
                return false; 
            }
        }
        //otherwise return true if the array is sorted
        return true;
    }

    public static int[] generateRandomArray(int size){
        Random random = new Random();
        int array[] = new int[size];   
        for(int i = 0; i < size; i++){
            array[i] = random.nextInt();
        }
        return array;
    }

    public static void writeArraytoFile(int array[], String filename){
        try (BufferedWriter output = new BufferedWriter(new FileWriter(new File(filename)))){
            for(int i = 0; i < array.length; i++){
                output.write(array[i] + " ");
            }
            output.close();
        } catch(Exception e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public static void readArrayfromFile(String filename){
        try (BufferedReader file = new BufferedReader(new FileReader(filename))){
            String line = file.readLine();
            while(line != null){
                System.out.println(line);
                line = file.readLine();
            }
            file.close();
        } catch(Exception e){
            System.err.println("An error occurred while reading from the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        //int array[] = generateRandomArray(10);
        //Integer[] list = new Integer[10];
        //Random random = new Random();

        Student[] studentList = new Student[5];
        studentList[0] = new Student(10, "hello");
        studentList[1] = new Student(120, "renlo");
        studentList[2] = new Student(330, "sello");
       




        //for (int i = 0; i < list.length; i++) {
          //  list[i] = random.nextInt();
        //}

        //writeArraytoFile(array, "filename.txt");
        System.out.println("Array before sorting: ");
       // System.out.println(java.util.Arrays.toString(array)); //shortcut to print array instead of for loop
       // System.out.println(isSorted(studentList));

        long start = System.currentTimeMillis();
        System.out.println("Array after sorting: ");
        //bubbleSort(array);
        mergeSort(studentList);
        long end = System.currentTimeMillis();
       // System.out.println(java.util.Arrays.toString(array));
        System.out.println("Time taken: " + (end - start) + "ms");
        //System.out.println(java.util.Arrays);

    }

    
}
