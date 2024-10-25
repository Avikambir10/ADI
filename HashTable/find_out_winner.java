package HashTable;

//Find out the winner bookmark_border
//Given an array of strings, find out the string which occurs maximum number of times. If two strings occurs maximum times,
// return the alphabetically later string. For example,
//
//if array is ["Amit", "Girdhar", "Amit", "Girdhar", "Girdhar", "Amit", "Amit"] then return "Amit", and
//
//if array is ["Amit", "Girdhar", "Amit", "Girdhar", "Girdhar", "Amit"] then return "Girdhar" as both occurs 3 times but
// Girdhar comes after Amit in alphabetical order.
//
// So, write a function which accepts a string array as input and return the output string.

import java.util.HashMap;

//Sample Input
//
//Amit
//Girdhar
//Amit
// Girdhar
//Girdhar
//Amit
//Sample Output
//
//Girdhar
public class find_out_winner {
    public static void main(String[] args) {
        String[] arr = {"Amit", "Girdhar", "Amit", "Girdhar", "Girdhar", "Amit"};
        System.out.println(maxoccur(arr));
    }

    private static String maxoccur(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        String winner = "";
        int maxcnt = 0;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);

            int currcnt = map.get(word);

            if (currcnt > maxcnt || (currcnt == maxcnt && word.compareTo(winner) > 0)) {
                winner = word;
                maxcnt = currcnt;
            }
        }
        return winner;
    }


}
