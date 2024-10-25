package HashTable;
//Count frequency of each character

//Sample Input
//
//codequotient
//Sample Output
//
//c1 o2 d1 e2 q1 u1 t2 i1 n1

import java.util.LinkedHashMap;
import java.util.Map;

public class count_frequency {
    public static void main(String[] args) {
        String str = "codequotient";
        count(str);
    }

    static void count(String str) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey() + "" + entry.getValue() + " ");
        }
    }
}
