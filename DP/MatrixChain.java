package DP;

public class MatrixChain {
    
    public static void main(String[] args) {
        // Input: number of matrices and their dimensions
        int n = 4; // Number of matrices (3 matrices => 4 dimensions)
        int[] dimensions = { 10, 20, 30, 40 };

        // Output the minimum multiplication cost
        System.out.println(matrixChainMultiplication(dimensions, n));
    }
    // Function to find the minimum cost of matrix chain multiplication
    static int matrixChainMultiplication(int p[], int n) {
        // Create a table to store results of subproblems
        int[][] dp = new int[n][n];

        // Initialize the table with 0 for single matrices (no multiplication needed)
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // Solve for chain lengths 2 to n-1
        for (int chainLength = 2; chainLength < n; chainLength++) {
            for (int i = 1; i < n - chainLength + 1; i++) {
                int j = i + chainLength - 1;
                dp[i][j] = Integer.MAX_VALUE; // Set to a very high value initially

                // Try all possible places to split the chain
                for (int k = i; k < j; k++) {
                    // Calculate the cost of splitting at k
                    int cost = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];

                    // Update the minimum cost for dp[i][j]
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        // Return the result for the full chain
        return dp[1][n - 1];
    }


}
