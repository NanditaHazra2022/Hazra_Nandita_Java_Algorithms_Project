/* Java program to demonstrate
* dynamic programming algorithm.*/

// Importing required class.
import java.util.Scanner;

// Main class.
public class DynPrgClimbStairsWays
{   // Start of main class block.

    // Fibonacci series method.
    static int fib(int n)
    {
        if (n <= 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

    // Method to count number of ways.
    static int countWays(int s)
    {
        return fib(s + 1);  // Recursion
    }

    // Starting point of execution.
    public static void main(String[] args)
    { // Start of execution thread block.

        // Taking input for the number of steps to be climbed.
        System.out.println("Input the number of steps-> ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        // Printing on output console the number of ways to climb the stairs.
        System.out.println(
                "Number of ways to climb the stairs for steps: "
                        + n
                        + " is "
                        + countWays(n)
        );

    }   // End of execution thread block.

}   // End of main class blink.