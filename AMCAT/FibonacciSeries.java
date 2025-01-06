package AMCAT;

import java.util.Scanner;
// Program to Print Fibonacci Series of a Given Range
public class FibonacciSeries {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the range: ");
        int range = sc.nextInt();

        System.out.print("Fibonacci series up to " + range + " terms: ");
        printFibonacci(range);
        sc.close();
    }

    public static void printFibonacci(int range) {
        int a = 0, b = 1;
        for (int i = 1; i <= range; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
    }
}
