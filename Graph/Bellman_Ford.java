package Graph;

public class Bellman_Ford {
    
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int[][] edges = {
                { 0, 1, -1 },
                { 0, 2, 4 },
                { 1, 2, 3 },
                { 1, 3, 2 },
                { 1, 4, 2 },
                { 3, 2, 5 },
                { 3, 1, 1 },
                { 4, 3, -3 }
        }; // Each edge is represented as {u, v, weight}

        int src = 0; // Source vertex

        int[] ans = bellmanFord(V, edges, src);

        System.out.println("Vertex Distance from Source:");
        for (int i = 0; i < V; i++) {
            if (ans[i] == 1000000000) {
                System.out.println("Vertex " + i + " is unreachable");
            } else {
                System.out.println("Vertex " + i + ": " + ans[i]);
            }
        }

    }

    static int[] bellmanFord(int V, int[][] edges, int src) {

        int INF = (int) 1e8; //Infinity

        int[] dist = new int[V];

        for (int i = 0; i < V; i++) {
            dist[i] = INF;
        }

        dist[src] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (int[] it : edges) {
                int u = it[0];
                int v = it[1];
                int weight = it[2];

                if (dist[u] != INF && dist[v] > dist[u] + weight) {
                    dist[v] = dist[u] + weight;
                }
            }
        }
        // check for negative weight cycle..
        for (int[] it : edges) {
            int u = it[0];
            int v = it[1];
            int weight = it[2];

            if (dist[u] != INF && dist[v] > dist[u] + weight) {
                return new int[] { -1 };
            }
        }
        return dist;
    }

}
