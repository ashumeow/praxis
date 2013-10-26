import java.util.Scanner;

/**
 * OptSieving.java
 * 
 * Write a function that takes a single argument n 
 * and returns a list of prime numbers less than or 
 * equal to n using the optimized sieving algorithm.
 * 
 * @author rdsandeep
 * @version 1.0 10/26/13
 */

public class OptSieving {

    public static void main(String args[]) { 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sieve(n);
    }

    public static void sieve(int n) {
        if (n < 2) {
            System.out.println("Invalid input");
            System.exit(-1);
        }

        boolean[] isPrime = new boolean[n + 1];
        for (int i = 3; i <= n; i++) {
            if (i % 2 != 0) isPrime[i] = true;
        }
        isPrime[2] = true;

        for (int i = 3; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i])
            {
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.println("\nNo. of primes: " + count);
    }
}
