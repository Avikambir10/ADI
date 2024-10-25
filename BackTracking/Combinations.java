package BackTracking;

import java.util.ArrayList;
import java.util.List;

/*Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.

Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

*/
public class Combinations {
    static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, n, k, 1, new ArrayList<>());
        return res;
    }

    static void backtrack(List<List<Integer>> res, int n, int k, int start, ArrayList<Integer> comb) {
        // If the current combination is of the desired size, add it to the result
        if (comb.size() == k) {
            res.add(new ArrayList<>(comb));
            return;
        }

        // Try each number starting from 'start' to 'n'
        for (int i = start; i <= n; i++) {
            // Add number to the current combination
            comb.add(i);
            // Recursively try to build the next number
            backtrack(res, n, k, i + 1,comb);
            // Backtrack by removing the last number added
            comb.remove(comb.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        List<List<Integer>> ans = combine(n, k);
        System.out.println(ans);
    }
}
