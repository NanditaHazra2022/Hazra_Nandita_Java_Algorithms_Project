/* Java program to demonstrate
* Minimum Spanning Tree algorithm,
* that is kind of Greedy algorithm.
* The Prim's algorithm will be used.
* The steps for implementing
* Prim's algorithm are as follows.
* 1. Initialize the Minimum Spanning Tree
*    with a vertex chosen at random.
* 2. Find all the edges that
*    connect the tree to new vertices,
*    find the minimum
*    and add it to the tree.
* 3. Keep repeating step 2
*    until the Minimum Spanning Tree
*    is completely structured. */

// Importing required class.
import java.util.Arrays;

// Main class.
public class GreedyPrimsMST {

    public void Prim(int[][] G, int V) {

        int INF = 9999999;

        int num_edge; // number of edge

        // create an array to track selected vertex
        // selected will become true otherwise false
        boolean[] selected = new boolean[V];

        // set selected false initially
        Arrays.fill(selected, false);

        // set number of edge to 0
        num_edge = 0;

        // the number of edge in minimum spanning tree will be
        // always less than (V -1), where V is number of vertices in
        // graph

        // choose 0th vertex and make it true
        selected[0] = true;

        // print for edge and weight
        System.out.println("Edge : Weight");

        while (num_edge < (V - 1)) {
            /* For every vertex in the set S,
            * find all of adjacent vertices.
            * Calculate the distance
            * from the vertex selected
            * at step 1. if the vertex
            * is already in the set S,
            * discard the vertex,
            * otherwise choose another vertex
            * nearest to selected vertex at step 1. */

            int min = INF;
            int x = 0; // row number
            int y = 0; // col number

            for (int i = 0; i < V; i++) {
                if (selected[i]) {
                    for (int j = 0; j < V; j++) {
                        // not in selected and there is an edge
                        if (!selected[j] && G[i][j] != 0) {
                            if (min > G[i][j]) {
                                min = G[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }
            System.out.println(x + " - " + y + " :  " + G[x][y]);
            selected[y] = true;
            num_edge++;
        }
    }

    public static void main(String[] args) {
        GreedyPrimsMST g = new GreedyPrimsMST();

        // number of vertices in graph
        int V = 5;

        // create a 2d array of size 5x5
        // for adjacency matrix to represent graph
        int[][] G = { { 0, 9, 75, 0, 0 }, { 9, 0, 95, 19, 42 }, { 75, 95, 0, 51, 66 }, { 0, 19, 51, 0, 31 },
                { 0, 42, 66, 31, 0 } };

        g.Prim(G, V);
    }
}
