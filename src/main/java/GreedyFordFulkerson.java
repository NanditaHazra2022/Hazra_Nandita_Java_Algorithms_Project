/* Java program to demonstrate
* Ford-Fulkerson algorithm,
* which is a greedy approach
* for calculating the maximum
* possible flow in a graph.
* A term, flow network, is used
* to describe a network
* of vertices and edges
* with a source (S)
* and a sink (T). Each vertex,
* except S and T, can receive
* and send an equal amount
* of stuff through it.
* S can only send
* and T can only receive stuff. */

// Importing required class.
import java.util.LinkedList;

// Main class.
public class GreedyFordFulkerson
{   // Start of main class block.
    static final int V = 6; // Number of vertex in the graph.


    boolean bfs(int[][] Graph, int s, int t, int[] p)
    {   // Start of method block.

        boolean[] visited = new boolean[V];
        for (int i = 0;
             i < V;
             i++) {
            visited[i] = false;
        }

        // Creating object of Java in-built LinkedList class.
        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(s);
        visited[s] = true;
        p[s] = -1;

        while (queue.size() != 0)
        {   // Start of while loop block.

            int u = queue.poll();

            for (int v = 0;
                 v < V;
                 v++)
            {   // Start of for loop block.

                if (!visited[v] && Graph[u][v] > 0)
                {   // Start of if condition block.

                    queue.add(v);
                    p[v] = u;
                    visited[v] = true;

                }   // End of if condition block.

            }   // End of for loop block.

        }   // End of while loop block.

        return (visited[t]);

    }   // End of method block.

    // Applying Ford-Fulkerson algorithm
    int algoFordFulkerson(int[][] graph)
    {   // Start of method block.

        int u, v;

        // Declaring 2 dimensional array.
        int[][] graph1 = new int[V][V];

        // Making a copy of graph.
        for (u = 0; u < V; u++) {
            for (v = 0; v < V; v++) {
                graph1[u][v] = graph[u][v];
            }
        }

        int[] p = new int[V];

        int max_flow = 0;
        int s = 0;
        int t = 5;

        while (bfs(graph1, s, t, p))
        {   // Start of while loop block.

            int path_flow = Integer.MAX_VALUE;

            for (v = t;
                 v != s;
                 v = p[v])
            {   // Start of for loop block.

                u = p[v];
                path_flow = Math.min(path_flow, graph1[u][v]);

            }   // End of for loop block.

            for (v = t;
                 v != s;
                 v = p[v])
            {   // Start of for loop block.

                u = p[v];
                graph1[u][v] -= path_flow;
                graph1[v][u] += path_flow;

            }   // End of for loop block.

            // Adding the path flows.
            max_flow += path_flow;

        }   // End of while loop block.

        return max_flow;

    }   // End of method block.

    // Starting point of execution.
    public static void main(String[] args)
    {   // Start of execution thread block.

        // Creating two-dimensional array.
        int[][] graph = new int[][] {
                { 0, 8, 0, 0, 3, 0 },
                { 0, 0, 9, 0, 0, 0 },
                { 0, 0, 0, 0, 7, 2 },
                { 0, 0, 0, 0, 0, 5 },
                { 0, 0, 7, 4, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }
        };

        // Creating object of main class.
        GreedyFordFulkerson gff
                = new GreedyFordFulkerson();

        // Calling Ford-Fulkerson algorithm implementing method.
        System.out.println(
                "Maximum Flow: "
                        + gff.algoFordFulkerson(graph)
        );

    }   // End of execution thread block.

}   // End of main class block.
