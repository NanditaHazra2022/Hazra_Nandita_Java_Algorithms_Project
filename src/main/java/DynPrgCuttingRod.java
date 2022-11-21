/* Java program to find
* the maximum value
* that can be obtained
* by cutting the rod
* and selling its pieces.
* The dynamic programming
* algorithm is in the program. */

// Importing required classes.
import java.util.Scanner;
import java.util.Arrays;

// Main class.
public class DynPrgCuttingRod
{   // Start of main class block.

    // Method to find maximum selling price after cutting the rod.
    private static int cutRod(int[] price, int index, int n, int[][] dp)
    {   // Start of method block.

        if (index == 0) {
            return n * price[0];
        }

        if (dp[index][n] != -1) {
            return dp[index][n];
        }

        int notCut = cutRod(price, index - 1, n, dp);
        int cut = Integer.MIN_VALUE;
        int rod_length = index + 1;

        if (rod_length <= n) {
            cut = price[index]
                    + cutRod(price, index, n - rod_length, dp); // Recursion
        }

        return dp[index][n] = Math.max(cut, notCut);

    }   // End of method block.

    // Starting point of execution.
    public static void main(String[] args)
    {   // Start of execution thread.

        // Taking input of rod size.
        System.out.println(
                "Input size of rod in cm->"
        );
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] price = new int[n];
        // Taking input of selling price of the cut rod pieces.
        for(int i = 0; i < n; i++) {
            System.out.println(
                    "Input selling price of cut piece having length: "
                    + (i + 1)
                    + " cm in rupees-> "
            );
            price[i] = input.nextInt();
        }

        int size = price.length;
        int[][] dp = new int[size][size + 1];
        for (int i = 0; i < size; i++) {
            Arrays.fill(dp[i], -1);
        }

        /* Printing on output console
        * the maximum sale value obtainable
        * after cutting the rod in pieces. */
        System.out.println(
                "\n\nMaximum sale value obtained after cutting the rod in pieces = Rs."
                        + cutRod(price, size - 1, size, dp));

    }   // End of execution thread.

}   // End of main class block.
 