package HashTable;

import java.util.HashMap;

public class ArraysEqualorNot {
    public static void main(String[] args) {
        int[] a = {1, 2, 4};
        int[] b = {4, 2, 1};
        System.out.println(check(a, b));
    }

    private static boolean check(int[] a, int[] b) {
        HashMap<Integer, Integer> mapA = new HashMap<>();
        for (int numA : a) {
            mapA.put(numA, mapA.getOrDefault(numA, 0) + 1);
        }
        HashMap<Integer, Integer> mapb = new HashMap<>();
        for (int numb : b) {
            mapb.put(numb, mapb.getOrDefault(numb, 0) + 1);
        }

        return mapA.equals(mapb);
    }
}
