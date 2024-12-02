package Graph;

import java.util.*;

public class pathInDirectedGraph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of vertices (V) and edges (E)
        int V = scanner.nextInt();
        int E = scanner.nextInt();

        // Create an adjacency list to represent the graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Read the edges and build the graph
        for (int i = 0; i < E; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.get(u).add(v);
        }

        // Read the source and destination vertices
        int src = scanner.nextInt();
        int dest = scanner.nextInt();

        scanner.close();
        
        // Check if a path exists from src to dest
        if (dfs(graph, src, dest, new boolean[V])) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static boolean dfs(ArrayList<ArrayList<Integer>> adj, int src, int dest, boolean[] vis) {
        vis[src] = true;
        if (src == dest)
            return true;

        for (int it : adj.get(src)) {
            if (!vis[it]) {
                if (dfs(adj, it, dest, vis))
                    return true;
            }
        }
        return false;
    }
}
