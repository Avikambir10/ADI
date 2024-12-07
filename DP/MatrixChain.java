package DP;

public class MatrixChain {

  public static void main(String[] args) {
    // Define the number of matrices (n)
    int n = 3;

    // Define the dimensions array (n+1 elements for n matrices)
    int[] dimensions = {10, 20, 30, 40};

    // Call the matrixChainMultiplication function and print the result
    int result = Result.matrixChainMultiplication(dimensions, n);
    System.out.println("Minimum number of multiplications required: " + result);
  }
}
class Result {
  // Function to calculate the minimum cost of matrix chain multiplication
  static int matrixChainMultiplication(int p[], int n) {
    // Create a 2D array to store the results of subproblems
    int[][] dp = new int[n + 1][n + 1];

    // Initialize the diagonal (single matrices cost zero)
    for (int i = 1; i <= n; i++) {
      dp[i][i] = 0;
    }

    // Solve for chain lengths from 2 to n
    for (int chainLength = 2; chainLength <= n; chainLength++) {
      for (int i = 1; i <= n - chainLength + 1; i++) {
        int j = i + chainLength - 1;
        dp[i][j] = Integer.MAX_VALUE; // Initialize to a large value

        // Try all possible splits
        for (int k = i; k < j; k++) {
          int cost = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
          dp[i][j] = Math.min(dp[i][j], cost);
        }
      }
    }

    // Return the result for the full chain
    return dp[1][n];
  }
}
