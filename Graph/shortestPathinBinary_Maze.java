package Graph;

// Shortest path in a binary maze
import java.util.*;

public class shortestPathinBinary_Maze {
    public static void main(String[] args) {
        int m, n;
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                mat[i][j] = sc.nextInt();

        int srcRow, srcCol, destRow, destCol;
        srcRow = sc.nextInt();
        srcCol = sc.nextInt();
        destRow = sc.nextInt();
        destCol = sc.nextInt();
        sc.close();

        System.out.print("Shortest Path is: " + shortestPath(mat, srcRow, srcCol, destRow, destCol, m, n));
    }

    static int shortestPath(int[][] mat, int srcR, int srcC, int destR, int destC, int m, int n) {
        if (mat[srcR][srcC] == 0 || mat[destR][destC] == 0) {
            return -1;
        }
        int[] rowDir = { 1, -1, 0, 0 };
        int[] colDir = { 0, 0, 1, -1 };

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { srcR, srcC, 0 });

        boolean[][] vis = new boolean[m][n];
        vis[srcR][srcC] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            int length = curr[2];

            if (row == destR && col == destC) {
                return length;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = row + rowDir[i];
                int newCol = col + colDir[i];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                        mat[newRow][newCol] == 1 && !vis[newRow][newCol]) {
                    q.add(new int[] { newRow, newCol, length + 1 });
                    vis[newRow][newCol] = true;
                }
            }
        }

        return -1;
    } 
    
    
    /*static int shortestPathDFS(int[][] mat, int srcR, int srcC, int destR, int destC, int m, int n) {
        if (mat[srcR][srcC] == 0 || mat[destR][destC] == 0) {
            return -1;
        }
        boolean[][] vis = new boolean[m][n];
        return dfs(mat, srcR, srcC, destR, destC, vis, m, n, 0, Integer.MAX_VALUE);
    }

    static int dfs(int[][] mat, int row, int col, int destR, int destC, boolean[][] vis, int m, int n, int length, int minPath) {
        if (row == destR && col == destC) {
            return Math.min(minPath, length);
        }

        vis[row][col] = true;

        int[] rowDir = {1, -1, 0, 0};
        int[] colDir = {0, 0, 1, -1};

        for (int i = 0; i < 4; i++) {
            int newRow = row + rowDir[i];
            int newCol = col + colDir[i];

            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                mat[newRow][newCol] == 1 && !vis[newRow][newCol]) {
                minPath = dfs(mat, newRow, newCol, destR, destC, vis, m, n, length + 1, minPath);
            }
        }

        vis[row][col] = false; // Backtrack
        return minPath;
    }*/
}
