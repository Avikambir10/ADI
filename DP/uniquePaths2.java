package DP;

public class uniquePaths2 {
    public static void main(String[] args) {

        int[][] obstacleGrid = {
                { 0, 0, 0 }, // No obstacles in this row
                { 0, 1, 0 }, // Obstacle in the middle cell of this row
                { 0, 0, 0 } // No obstacles in this row
        };
        // Print the number of unique paths from top-left to bottom-right
        System.out.println("Unique paths with obstacles: " + uniquePathsWithObstacles(obstacleGrid)); // Output: 2
    }

    static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        
        int[][] dp = new int[row][col];

        if(obstacleGrid[0][0] == 1 || obstacleGrid[row -1][col -1] == 1)return 0;

        dp[0][0] = 1;

        for (int i = 1; i < row; i++) {
            dp[i][0] = (obstacleGrid[i][0] == 1) ? 0 : dp[i - 1][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = (obstacleGrid[0][i] == 1) ? 0 : dp[0][i - 1];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[row - 1][col - 1];
    }
}
