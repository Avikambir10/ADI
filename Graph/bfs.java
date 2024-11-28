package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfs {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices and edges: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        

        ArrayList<ArrayList<Integer>> graph = createGraph(n, m, sc);
        
        ArrayList<Integer> ans = bfsofgraph(graph,sc);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }

    static ArrayList<ArrayList<Integer>> createGraph(int n, int m, Scanner sc) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
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

    static ArrayList<Integer> bfsofgraph(ArrayList<ArrayList<Integer>> adj, Scanner sc){
        System.out.println("Enter Starting Index:");
        int start = sc.nextInt();
        
        int[] vis = new int[adj.size()];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        q.add(start);
        vis[start] = 0;

        while (!q.isEmpty()) {
            int vertex = q.poll();
            ans.add(vertex);

            for (int it : adj.get(vertex)) {
                if(vis[it] == 0){
                    vis[it] = 1;
                    q.add(it);
                }
            }
        }
        return ans;
    }
    
}