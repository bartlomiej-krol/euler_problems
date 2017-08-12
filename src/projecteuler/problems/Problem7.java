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
public class Problem7 implements ProjectEulerProblem {
    int n;
    public Problem7() {
        n = 10001;
    }

    @Override
    public String description() {
        return "Problem 7: 10001st prime\n"
                + "By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.\n"
                + "\n"
                + "What is the 10 001st prime number?";
    }

    @Override
    public String solve() {
        if(n < 1) {
            System.out.println("\nN-th prime not found for n = " + n);
            return "Solution not found.";
        }
        int [] primes = new int[n];
        int primesNumber = 1;
        int nPrime = 2;
        primes[0] = nPrime;
        int sqr;
        for(int i = 3; primesNumber < n; i+=2) {
            sqr = (int) Math.sqrt(i);
            for(int j = 0; j < primesNumber; j++){
                if( i % primes[j] == 0) break;
                else if( primes[j] > sqr) {
                    primes[primesNumber] = i;
                    primesNumber++;
                    break;
                }
            }
        }
        nPrime = primes[n-1];
        return String.valueOf(nPrime);
    }
    
}
