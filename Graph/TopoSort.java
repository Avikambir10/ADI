package Graph;

import java.util.*;
// KAHN'S ALOGO 
public class TopoSort {

    public static void main(String[] args) {
        int numVertices = 6;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        // Initialize the adjacency list
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add edges to the adjacency list
        adjList.get(0).add(2);
        adjList.get(0).add(3);
        adjList.get(1).add(3);
        adjList.get(1).add(4);
        adjList.get(2).add(4);
        adjList.get(5).add(0);
        adjList.get(5).add(1);

        try {
            ArrayList<Integer> result = topologicalSort(numVertices, adjList);
            System.out.println("Topological Sort: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    static ArrayList<Integer> topologicalSort(int n, ArrayList<ArrayList<Integer>> adj) {
        
        int [] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        ArrayList<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int current = q.poll();
            topo.add(current);
            for (int it : adj.get(current)) {
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                } 
            }
        }

        // Check for cycles (if not all vertices are in result)
        if (topo.size() != n) {
            throw new IllegalArgumentException("Graph is not a DAG (it contains a cycle)");
        }

        return topo;
    }
}