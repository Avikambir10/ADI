package DP;
//leetcode 746
public class MincostClimbingStairs {
    public static void main(String[] args) {
        int[] nums = {10, 15, 10, 5, 10};
        int[] nums2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] nums3 = {10, 15, 20};

        System.out.println(minCostClimbingStairs(nums));
        System.out.println(minCostClimbingStairs(nums2));
        System.out.println(minCostClimbingStairs(nums3));
    }
    
    static int minCostClimbingStairs(int[] cost){
        int n =cost.length;
        int[] minCost = new int[n+1];

        minCost[0] = 0;
        minCost[1] = 0;

        for (int i = 2; i <= n; i++) {
            minCost[i] = Math.min((cost[i-2] + minCost[i-2]) , (cost[i-1] + minCost[i-1]));
        }
        return minCost[n];
    }
    
}
