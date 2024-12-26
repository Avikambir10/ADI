package DP;

import java.util.Arrays;

public class coinChange {
    public static void main(String[] args) {

        int[] coins = { 1, 2, 5 };
        int amount = 11;

        int result = coin_Change(coins, amount);
        System.out.println("Minimum number of coins required: " + result); // Output: 3
    }

    static int coin_Change(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        // Initialize dp array with a high value (amount + 1 is used as infinity)
        Arrays.fill(dp, amount + 1);

        // Base case: 0 amount requires 0 coins
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If dp[amount] is still amount + 1, it means we cannot form the amount
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
