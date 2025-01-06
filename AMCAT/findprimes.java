package AMCAT;

// 5. Print all the prime numbers which are below the given number separated by comma

// Input: 50

// Output: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47  
public class findprimes {
    public static void main(String[] args) {
        int n = 50;
        primes(n);
    }

    static void primes(int n) {
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                System.out.print(i);
                if (i < n - 1) {
                    System.out.print(", ");
                }
            }

        }
        System.out.println();
    }

    static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;    
    }
}
