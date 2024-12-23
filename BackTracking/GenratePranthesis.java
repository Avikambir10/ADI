package BackTracking;
//https://leetcode.com/problems/generate-parentheses/description/

import java.util.ArrayList;
import java.util.List;

public class GenratePranthesis {
    public static void main(String[] args) {
        // Example: n = 3
        System.out.println(generateParenthesis(3));
        // Output: ["((()))", "(()())", "(())()", "()(())", "()()()"]
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    static void backtrack(List<String> ans, String curr, int open, int close, int n) {
        if (curr.length() == n * 2) {
            ans.add(curr);
            return;
        }
        if (open < n) {
            backtrack(ans, curr + "(", open + 1, close, n);
        }
        if (close < open) {
            backtrack(ans, curr + ")", open, close + 1, n);
        }
    }
}
