package HashTable;
//Sample Input 1
//
//codequotientchamp
//Sample Output 1
//2

import java.util.HashMap;

//Explanation 1
//‘d’ is the first non-repeating character in the given string, therefore the output is its index i.e. 2.
//Sample Input 2
//
//silentlisten
//Sample Output 2
//
//        -1
//Explanation 2
//
//All the characters in the given string are repeating, therefore
public class first_unique_character {
    public static void main(String[] args) {
        String str = "codequotientchamp";
        System.out.println(unique(str));
    }

    private static int unique(String str) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : str.toCharArray()){
            map.put(c, map.getOrDefault(c,0) +1);
        }

        for (int i = 0; i < str.length(); i++) {
            if(map.get(str.charAt(i)) ==1){
                return i;
            }
        }
        return -1;
    }
}
