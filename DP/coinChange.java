package DP;

public class coinChange {
    public static void main(String[] args) {

        int[] coins = { 1, 2, 5 };
        int amount = 11;

        int result = coin_Change(coins, amount);
        System.out.println("Minimum number of coins required: " + result); // Output: 3
    }

    static int coin_Change(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;

            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }
}
