package Stacks1;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]")); // Output: "aaabcbc"
        System.out.println(decodeString("3[a2[c]]")); // Output: "accaccacc"
        System.out.println(decodeString("2[abc]3[cd]ef")); // Output: "abcabccdcdcdef"
    }

    static String decodeString(String s) {
        int num = 0;
        String currStr = "";
        Stack<Integer> stackNum = new Stack<>();
        Stack<String> stackStr = new Stack<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0'); // convert String Num to Integer num
            } else if (c == '[') {
                stackNum.push(num);
                stackStr.push(currStr);
                num = 0;
                currStr = "";
            } else if (c == ']') {
                StringBuilder decodeString = new StringBuilder(stackStr.pop());
                int repeat = stackNum.pop();

                while (repeat-- > 0) {
                    decodeString.append(currStr);
                }
                currStr = decodeString.toString();
            } else {
                currStr += c;
            }
        }
        return currStr;
    }
}
