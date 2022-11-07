/* Java program to demonstrate
* merge sort by using Java in-built
* method: Collections.sort()
* The sort algorithm reorders a List
* so that its elements are
* in ascending order.
* The Java in-built method for sorting
* uses the merge sort algorithm
* which has a time complexity of n log(n).
* This sort is stable
* as it does not reorder equal elements. */

// Importing required classes.
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

// Main class.
public class MergeSortJavaInBuiltMethod
{   // Start of main class block.

    // Starting point of execution.
    public static void main(String[] args)
    {   // Start of execution thread block.

        // Creating object of Scanner class.
        Scanner input = new Scanner(System.in);

        // Taking input of size of string dynamic array.
        System.out.println("Input number of words to be sorted-> ");
        int n = input.nextInt();

        // Creating string dynamic array.
        ArrayList<String> arr = new ArrayList<>(n);

        /* Using for loop to take
         * input of elements
         * to be sorted. */
        for (int i = 0;
             i < n;
             i++) {
            System.out.println("Input word " + i + "-> ");
            arr.add(i, input.next());
        }

        System.out.println("\nWords to be sorted as collection -> ");
        System.out.println(arr);

        // Calling the Java in-built method for sorting.
        Collections.sort(arr);
        System.out.println("\nSorted words as collection -> ");
        System.out.println(arr);

    } // End of execution thread block.

} // End of main class block.