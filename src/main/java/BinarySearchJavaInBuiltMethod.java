/* Java program to demonstrate
* binary search algorithm
* using Java in-built method:
* Collections.binarySearch(list, key)
* The binary search algorithm searches
* for a specified element in a sorted List. */

// Importing required classes
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

// Main class.
public class BinarySearchJavaInBuiltMethod
{   // Start of main block.

    // Starting point of execution.
    public static void main(String[] args)
    {   // Start of execution thread block.

        /* Creating a sorted list
        * for implementation of binary search algorithm. */
        ArrayList<Integer> arr = new ArrayList<>();
        Collections.addAll(arr, 1, 2, 3, 4, 5); // Bulk operation

        // Taking input of the element to be searched.
        System.out.println(
                "Input integer to be searched in the list-> "
        );
        Scanner input = new Scanner(System.in); // Creating object of Scanner class.
        int k = input.nextInt();

        /* Using Java in-built method
        * to implement binary search algorithm. */
        int pos = Collections.binarySearch(arr, k);

        /* If the List contains the search key,
        * its index is returned.
        * If not, the return value is (-(insertion point) - 1),
        * where the insertion point is the point
        * at which the value would be inserted into the List. */
        if (pos < 0) {
            System.out.println(
                    "The search element does not exist in the list, hence adding it to the list."
            );
            arr.add((-pos - 1), k); // Addition of the searched element to the list.
            System.out.println(
                    "Modified list with added element: "
                    + arr
            );
        } else {
            System.out.println(
                    "The search element exist in the list."
            );
        }

    }   // End of execution thread block.

}   // End of main class block.
