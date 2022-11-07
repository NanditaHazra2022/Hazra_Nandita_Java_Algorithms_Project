/* Java program to demonstrate
* shuffling collections of words
* using Java in-built method: Collections.shuffle()
* The shuffle algorithm runs up
* the collections of words from the bottom,
* repeatedly swapping a randomly selected element
* into the current position. */

// Importing required classes.
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

// Main class.
public class ShuffleJavaInBuiltMethod
{   // Start of main class block.

    // Starting point of execution.
    public static void main(String[] args)
    {   // Start of execution thread block.

        // Creating object of Scanner class.
        Scanner input = new Scanner(System.in);

        // Taking input of size of collection of words to be shuffled.
        System.out.println("Input number of words to be shuffled-> ");
        int n = input.nextInt();

        // Creating string dynamic array.
        ArrayList<String> arr = new ArrayList<>(n);

        // Taking input of words to be shuffled.
        System.out.println(
                "Input collections of sorted word, that are to be shuffled."
        );
        for (int i = 0;
        i < n;
        i++) {
            System.out.println(
                    "Input word "
                            + (i+1)
                    + "-> "
            );
            arr.add(i, input.next());
        }

        // Printing on output console the sorted collection of words.
        System.out.println(
                "\nSorted collections of word: "
                + arr
        );

        // Calling Java in-built method for shuffling collection of words.
        Collections.shuffle(arr);

        // Printing on output console the shuffled collection of words.
        System.out.println(
                "\nShuffled collections of word: "
                        + arr
        );

    }   // End of execution thread block.

}   // End of main class block.
