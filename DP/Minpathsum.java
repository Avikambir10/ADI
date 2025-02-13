package DP;

public class Minpathsum {
    public static void main(String[] args) {
        int[][] grid = {
            {1, 2, 3} ,
            {4 ,8 ,2} ,
            {1 ,5 ,3}
        };
        int result = minPathSum(grid);
        System.out.println("Minimum path sum: " + result); // Output: 7
    }

    static int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];

        dp[0][0] = grid[0][0];

        // fill columns first
        for (int i = 1; i < col; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }

        // fill row first
        for (int i = 1; i < row; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }

        // then rest of the cells;
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                // dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]); // right and down only

                //if you want to check diagonal(left) also
               dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
            }
        }
        return dp[row - 1][col - 1];
    }
}
