package DP;

public class uniquePaths {
    public static void main(String[] args) {
        int row = 3;
        int col = 3;
        System.out.println(ways(row, col));
    }

    static int ways(int row, int col) {
        int[][] dp = new int[row][col];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[row - 1][col - 1];
    }
}
