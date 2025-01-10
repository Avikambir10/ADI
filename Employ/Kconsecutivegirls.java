package Employ;

public class Kconsecutivegirls {
    public static void main(String[] args) {
        // Example 1
        int[] arr1 = { 0, 1, 1, 1, 0, 1, 1 };
        int k1 = 2;
        System.out.println(countGroups(arr1, k1)); // Output: 3

        // Example 2
        int[] arr2 = { 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1 };
        int k2 = 3;
        System.out.println(countGroups(arr2, k2)); // Output: 3

        int[] arr3 = { 1, 1, 1, 1, 1};
        int k3 = 2;
        System.out.println(countGroups(arr3, k3)); // Output: 4

        System.out.println(countGroups(new int[]{1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1}, 3)); // Output: 3

    }

    static int countGroups(int[] arr, int k) {
        int cnt = 0;
        int consecutiveOnes = 0;

        for (int num : arr) {
            if (num == 1) {
                consecutiveOnes++;
                if (consecutiveOnes == k) {
                    consecutiveOnes--;
                    cnt++;
                }
            } else {
                consecutiveOnes = 0;
            }
        }

        return cnt;
    }
}
