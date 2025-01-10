package Employ.Pattern;
/*
3
44
555
6666
6666
555
44
3 
*/
public class Pattern2 {
    public static void main(String[] args) {
        int N = 4;  // Number of rows
        int S = 3;  // Starting number
        
        // Print the first half of the pattern
        for (int i = 1; i <= N; i++) {
            int currentNumber = S + i - 1;
            for (int j = 1; j <= i; j++) {
                System.out.print(currentNumber);
            }
            System.out.println();
        }

        // Print the second half of the pattern (reverse part)
        for (int i = N; i >= 1; i--) {
            int currentNumber = S + i - 1;
            for (int j = 1; j <= i; j++) {
                System.out.print(currentNumber);
            }
            System.out.println();
        }
    }
}
