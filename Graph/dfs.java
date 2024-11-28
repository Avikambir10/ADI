package Graph;

import java.util.*;
import java.util.Scanner;

public class dfs {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices and edges: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        

        ArrayList<ArrayList<Integer>> graph = createGraph(n, m, sc);
        
        ArrayList<Integer> ans = dfsofgraph(graph);

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
    static ArrayList<Integer> dfsofgraph(ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] vis = new boolean[adj.size()];

        helper(0,adj,vis,list);
        return list;
    }
    static void helper(int node , ArrayList<ArrayList<Integer>> adj,boolean[] vis, ArrayList<Integer> list){
        vis[node] = true;
        list.add(node);
        for(int x: adj.get(node)){
            if(!vis[x]){
                helper(x, adj, vis, list);
            }
        }
    }
}
