package BackTracking;

import java.util.ArrayList;
import java.util.List;

/*
 Given an array nums of distinct integers, return all the possible
permutations
You can return the answer in any order.

* Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
**/
public class Permutations {
    public static void main(String[] args) {
        int[] arr= {1,4,3};
        List<List<Integer>> ans = permutation(arr);
        System.out.println(ans);
    }

    private static List<List<Integer>> permutation(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(arr,res,new ArrayList<>());
        return res;
    }

    private static void backtrack(int[] nums, List<List<Integer>> res, ArrayList<Integer> curr) {
        if (curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int num : nums) {
            if (curr.contains(num)) {
                continue;
            }
            curr.add(num);
            backtrack(nums, res, curr);
            curr.removeLast();
        }
    }
}
