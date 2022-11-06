/* Java program to demonstrate bubble sort,
* which is a sorting algorithm
* that compares two adjacent elements
* and swaps them until they are
* in the intended order.
* Just like the movement of air bubbles
* in the water that rise up to the surface,
* the smaller number is swapped
* with bigger numbers, till
* the smallest number comes
* to the front
* and the biggest number
* reaches the back end. */

// Importing required class.
import java.util.Arrays;

// Main class.
public class BubbleSort
{   // Start of main class block.

    // Method to implement bubble sort algorithm.
    static void bubbleSort(int[] arr)
    {   // Start of method block.

        int size = arr.length;

        // for loop to access each array element.
        for (int i = 0;
             i < size - 1;
             i++)
        {   // Start of outer for loop block.

            // for loop to compare array elements.
            for (int j = 0;
                 j < size - i - 1;
                 j++)
            {   // Start of inner for loop block.

                /* Checking if one number
                * is greater than adjacent
                * number, then swap them. */
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }   // End of inner for loop block.

        }   // End of outer for loop block.

    }   // End of method block.

    // Starting point of execution.
    public static void main(String[] args)
    {   // Start of execution thread.

        // Creating unsorted array.
        int[] data = { -2, 45, 0, 11, -9 };

        // Printing unsorted array on output console.
        System.out.println("Unsorted array:");
        System.out.println(Arrays.toString(data));

        // Calling method to sort array in ascending order.
        bubbleSort(data);

        // Printing sorted array on output console.
        System.out.println("\nSorted array in ascending order:");
        System.out.println(Arrays.toString(data));

    }   // End of execution thread block.

}   // End of main class block.