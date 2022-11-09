/* Java program to demonstrate
* algorithm of Huffman coding. */

// Importing required classes.
import java.util.PriorityQueue;
import java.util.Comparator;

// Class to build the graph.
class HuffmanNode {
    int item;
    char c;
    HuffmanNode left;
    HuffmanNode right;
}

// Class for comparing the nodes of graph.
class ImplementComparator
        implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.item - y.item;
    }
}

// Main class
public class HuffmanCoding
{   // Start of main class block.

    // Method to print the code.
    public static void printCode(HuffmanNode root, String s)
    {   // Start of execution thread block.

        if (root.left == null
                && root.right == null &&
                Character.isLetter(root.c)) {
            System.out.println(root.c + "   |  " + s);
            return;
        }

        if (root.left != null) {
            printCode(root.left, s + "0");  // Recursion
        }

        printCode(root.right, s + "1"); // Recursion
    }

    // Starting point of execution.
    public static void main(String[] args)
    {   // Start of execution thread block.

        int n = 4;
        char[] charArray = { 'A', 'B', 'C', 'D' };
        int[] charFreq = { 5, 1, 6, 3 };

        PriorityQueue<HuffmanNode> pq
                = new PriorityQueue<>(n, new ImplementComparator());

        for (int i = 0; i < n; i++) {
            HuffmanNode hn = new HuffmanNode();

            hn.c = charArray[i];
            hn.item = charFreq[i];

            hn.left = null;
            hn.right = null;

            pq.add(hn);
        }

        HuffmanNode root = null;

        while (pq.size() > 1) {

            HuffmanNode left = new HuffmanNode();
            HuffmanNode right = new HuffmanNode();

            if(pq.peek()!=null) {
                left = pq.poll();
            }
            if(pq.peek()!=null) {
                right = pq.poll();
            }

            HuffmanNode f = new HuffmanNode();

            f.item = left.item + right.item;
            f.c = '-';
            f.left = left;
            f.right = right;
            root = f;

            pq.add(f);
        }

        // Calling method to print the code.
        System.out.println(" Char | Huffman code ");
        System.out.println("--------------------");
        if (root != null) {
            printCode(root, "");
        }

    }   // End of execution block.

}   // End of main class block.
