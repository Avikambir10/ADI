package Sorting;

import java.util.ArrayList;

public class Merge_Sort {
    public static void main(String[] args) {
        int[] nums = {2, 3, 67, 12, 5, 7, 2, 523, 56, 2, 1};
        merge(nums, 0, nums.length - 1);
        System.out.println("After sorting array: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private static void merge(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        merge(nums, low, mid);
        merge(nums, mid + 1, high);
        merging(nums, low, mid, high); 
    }

    private static void merging(int[] nums, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(nums[left]);
            left++;
        }
        while (right <= high) {
            temp.add(nums[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }

    }
}
