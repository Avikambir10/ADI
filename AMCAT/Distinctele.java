package AMCAT;
// Program to print all distinct elements of given input arrays.Also print the total of the  distinct elements    
// arr1 = {1,2,3,4,5} arr2 = {2,6,8,10}

import java.util.*;

public class Distinctele {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 2, 6, 8, 5, 10 };

        HashSet<Integer> set = new HashSet<>();

        for (int num : arr1) {
            set.add(num);
        }

        for (int num : arr2) {
            set.add(num);
        }

        System.out.println("Distinct elements are: " + set);

        int sum = 0;
        for(int num : set){
            sum += num;
        }

        System.out.println("Sum " + sum);

    }
}
