package Graph;

import java.util.*;

public class Cycle_Undirected {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int t = sc.nextInt();
            adj.get(u).add(t);
            adj.get(t).add(u);
        }

        sc.close();
        //

        boolean[] vis = new boolean[v];
        boolean hascycle = false;

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                if (dfs(adj, vis, i, -1)) {
                    hascycle = true;
                    break;
                }
            }
        }

        System.out.println(hascycle ? "Yes" : "No");
    }

    static boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int node, int parent) {
        vis[node] = true;
        for(int it : adj.get(node)){
            if(!vis[it]){
                if(dfs(adj, vis, it, node)){
                    return true;
                }
            }
            else if (it != parent) {
                return true;
            }
        }
        return false;
    }

}