package HashTable;
//Given an array of size n (which is always a even number in this case)
// and an integer k.
//
//Complete the function that returns true if given array can be divided
// into pairs such that sum of every pair is divisible by k.
//
//If such pairing of array is possible return 1 else return 0.

//Sample Input
// 8 4 5 7
// 4        k

//Sample Output
//1
//
//Explanation:
//The array can be divided as
//(8,4) and (5,7) whose sum is 12, which is divisible by 4.



public class isArrayDivisibleInPairs {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7};
        int k = 4;
        System.out.println(check(arr, k));
    }

    private static int check(int[] arr, int k) {
        int[] remfreq = new int[k];
        for (int num : arr) {
            int rem = num % k;
            remfreq[rem]++;
        }
        if (remfreq[0] % 2 != 0) {
            return 0;
        }
        for (int i = 1; i < k; i++) {
            if (remfreq[i] != remfreq[k - i]) {
                return 0;
            }
        }
        return 1;

    }
}

//Explanation:
//Remainder Frequency Counting: We use an array remainderFreq where each index represents a remainder from 0 to k-1.
// For each number in the array, we calculate its remainder when divided by k and increment the corresponding index in the array.
//
//Remainder Pairing Check:

//For remainder 0, the count must be even since those numbers must pair with each other.
//For other remainders r, the frequency of r should be the same as k - r (since they need to pair up).

//Example:
//For the input:

//        8 4 5 7
//        4
//Remainders are: 8 % 4 = 0, 4 % 4 = 0, 5 % 4 = 1, 7 % 4 = 3.

//remainderFreq becomes: [2, 1, 0, 1].

// Check:

//  remainderFreq[0] is even.
//  remainderFreq[1] == remainderFreq[3].
//  Thus, the result is 1 (true).
//
//Key Simplifications:
//Array Instead of HashMap: Using an array of size k to store frequencies is simpler than using a HashMap.

//Easy Check: We only need to check that remainderFreq[r] == remainderFreq[k - r] for remainders to ensure pairs can be formed.
