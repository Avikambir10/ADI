package DP;
// The problem is to find the total number of ways to cover a given distance D using steps of size 1 up to K.

// For example:

// If 

// D=3 (distance to cover) and 

// K=3 (maximum step size), we can reach the distance of 3 in the following ways:
// 1 + 1 + 1
// 1 + 2
// 2 + 1
// 3
// So, there are 4 ways to cover a distance of 3 with steps of up to 3.

// We need to compute similar counts for any given values of D and K,
// using dynamic programming to efficiently track the possible ways to reach each step up to D.

public class totalWaysToDistance {
    public static void main(String[] args) {
        int d = 6;
        int k = 3;
        System.out.println(ways(d, k));
    }

    static int ways(int distance, int stepSize) {
        int[] dp = new int[distance + 1];
        dp[0] = 1;

        for (int i = 1; i <= distance; i++) {
            dp[i] = 0;
            for (int j = 1; j <= stepSize; j++) {
                if (i - j >= 0) {
                    dp[i] += dp[i - j];
                }
            }
        }
        return dp[distance];
    }
}
