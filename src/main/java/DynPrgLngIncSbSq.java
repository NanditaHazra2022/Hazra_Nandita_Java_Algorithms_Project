/* Java program to find length
* of the longest increasing
* subsequence in an array.
* This program has algorithm
* of dynamic programming.*/

// Importing required classes.
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// Main class.
public class DynPrgLngIncSbSq
{   // Start of main class block.

    /* Method to return the length
    * of the longest increasing
    * subsequence in an array. */
    static int lis(int[] arr, int n)
    {   // Start of method block.

        // Creating array to store longest increasing subsequence.
        Integer[] lis = new Integer[n];

        /* Initializing all the array elements
        * to the minimum value of length of subsequence. */
        Arrays.fill(lis, 1);

        /* Using dynamic programming algorithm
        * to store the length of increasing subsequence. */
        for (int i = 1; i < n; i++)
        {   // Start of outer for loop.

            for (int j = 0; j < i; j++)
            {   // Start of inner for loop.

                if (arr[i] > arr[j]
                        && lis[i] < (lis[j] + 1)) {
                    lis[i] = lis[j] + 1;
                }

            }   // End of inner for loop.

        }   // End of outer for loop.

        /* Returning the longest increasing
        * subsequence in the array. */
        return Collections.max(Arrays.asList(lis));

    }   // End of method block.

    // Starting point of execution
    public static void main(String[] args)
    {   // Start of execution thread block.

        // Creating an array by taking input from the console.
        Scanner input = new Scanner(System.in);

        System.out.println(
                "Input length of array-> "
        );
        int n = input.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println(
                    "Input element of array at index "
                    + i
                    + "-> "
            );
            arr[i] = input.nextInt();
        }

        // Printing on the console the created array.
        System.out.println(
                "\n\nCreated array: "
        );
        for (Object o: arr) {
            System.out.print(o + " ");  // Elements of array will be printed space apart.
        }

        /* Printing on the console
        * the length of the longest increasing
        * subsequence in the array.  */
        System.out.println(
                "\n\nLength of longest increasing subsequence in the array = "
                        + lis(arr, n)
        );

    }   // End of execution thread block.

}   // End of main class block.
