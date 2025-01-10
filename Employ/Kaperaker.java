package Employ;

import java.util.Scanner;

public class Kaperaker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        if (isKaprekar(n)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        scanner.close();
    }

    static boolean isKaprekar(int n){
        if(n == 1){
            return true;
        }

        long square = (long) n*n;
        String squareString = String.valueOf(square);
        
        int len = squareString.length();

        String leftString = squareString.substring(0,len/2);
        String rightString = squareString.substring(len/2);

        int left = leftString.isEmpty() ? 0 : Integer.parseInt(leftString);
        int right = Integer.parseInt(rightString);


        return (left + right) == n;
    }

}