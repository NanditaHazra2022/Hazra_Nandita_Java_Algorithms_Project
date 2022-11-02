/* Java program to demonstrate
* Dynamic Programming using
* Floyd-Warshall algorithm.
* Floyd-Warshall Algorithm
* is an algorithm
* for finding the shortest path
* between all the pairs
* of vertices in a weighted graph.
* A weighted graph is a graph
* in which each edge has
* a numerical value
* associated with it. */

// Main class.
public class DynPrgFloydWarshall
{   // Start of main class block.
    final static int INF = 9999, VER = 4;

    // Implementing Floyd-Warshall algorithm
    void floydWarshall(int[][] graph) {
        int[][] matrix = new int[VER][VER];
        int i, j, k;

        for (i = 0;
             i < VER;
             i++) {
            for (j = 0;
                 j < VER;
                 j++) {
                // Re-creating the input array, for element manipulation.
                matrix[i][j] = graph[i][j];
            }
        }

        // Adding vertices individually
        for (k = 0;
             k < VER;
             k++) {
            for (i = 0;
                 i < VER;
                 i++) {
                for (j = 0;
                     j < VER;
                     j++) {
                    if (matrix[i][k] + matrix[k][j] < matrix[i][j]) {
                        matrix[i][j]
                                = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }
        printMatrix(matrix);
    }

    void printMatrix(int[][] matrix) {
        for (int i = 0;
             i < VER;
             ++i) {
            for (int j = 0;
                 j < VER;
                 ++j) {
                if (matrix[i][j] == INF) {
                    System.out.print("INF ");
                }
                else {
                    System.out.print(matrix[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }

    // Starting point of execution.
    public static void main(String[] args)
    {   // Start of execution thread block.

        int[][] graph = { { 0, 3, INF, 5 },
                { 2, 0, INF, 4 },
                { INF, 1, 0, INF },
                { INF, INF, 2, 0 } };

        DynPrgFloydWarshall d = new DynPrgFloydWarshall();
        d.floydWarshall(graph);

    }   // End of execution thread block.

}   // End of main class block.
