package AMCAT.Pattern;

public class PAttern3 {


 ///         wrong


     public static void printPattern(int n) {
        // First store the starting number for each row
        int[] startNumbers = new int[2 * n - 1];
        int num = 1;

        // Fill the first half of startNumbers
        for (int i = 0; i < n; i++) {
            startNumbers[i] = num;
            num += 2 * i + 1; // Each row has (2*i + 1) numbers
        }

        // Fill the second half by mirroring
        for (int i = 0; i < n - 1; i++) {
            startNumbers[n + i] = startNumbers[n - 2 - i];
        }

        // Print the pattern
        for (int i = 0; i < 2 * n - 1; i++) {
            int currentNum = startNumbers[i];
            int numbersInRow;

            if (i < n) {
                numbersInRow = 2 * i + 1;
            } else {
                numbersInRow = 2 * (2 * n - 2 - i) + 1;
            }

            // Print each number in the row
            for (int j = 0; j < numbersInRow; j++) {
                System.out.print(currentNum++);
                if (j < numbersInRow - 1) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        printPattern(n);
    }

}
