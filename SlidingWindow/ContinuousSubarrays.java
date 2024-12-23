package SlidingWindow;

import java.util.*;

// https://leetcode.com/problems/continuous-subarrays/description/
public class ContinuousSubarrays {
    public static void main(String[] args) {
        int[] nums = { 5, 4, 2, 4 };
        System.out.println(countSubarray(nums));
    }

    static long countSubarray(int[] nums) {
        long count = 0;
        int right = 0;
        int left = 0;
        TreeMap<Integer, Integer> mpp = new TreeMap<>();
        while (right < nums.length) {
            mpp.put(nums[right], mpp.getOrDefault(nums[right], 0) + 1);

            while (mpp.lastKey() - mpp.firstKey() > 2) {
                mpp.put(nums[left], mpp.get(nums[left]) - 1);
                if (mpp.get(nums[left]) == 0) {
                    mpp.remove(nums[left]);
                }
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }

}
