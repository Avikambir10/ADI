package DP;
// leetcode 122. Best Time to Buy and Sell Stock II

public class Stock2 {
    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
        // System.out.println(maxProfit_DP(nums));

    }
    private static int maxProfit(int [] nums){
        int profit= 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums [i-1]){
                profit += nums[i] - nums[i-1];
            }
        }
        return profit;
    }
    
    // static int maxProfit_DP(int [] nums){
    
    // }

}
