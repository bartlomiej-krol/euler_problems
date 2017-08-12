/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.problems;

/**
 *
 * @author Branimir
 */
public class Problem3 implements ProjectEulerProblem {
    private long n;
    public Problem3() {
        n = 600851475143L;
    }

    @Override
    public String description() {
        return "Problem 3: Largest prime factor\n"
                + "The prime factors of 13195 are 5, 7, 13 and 29.\n"
                + "\n"
                + "What is the largest prime factor of the number 600851475143 ?";
    }

    @Override
    public String solve() {
        if(n <= 1) {
            System.out.println("n must be > 1");
            return "Solution not found.";
        }
        
        long largest_prime = -1;
        System.out.print("Prime factor:\n | ");
        for(long i=2; i<=n; i++){
            if(n % i == 0 && isPrime(i)){
                largest_prime = i;
                System.out.print(largest_prime + " | ");
                do {
                    n = n / largest_prime;
                }while (n % largest_prime == 0);
            }
        }        
        
        return String.valueOf(largest_prime);
    }
    
    boolean isPrime(long n) {
        if( n < 2) return false;
        if( n == 2) return true;
        if( n % 2 == 0) return false;
        long sqr = (long) Math.sqrt(n);
        for( long i = 3; i <= sqr; i+=2) {
            if(n % i == 0) return false;
        }
        
        return true;
    }
}
