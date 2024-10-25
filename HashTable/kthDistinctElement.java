package HashTable;
//A distinct element is an element which is present only once in an array.
//
//Note: The elements are considered in the same order in which they appear in the array from left to right.
//
//        Example: arr[] = {6, 11, 4, 11, 9, 4},     output  K = 2
//
//The only distinct elements in the array are 6 and 9.

import java.util.*;

public class kthDistinctElement {
    public static void main(String[] args) {
        int[] arr = {8, 5, 3, 5, 5, 5};
        int k = 4;
        System.out.println(helper(arr, k));
    }

    private static int helper(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();

        // Collect distinct elements (those with frequency 1) in order
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == 1) {
                res.add(arr[i]);
            }
        }

        // If the number of distinct elements is less than K, return 0
        if (res.size() < k) {
            return 0;
        }

        // Otherwise return the Kth distinct element (1-based index)
        return res.get(k - 1);


    }
}
