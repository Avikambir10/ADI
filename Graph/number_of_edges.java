package Graph;

import java.util.*;

public class number_of_edges {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            System.out.println(no_of_edges(n));
        }
        in.close();
    }

    static int no_of_edges(int n) {
        if (n == 1) {
            return 0;
        }
        boolean[] vis = new boolean[n + 1];
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{1, 0});
        vis[1] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int vertex = current[0];
            int edge = current[1];

            int nextvertex = vertex + 1;
            if (nextvertex == n) return edge + 1;
            if (nextvertex <= n && !vis[nextvertex]) {
                vis[nextvertex] = true;
                q.add(new int[]{nextvertex, edge + 1});
            }
            nextvertex = vertex * 3;
            if (nextvertex == n) return edge + 1;
            if (nextvertex <= n && !vis[nextvertex]) {
                vis[nextvertex] = true;
                q.add(new int[]{nextvertex, edge + 1});
            }
        }
        return -1;
    }
}
/*Find the minimum number of edges in a path of a graph 
Consider a directed graph whose vertices are numbered from 1 to n. There is an edge from a vertex i to a vertex j iff either j = i + 1 or j = 3i. The task is to find the minimum number of edges in a path in G from vertex 1 to vertex n.

Input Format:
1.The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
2.Each test case contains a single line of input which contains an integer, n.
Output Format:

Print the number of edges in the shortest path from 1 to n.
Sample Input

1  9
or
1 8
Sample Output

2

4
Explanation:

The below given graph is formed
The minimum number of edges from vertex 1 to vertex 9 is 2.

 */
