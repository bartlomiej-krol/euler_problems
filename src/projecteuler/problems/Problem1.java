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
public class Problem1 implements ProjectEulerProblem {
    private int n, a, b;
    public Problem1() {
        n = 1000; //upper limit
        a = 3; //first multiplier
        b = 5; //second multiplier
    }

    @Override
    public String description() {
        return "Problem 1: Multiples of 3 and 5\n"
                + "If we list all the natural numbers below 10 that are multiples of 3 or 5,"
                + " we get 3, 5, 6 and 9. The sum of these multiples is 23.\n"
                + "Find the sum of all the multiples of 3 or 5 below 1000.";
        
    } 

    @Override
    public String solve(){
        if(n<=0 || a<=0 || b<=0) {
            System.out.println("n, a, b parameters must be > 0");
            return "Solution not found.";
        }
        int na = (n-1)/a; //the number of elements divisible by a below n
        int nb = (n-1)/b; //the number of elements divisible by b below n
        int nab = (n-1)/(a*b); //the number of elements divisible by a and b below n
        int sum; //sum of all multipies of a or b below n
        
        sum = (a * na * (1 + na) + b * nb * (1 + nb) - a * b * nab * (1 + nab)) >> 1;
        return String.valueOf(sum);
    }   
}
