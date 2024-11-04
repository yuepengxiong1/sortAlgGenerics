
This is a modifed version of BubbleSort/MergeSort. This implements generics into the code instead of having to rely on a certain data type

BUGS:

```
Although, passing a number and having them sorted works fine, passing a file with numbers in them works fine however, it will not sort the numbers. Needs to be looked into.
```

How to use:
```
java -jar --enable-preview [jar file] [enter a integer or a text file]
```

Example of output:

```
$ java -jar --enable-preview mergeSortBubbleSortCompare.jar 100000
Generated random array of size 100000
Is the intial array sorted? false
Bubble Sort took 7497ms to sort the array
Is the final array sorted? true
Merge Sort took 10ms to sort the array
Is the final array sorted? true
Merge sort is faster by: 7487ms
```

This save the unsorted array and sorted array using both methods as a textfile. Generated arrays will have the number of generated numbers in the name of the text file. Passed in text files will not generate an unsorted array as you already have one. It will only generate the sorted one.
