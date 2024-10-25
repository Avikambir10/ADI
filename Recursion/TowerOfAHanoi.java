package Recursion;

public class TowerOfAHanoi {
    public static void main(String[] args) {
        int n = 3;
        tower(n, 'A', 'B', 'C');
        System.out.println("No. of Moves = " + ((n * n) - 1));
    }

    static void tower(int n, char source, char helper, char destination) {
        if (n == 0) return;
        tower(n - 1, source, destination, helper);
        System.out.println("Move " + source + " -> " + destination);
        tower(n - 1, destination, helper, source);
    }
}
