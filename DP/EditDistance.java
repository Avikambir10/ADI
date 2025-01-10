package DP;

// https://leetcode.com/problems/edit-distance/description/

public class EditDistance {
    public static void main(String[] args) {
        int ans = minDistance("code", "coding");
        System.out.println(ans);
        
        int ans2 = minDistance("intention", "execution");
        System.out.println(ans2);
    }

    static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int topleft = dp[i - 1][j - 1];
                    int left = dp[i][j - 1];
                    int top = dp[i - 1][j];

                    dp[i][j] = Math.min(topleft, Math.min(left, top)) + 1; /// + 1 very imp
                }
            }
        }
        return dp[m][n];
    }
}
