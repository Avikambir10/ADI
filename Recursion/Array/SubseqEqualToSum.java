package Recursion.Array;

import java.util.ArrayList;
import java.util.List;

// print all subseq of given array which are equal to given Sum...
public class SubseqEqualToSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5,6};
        int sum = 10;
        printSubSeq(arr, 0, 0, new ArrayList<>(), sum);
    }

    static void printSubSeq(int[] arr, int idx, int currSum, List<Integer> list, int targetsum) {
        if (idx == arr.length) {
            if (currSum == targetsum) {
                System.out.println(list+" ");
            }
            return;
        }
        list.add(arr[idx]);
        printSubSeq(arr, idx + 1, currSum + arr[idx], list, targetsum);
        list.removeLast();
        printSubSeq(arr, idx + 1, currSum, list, targetsum);
    }
}
