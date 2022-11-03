/* Java program to demonstrate
* Dynamic Programming using
* Floyd-Warshall algorithm,
* an algorithm
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
    final static int INF = 999999999, VER = 4;  // INF is short for infinity and VER is short for vertex.

    // Method to implement Floyd-Warshall algorithm.
    void floydWarshall(int[][] matrixA0)
    {   // Start of algorithm implementation block.

        // Two dimensional array declaration.
        int[][] matrixA1 = new int[VER][VER];

        // Copying weighted graph.
        System.arraycopy(matrixA0, 0,
                matrixA1, 0, VER);

        /* The elements in the first column
         * and the first row are left as they are.
         * k is the intermediate vertex
         * in the shortest path
         * from source (i) to destination (j).
         * If direct distance
         * from source (i) to destination (j)
         * is greater than the path
         * through the intermediate vertex (k),
         * then the cell is filled
         * with A[i][k] + A[k][j]. */
        for (int k = 0;
             k < VER;
             k++)
        {   // Start of outer for loop block.
            for (int i = 0;
                 i < VER;
                 i++)
            {   // Start of inner for loop 1 block.
                for (int j = 0;
                     j < VER;
                     j++)
                {   // Start of inner for loop 2 block.
                    if (matrixA1[i][k] + matrixA1[k][j] < matrixA1[i][j]) {
                        matrixA1[i][j]
                                = matrixA1[i][k] + matrixA1[k][j];
                    }
                }   // End of inner for loop 2 block.
            }   // End of inner for loop 1 block.
        }   // End of outer for loop block.

        // Calling method to print matrix.
        printMatrix(matrixA1);

    }   // End of algorithm implementation block.

    // Method for printing matrix.
    void printMatrix(int[][] matrix)
    {   // Start of printing matrix block.
        for (int i = 0;
             i < VER;
             ++i)
        {   // Start of outer for loop block.
            for (int j = 0;
                 j < VER;
                 ++j)
            {   // Start of inner for loop block.
                if (matrix[i][j] == INF) {
                    System.out.print("INF ");
                }
                else {
                    System.out.print(matrix[i][j] + "  ");
                }
            }   // End of inner for loop block.
            System.out.println();
        }   // End of outer for loop block.
    }   // End of printing matrix block.

    // Starting point of execution.
    public static void main(String[] args)
    {   // Start of execution thread block.

        /* Creating a matrix A0 of dimension 4 * 4
        * as 4 is the number of vertices.
        * The row and the column are indexed
        * as i and j respectively.
        * i and j are the vertices of the graph.
        * Each cell matrixA0[i][j] is filled
        * with the distance from the ith vertex
        * to the jth vertex.
        * If there is no path
        * from ith vertex to jth vertex,
        * the cell is left as infinity (INF). */
        int[][] matrixA0 = { { 0, 3, INF, 5 },
                { 2, 0, INF, 4 },
                { INF, 1, 0, INF },
                { INF, INF, 2, 0 } };

        DynPrgFloydWarshall d = new DynPrgFloydWarshall();
        d.floydWarshall(matrixA0);

    }   // End of execution thread block.

}   // End of main class block.
