/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.problems;

import java.math.BigDecimal;

/**
 *
 * @author Branimir
 */
public class Problem20 implements ProjectEulerProblem {

    public Problem20() {
    }

    @Override
    public String description() {
        return "Problem 20: Factorial digit sum\n" +
        "n! means n × (n − 1) × ... × 3 × 2 × 1\n" +
"\n" +
"For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,\n" +
"and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.\n" +
"\n" +
"Find the sum of the digits in the number 100!";
    }

    @Override
    public String solve() {
        long N = 100;
        long factoricalNDigitSum = 0;
        BigDecimal factorialN = factorialValue(N);
        for(char c : factorialN.toString().toCharArray()) 
            factoricalNDigitSum += (c - 48);
        System.out.println("Factorial " + N + " value: " + factorialN);
        return String.valueOf(factoricalNDigitSum);
    }
    
    private BigDecimal factorialValue(long n) {
        BigDecimal factorial = new BigDecimal(1);
        for(long i = 2; i <= n; i++) {
            factorial = factorial.multiply(BigDecimal.valueOf(i));
        }
        return factorial;
    }
    
}
