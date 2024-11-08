package DP;

import java.util.*;

public class Knapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int val[] = new int[n];
        int wt[] = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }

        int capacity = sc.nextInt();
        sc.close();
        int ans = zeroOneKnapsack(val, wt, n, capacity);
        System.out.println(ans);
    }

    static int zeroOneKnapsack(int val[], int wt[], int n, int capacity) {

        // Create a DP table where dp[i][w] represents the maximum value for capacity
        // `w` using the first `i` items.
        int[][] dp = new int[n + 1][capacity + 1];

        // Build the table in bottom-up fashion.
        // Loop over each item (from 1 to n).
        for (int i = 1; i <= n; i++) {
            // Loop over each possible capacity (from 1 to the given capacity).
            for (int w = 1; w <= capacity; w++) {
                // `w` is the current capacity of the knapsack we are considering.
                if (wt[i - 1] <= w) {
                    // If the weight of the current item `wt[i-1]` is less than or equal to `w`, we
                    // can include it.
                    dp[i][w] = Math.max(
                            dp[i - 1][w], // Value when excluding the current item.
                            val[i - 1] + dp[i - 1][w- wt[i-1]] // Value when including the current item.
                    );
                } else {
                    // If the weight of the current item is more than `w`, we cannot include it.
                    dp[i][w] = dp[i - 1][w]; // Copy the value from the previous item row.
                }
            }
        }
        return dp[n][capacity];
    }
}

/* input 1           Output
3                 220
60 100 120
10 20 30
50 
*/

/*
input 2          Output
4                50
10 40 30 50
5 4 6 3
5 
*/