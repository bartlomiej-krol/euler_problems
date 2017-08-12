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
public class Problem6 implements ProjectEulerProblem {
    private final int n;
    public Problem6() {
        n = 100;
    }

    @Override
    public String description() {
        return "Problem 6: Sum square difference\n"
                + "The sum of the squares of the first ten natural numbers is,\n"
                + "12 + 22 + ... + 102 = 385\n"
                + "\n"
                + "The square of the sum of the first ten natural numbers is,\n"
                + "(1 + 2 + ... + 10)2 = 552 = 3025\n"
                + "\n"
                + "Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.\n"
                + "\n"
                + "Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.";
    }

    @Override
    public String solve() {
        long sum_square_diffrence = n*(n*(n*(3*n+2)-3)-2) / 12;
        return String.valueOf(sum_square_diffrence);
    }
    
}
