package Employ;

import java.util.Arrays;

public class MergeAndSortArray {
     public static void main(String[] args) {
        int[] arr1 = {3, 4, 4, 5};
        int[] arr2 = {8, 7, 6, 2};

        int[] sortedArray = mergeAndSort(arr1, arr2);
        
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i]);
            if (i < sortedArray.length - 1) {
                System.out.print(", ");
            }
        }
        
        System.out.println();

        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));

    }

    public static int[] mergeAndSort(int[] arr1, int[] arr2) {
        // Step 1: Combine both arrays into one
        int[] mergedArray = new int[arr1.length + arr2.length];
        
        System.arraycopy(arr1, 0, mergedArray, 0, arr1.length);
        System.arraycopy(arr2, 0, mergedArray, arr1.length, arr2.length);
        
        // Step 2: Sort the merged array
        Arrays.sort(mergedArray);
        
        // Step 3: Return the sorted array
        return mergedArray;
    }
}
