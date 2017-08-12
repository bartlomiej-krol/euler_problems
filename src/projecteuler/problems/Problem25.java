/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.problems;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Branimir
 */
public class Problem25 implements ProjectEulerProblem {

    private List<BigDecimal> fibonacciNumbers;
    public Problem25() {
        fibonacciNumbers = new ArrayList();
        fibonacciNumbers.add(new BigDecimal(0));
        fibonacciNumbers.add(new BigDecimal(1));
    }

    @Override
    public String description() {
        return "Problem 25: 1000-digit Fibonacci number\n"
                + "The Fibonacci sequence is defined by the recurrence relation:\n" +
"\n" +
"    Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.\n" +
"\n" +
"Hence the first 12 terms will be:\n" +
"\n" +
"    F1 = 1\n" +
"    F2 = 1\n" +
"    F3 = 2\n" +
"    F4 = 3\n" +
"    F5 = 5\n" +
"    F6 = 8\n" +
"    F7 = 13\n" +
"    F8 = 21\n" +
"    F9 = 34\n" +
"    F10 = 55\n" +
"    F11 = 89\n" +
"    F12 = 144\n" +
"\n" +
"The 12th term, F12, is the first term to contain three digits.\n" +
"\n" +
"What is the index of the first term in the Fibonacci sequence to contain 1000 digits?";
    }

    @Override
    public String solve() {
        int n = 1000;
        int nDigitsFibonacciNumberIndex=0;
        int nMinusOneDigitsFibonacciNumberIndex=0;
        int step = n;
        int digits;
        
        do {
          digits = digitsLength(fibonacci(nDigitsFibonacciNumberIndex)); 
          if(n > digits) nDigitsFibonacciNumberIndex += step;
          else if(n < digits) {
              step = (step+1)/2;
              nDigitsFibonacciNumberIndex -= step;
          }
        } while(n != digits);
        
        while(nDigitsFibonacciNumberIndex - nMinusOneDigitsFibonacciNumberIndex != 1) {
            int indexMid = (nDigitsFibonacciNumberIndex + nMinusOneDigitsFibonacciNumberIndex)/2;
            digits = digitsLength(fibonacci(indexMid));
            if(digits == n) nDigitsFibonacciNumberIndex = indexMid;
            else nMinusOneDigitsFibonacciNumberIndex = indexMid;
        }
        
        return String.valueOf(nDigitsFibonacciNumberIndex);
    }
    
    private BigDecimal fibonacci(int n) {
        if(fibonacciNumbers.size() - 1 < n) {
            for(int i = fibonacciNumbers.size() - 1; i<n; i++) {
                fibonacciNumbers.add(fibonacciNumbers.get(i).add(fibonacciNumbers.get(i-1)));
            }
        }
        return fibonacciNumbers.get(n);
    }
    
    private int digitsLength(BigDecimal bg) {
        return bg.toPlainString().length();
    }
}
