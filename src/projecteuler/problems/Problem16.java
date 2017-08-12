/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.problems;

import java.math.BigInteger;

/**
 *
 * @author Branimir
 */
public class Problem16 implements ProjectEulerProblem {

    public Problem16() {
    }

    @Override
    public String description() {
        return "Problem 16: 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.\n" +
            "\n" +
            "What is the sum of the digits of the number 2^1000?";
    }

    @Override
    public String solve() {
        int sumOfDigits = 0;
        BigInteger bigInt = new BigInteger("2");
        bigInt = bigInt.pow(1000);
        System.out.println(bigInt);
        
        BigInteger[] dr;
        BigInteger ten = new BigInteger("10");
        BigInteger zero = new BigInteger("0");
        while(!bigInt.equals(zero)) {
            dr = bigInt.divideAndRemainder(ten);
            bigInt = dr[0];
            sumOfDigits += dr[1].intValue();
        }    
        
        return String.valueOf(sumOfDigits);
    } 
}
