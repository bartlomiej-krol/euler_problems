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
public class Problem5 implements ProjectEulerProblem {

    private final int upperRange;
    private final int bottomRange;

    public Problem5() {
        upperRange = 20;
        bottomRange = 1;
    }

    @Override
    public String description() {
        return "Problem 5: Smallest multiple\n"
                + "2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.\n"
                + "\n"
                + "What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?";
    }  

    @Override
    public String solve() {
        long smallest_multiple = 1;
        int n = upperRange - bottomRange;
        int [] tab = new int[n];
        for(int i = 0; i < n; i++) {
            tab[i] = i + bottomRange;
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++)
                if(tab[j] % tab[i] == 0) tab[j] /= tab[i];
        }
        
        for(int i = 0; i < n; i++) {
            smallest_multiple *= tab[i];
        }
        return String.valueOf(smallest_multiple);
    }
}
