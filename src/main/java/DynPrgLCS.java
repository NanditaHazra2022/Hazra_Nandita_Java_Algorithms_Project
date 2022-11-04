/* Java program to demonstrate
* dynamic programming
* using the lowest common sub-sequence. */

// Main class.
public class DynPrgLCS
{   // Start of main class block.

    // Method to find the lowest common sub-sequence.
    static void lcs(String S1,
                    String S2,
                    int l1,
                    int l2)
    {   // Start of method block.

        // Creating table with (l1 + 1) rows and (l2 + 1) columns.
        int[][] LCS_table = new int[l1 + 1][l2 + 1];

        // Building the matrix in bottom-up way
        for (int i = 0;
             i <= l1;
             i++)
        {   // Start of outer for loop block.
            for (int j = 0;
                 j <= l2;
                 j++)
            {   // Start of inner for loop block.

                // Filling the first row and the first column with zeros.
                if (i == 0 || j == 0) {
                    LCS_table[i][j] = 0;
                }
                else if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    LCS_table[i][j]
                            = LCS_table[i - 1][j - 1] + 1;
                }
                else {
                    LCS_table[i][j]
                            = Math.max(LCS_table[i - 1][j], LCS_table[i][j - 1]);
                }

            }   // End of inner for loop block.

        }   // End of outer for loop block.

        int index = LCS_table[l1][l2];
        int temp = index;

        char[] lcs = new char[index + 1];
        lcs[index] = '\0';

        int i = l1, j = l2;
        while (i > 0 && j > 0) {
            if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                lcs[index - 1] = S1.charAt(i - 1);

                i--;
                j--;
                index--;
            }
            else if (LCS_table[i - 1][j] > LCS_table[i][j - 1]) {
                i--;
            }
            else {
                j--;
            }
        }

        // Printing the sub-sequences
        System.out.print(
                "Seq1: " + S1
                        + "\nSeq2: " + S2
                        + "\nLCSubSeq: ");
        for (int k = 0;
             k <= temp;
             k++) {
            System.out.print(lcs[k]);
        }

    }   // End of method block.

    // Starting point of execution.
    public static void main(String[] args)
    {   // Start of execution thread block.

        // Declaring and initializing two sequences.
        String S1 = "ACADBAB";
        String S2 = "BBCBADA";

        // Storing the length of sequences.
        int l1 = S1.length();
        int l2 = S2.length();

        // Calling method to find the least common sub-sequence.
        lcs(S1, S2, l1, l2);

    }   // End of execution thread block.

}   // End of main class block.
