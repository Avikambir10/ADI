/* Given an array of n integers which is sorted but rotated by some number of times after sorting, and a integer k. Search the element k in this sorted rotated array efficiently. For example, suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Assume there are no duplicate elements in the array. */

/* Sample Input

2   // Test Cases
3               // k (testcase 1)
6               // n  
15 18 2 3 6 12  // arr[]
7               // k (testcase 2)
7               // n 
4 5 8 9 1 2 3   // arr[]
Sample Output

3
-1 */

/* 
2   
3              
6             
15 18 2 3 6 12  
7              
7            
4 5 8 9 1 2 3 
*/
package BinarySearch;

import java.util.Scanner;

public class SearchRotatedSortedArray {

    public static void main(String[] args) {
        // Example Test Cases
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases

        while (T-- > 0) {
            int k = sc.nextInt(); // Element to search
            int n = sc.nextInt(); // Number of elements in the array
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt(); // Array elements
            }

            // Print the result of searching k in arr[]
            System.out.println(searchRotatedSortedArr(arr, k));
        }

        sc.close();
    }

    static int searchRotatedSortedArr(int[] arr, int k) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == k) {
                return mid;
            }

            if (arr[left] <= arr[mid]) {
                if (arr[left] <= k && k < arr[mid]) {
                    right = mid - 1; // search in the left half
                } else {
                    left = mid + 1; // search in the right half
                }
            } else {
                if (arr[mid] < k && k <= arr[right]) {
                    left = mid + 1; // search in the right half
                } else {
                    right = mid - 1; // search in the left half
                }
            }
        }
        return -1;
    }

}