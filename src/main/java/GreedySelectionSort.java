/* Java program to demonstrate
* greedy algorithm.
* Selection sort is a sorting algorithm
* that selects the smallest element
* from an unsorted list in each iteration
* and places that element
* at the beginning of the
* unsorted list within iteratively.
* The time complexity
* of this program is O(n*n) */

// Importing required class.
import java.util.Arrays;

// Main class.
public class GreedySelectionSort
{   // Start of main class block.

    // Method of sorting the array.
    void selectionSort(int[] array)
    {   // Start of method block.

        int size = array.length;

        /* Using nested for loop
        * to find the minimum
        * and swap position. */
        for (int step = 0;
             step < size - 1;
             step++)
        {   // Start of outer for block.

            int min_idx = step;

            for (int i = step + 1;
                 i < size;
                 i++)
            {   // Start of inner for block.

                /* Determining minimum
                * value's position
                * and re-assigning it. */
                if (array[i] < array[min_idx]) {
                    min_idx = i;
                }

            }   // End of inner for block.

            /* Putting minimum value
            * at the correct position
            * in the array by swap mechanism. */
            int temp = array[step];
            array[step] = array[min_idx];
            array[min_idx] = temp;

        }   // End of outer for loop.

    }   // End of method block.

    // Starting point of execution.
    public static void main(String[] args)
    {   // Start of execution thread block.

        // Creating unsorted integer array.
        int[] data = { 20, 12, 10, 15, 2 };

        // Printing the created unsorted array.
        System.out.println(
                "Unsorted array: "
                        + Arrays.toString(data)
        );

        // Creating object of main class.
        GreedySelectionSort gss
                = new GreedySelectionSort();

        /* Calling the method
        * to sort array by passing
        * the unsorted array as input. */
        gss.selectionSort(data);

        // Printing the modified sorted array.
        System.out.println(
                "Sorted array: "
                        + Arrays.toString(data)
        );

    }   // End of execution thread block.

}   // End of main class block.