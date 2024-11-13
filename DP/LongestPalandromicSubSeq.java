package DP;

public class LongestPalandromicSubSeq {

    public static void main(String[] args) {
        String str = "bbbab";
        int ans = longestPalindromeSubseq(str);
        System.out.println(ans);
    }

    static int longestPalindromeSubseq(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return helper(str, sb.toString());
    }

    static int helper(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= dp.length - 1; i++) {
            for (int j = 1; j <= dp[0].length - 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }

}