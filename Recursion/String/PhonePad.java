package Recursion;
//leetcode 17

import java.util.ArrayList;
import java.util.List;

public class PhonePad {
    private static final String[] keypad = {
      "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };
    public static void main(String[] args) {
        String digits = "23";
        List<String> res = pad(digits);
        System.out.println(res);
    }
    static List<String> pad(String digits){
        ArrayList<String> result = new ArrayList<>();
        if(digits.isEmpty()){
            return result;
        }

        backtrack(result,digits,new StringBuilder(),0);
        return result;
    }
    static void backtrack(ArrayList<String> result, String digits, StringBuilder sb,int idx){
        if (idx == digits.length()){
            result.add(sb.toString());
            return;
        }

        String letters = keypad[digits.charAt(idx) - '0'];
        for (char letter: letters.toCharArray()){
            sb.append(letter);
            backtrack(result,digits,sb,idx+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
