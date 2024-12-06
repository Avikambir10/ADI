package Graph;
import java.util.*;

public class PrimsAlgo {
    public static void main(String[] args) {
        int V = 5;
        int E = 6;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Adding edges: {node, weight}
        adj.get(0).add(new int[]{1, 2});
        adj.get(0).add(new int[]{3, 6});
        adj.get(1).add(new int[]{0, 2});
        adj.get(1).add(new int[]{2, 3});
        adj.get(1).add(new int[]{3, 8});
        adj.get(2).add(new int[]{1, 3});
        adj.get(2).add(new int[]{4, 7});
        adj.get(3).add(new int[]{0, 6});
        adj.get(3).add(new int[]{1, 8});
        adj.get(4).add(new int[]{2, 7});

        System.out.println("Cost of MST: " + spanningTree(V, E, adj));
    }

    static int spanningTree(int V ,int E ,List<List<int[]>> adj ){
        boolean[] vis = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e->e[1]));
        pq.add(new int[] {0,0});//node,weight;
        int ans = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int weight = curr[1];
            
            if(vis[node]) {
                continue;
            }

            vis[node] = true;
            ans += weight;

            for(int[] it : adj.get(node)){
                int nextnode = it[0];
                int weightTillnextnode = it[1];

                if(!vis[nextnode]){
                    pq.add(new int[]{nextnode,weightTillnextnode});
                }
            }
        }
        return ans;
    }
}
