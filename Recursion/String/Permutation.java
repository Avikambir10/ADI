package Recursion.String;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
//        permutations("", "abc");
        ArrayList<String> res = permutationslist("", "abc");
        System.out.println(res);
//        System.out.println(permutationscount("", "abc"));
    }

    static void permutations(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String last = p.substring(i);
            permutations(first + ch + last, up.substring(1));
        }
    }
    static ArrayList<String> permutationslist(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String last = p.substring(i);
            ans.addAll(permutationslist(first + ch + last, up.substring(1)));
        }
        return ans;
    }
    static int permutationscount(String p, String up){
        if (up.isEmpty()) {
            return 1;
        }
        int cnt = 0;
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String last = p.substring(i);
            cnt += permutationscount(first + ch + last, up.substring(1));
        }
        return cnt;
    }

}
