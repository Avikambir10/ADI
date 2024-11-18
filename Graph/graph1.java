package Graph;
import java.util.*;

public class graph1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices and edges: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        

        List<List<Integer>> graph = createGraph(n, m, sc);
        printGraph(graph);
    }

    static List<List<Integer>> createGraph(int n, int m, Scanner sc) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter " + m + " edges (format: u v):");
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u); // Uncomment this line for undirected graph
        }
        
        return adj;
    }

    static void printGraph(List<List<Integer>> adj) {
        System.out.println("Graph (Adjacency List):");
        for (int i = 0; i < adj.size(); i++) {
            System.out.print("Vertex " + i + ": ");
            for (int j : adj.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
