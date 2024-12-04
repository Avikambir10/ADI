package Graph;

public class Flloyd_Warshall {
    public static void main(String[] args) {
        int[][] mat = {
            {0, 1, 43},
            {1, 0, 6},
            {-1, -1, 0}
        };

        System.out.println("Input Matrix:");
        printMatrix(mat);

        shortestDistance(mat);

        System.out.println("\nShortest Distance Matrix:");
        printMatrix(mat);
    }
    public static void shortestDistance(int[][] mat) {
        int n = mat.length;
        int INF = (int) 1e9;  // Use a large number to represent infinity

        // Initialize the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == -1) {
                    mat[i][j] = INF;  // No path set to "infinity"
                }
                if (i == j) {
                    mat[i][j] = 0;  // Distance to self is always 0
                }
            }
        }

        // Floyd-Warshall algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][k] != INF && mat[k][j] != INF) {
                        mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                    }
                }
            }
        }

        // Convert "infinity" back to -1 for unreachable nodes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == INF) {
                    mat[i][j] = -1;
                }
            }
        }
    }

    // Method to print the matrix
    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print((val == -1 ? "-1" : val) + " ");
            }
            System.out.println();
        }
    }

}
