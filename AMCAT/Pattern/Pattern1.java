package AMCAT.Pattern;

/*
1
3*2
4*5*6
10*9*8*7
11*12*13*14*15
*/

public class Pattern1 {

    public static void main(String[] args) {
        int n = 5; // Input value
        int num = 1; // Starting number

        for (int i = 1; i <= n; i++) {
            int start = num;
            int end = num + i - 1;
            num = end + 1; // Update the starting number for the next row

            // Print numbers for the row
            if (i % 2 == 0) {
                // For even rows, print in descending order
                for (int j = end; j >= start; j--) {
                    if (j != end) {
                        System.out.print("*");
                    }
                    System.out.print(j);
                }
            } else {
                // For odd rows, print in ascending order
                for (int j = start; j <= end; j++) {
                    if (j != start) {
                        System.out.print("*");
                    }
                    System.out.print(j);
                }
            }
            System.out.println(); // Move to the next row
        }
    }

}
