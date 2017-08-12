/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Branimir
 */
public class Problem23 implements ProjectEulerProblem {

    public Problem23() {
    }

    @Override
    public String description() {
        return "Problem 23: Non-abundant sums\n"
                + "A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.\n" +
"\n" +
"A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.\n" +
"\n" +
"As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.\n" +
"\n" +
"Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.";
    }

    @Override
    public String solve() {
        int Nmax = 28123;
        Long sumNotSumAbundantNumbers = 0L;
        int[] numbers = new int[Nmax];
        for(int i = 0; i < Nmax; i++) numbers[i] = i + 1;
        
        List<Integer> abundantNumbers = new ArrayList();
        for(int i = 1; i <= Nmax; i++) {
            if(getSumOfDivisors(i) > i) {
                abundantNumbers.add(i);
                for(Integer j : abundantNumbers) {
                    if(i + j > Nmax) break;
                    numbers[i+j-1] = 0;
                }
            }
        }
        for(int i = 0; i < Nmax; i++) sumNotSumAbundantNumbers += numbers[i];
        return String.valueOf(sumNotSumAbundantNumbers);
    }

    private long getSumOfDivisors(int n) {
        long sum = 1L;
        double sqrtN = Math.sqrt(n);
        for(int i = 2; i <= sqrtN; i++) {
            if(n%i==0) {
                sum+=i;
                if(i != sqrtN) sum+=n/i;
            }
        }
        return sum;
    }
    
    
}
