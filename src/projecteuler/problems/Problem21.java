/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.problems;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Branimir
 */
public class Problem21 implements ProjectEulerProblem {

    public Problem21() {
    }

    @Override
    public String description() {
        return "Problem 21: Amicable numbers \n" +
"Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).\n" +
"If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.\n" +
"\n" +
"For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.\n" +
"\n" +
"Evaluate the sum of all the amicable numbers under 10000.";
    }

    @Override
    public String solve() {
        int N = 10000;
        long amicableNumbersSum = 0;
        List<Integer> amicableNumbers = new LinkedList();
        Integer divisorsSum1, divisorsSum2;
        for(Integer i = 2; i < N; i++) {
            if(!amicableNumbers.contains(i)) {
                divisorsSum1 = sumOfDivisorsExclusiveN(i);
                if(!divisorsSum1.equals(i)) {
                    divisorsSum2 = sumOfDivisorsExclusiveN(divisorsSum1);
                    if(divisorsSum2.equals(i)) {
                        amicableNumbers.add(i);
                        amicableNumbers.add(divisorsSum1);
                    }
                }
            }
        }
        for(Integer i: amicableNumbers) amicableNumbersSum += i;
        return String.valueOf(amicableNumbersSum);
    }

    private Integer sumOfDivisorsExclusiveN(Integer n) {
        Integer sum = 1;
        Integer sqrtN = (int)Math.sqrt((int)n);
        int d;
        for(int i = 2; i <= sqrtN; i++) {
            if(n % i == 0) {
                d = n / i;
                sum += i;
                if(d != i) sum += d;
            }
        }
        return sum;
    }
    
}
