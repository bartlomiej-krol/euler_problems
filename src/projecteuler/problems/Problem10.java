/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.problems;

import java.util.ArrayList;

/**
 *
 * @author Branimir
 */
public class Problem10 implements ProjectEulerProblem {

    public Problem10() {
    }

    @Override
    public String description() {
        return "Problem 10: Summation of primes\n"
                + "The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.\n"
                + "\n"
                + "Find the sum of all the primes below two million.";
    }

    @Override
    public String solve() {
        int upperLimit = 2000000;
        ArrayList<Integer> primes = new ArrayList<>();
        int sqr;
        long sum = 2;
        primes.add(2);
        for(int i = 3; i < upperLimit; i+=2) {
            sqr = (int) Math.sqrt(i);
            for(int j = 0; j < primes.size(); j++){
                if( i % primes.get(j) == 0) break;
                else if( primes.get(j) > sqr) {
                    primes.add(i);
                    sum += i;
                    break;
                }
            }
        }
        return String.valueOf(sum);
    }    
}
