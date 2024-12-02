package Graph;

import java.util.*;

class iPair {
    int vertex, weight;

    iPair(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

public class Dijkstra {
    public static void main(String[] args) {
        int n = 5; // Number of vertices
        ArrayList<ArrayList<iPair>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges (u, v, weight)
        adj.get(0).add(new iPair(1, 2)); // Edge 0 → 1 with weight 2
        adj.get(0).add(new iPair(2, 4)); // Edge 0 → 2 with weight 4
        adj.get(1).add(new iPair(2, 1)); // Edge 1 → 2 with weight 1
        adj.get(1).add(new iPair(3, 7)); // Edge 1 → 3 with weight 7
        adj.get(2).add(new iPair(3, 3)); // Edge 2 → 3 with weight 3
        adj.get(3).add(new iPair(4, 1)); // Edge 3 → 4 with weight 1

        ArrayList<Integer> distances = dijkstra(adj, 0); // Source vertex is 0

        System.out.println("Shortest distances from source 0:");
        for (int i = 0; i < distances.size(); i++) {
            System.out.println("Distance to " + i + ": " + distances.get(i));
        }
    }

    static ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        int n = adj.size();
        ArrayList<Integer> dist = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            dist.add(Integer.MAX_VALUE);
        }

        dist.set(src, 0);

        PriorityQueue<iPair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new iPair(src, 0));

        while (!pq.isEmpty()) {
            iPair curr = pq.poll();
            int node = curr.vertex;
            int dis = curr.weight;

            for (iPair neighbour : adj.get(node)) {
                int adjnode = neighbour.vertex;
                int edgeweight = neighbour.weight;

                int newdist = dis + edgeweight;

                if (newdist < dist.get(adjnode)) {
                    dist.set(adjnode, newdist);
                    pq.add(new iPair(adjnode, dist.get(adjnode)));
                }
            }
        }
        return dist;
    }

}