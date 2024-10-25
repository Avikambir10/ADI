package CHO_QUESTIONS;

import java.util.HashMap;
import java.util.Scanner;

public class findFirstOccurrence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases

        while (T-- > 0) {
            int N = scanner.nextInt(); // Number of elements in the list
            int K = scanner.nextInt(); // The integer to find
            int[] arr = new int[N];

            // Read the sorted array
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }

            // Find and print the index of the first occurrence of K
            int index = findOccurrence(arr, N, K);
            System.out.println(index);
        }
        
        scanner.close();
    }

    static int findOccurrence(int[] arr, int n, int k) {
        // int left = 0;
        // int right = n - 1;
        // int index = -1;
        // while (left <= right) {
        //     int mid = left + (right - left) / 2;
        //     if (arr[mid] == k) {
        //         index = mid;
        //         right = mid -1;
        //     } else if (arr[mid] < k) {
        //         left = mid + 1;
        //     } else {
        //         right = mid - 1;
        //     }
        // }
        // return index;
        
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        // Populate the HashMap with the first occurrence index
        for (int i = 0; i < n; i++) {
            if (!indexMap.containsKey(arr[i])) {
                indexMap.put(arr[i], i);
            }
        }

        // Return the index if K is found, otherwise return -1
        return indexMap.getOrDefault(k, -1);
    }
}

// 3  // Test Cases

// 10 4  // N K (testcase 1)
// 1 2 4 4 4 4 5 8 9 10
// 15 7  // N K (testcase 2)
// 1 2 3 3 5 6 7 7 7 7 7 8 8 8 8
// 9 1   // N K (testcase 3)
// -5 -4 -3 -2 -1 0 0 0 1

// Sample Output

// 2
// 6
// 8