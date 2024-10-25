package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]

Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Permutation_2 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3};
        List<List<Integer>> ans = permuteUnique(arr);
        System.out.println(ans);
    }

    private static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(nums, res, new ArrayList<>(), used);
        return res;
    }

    private static void backtrack(int[] nums, List<List<Integer>> res, ArrayList<Integer> curr, boolean[] used) {
        // If the current permutation is of the same length as nums, add it to the result
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip duplicates: If the current number is the same as the previous number and the previous was not used, continue
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            // If the number is already used in this permutation, skip it
            if (used[i]) {
                continue;
            }

            // Mark the number as used
            used[i] = true;
            // Add the number to the current permutation
            curr.add(nums[i]);

            // Continue building the permutation
            backtrack(nums,res,curr, used);

            // Backtrack by removing the last number added and marking it as unused
            curr.removeLast();
            used[i] = false;
        }
    }
}
