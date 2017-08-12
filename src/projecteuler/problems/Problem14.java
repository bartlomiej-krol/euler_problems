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
public class Problem14 implements ProjectEulerProblem {

    public Problem14() {
    }

    @Override
    public String description() {
        return "Problem 14: The following iterative sequence is defined for the set of positive integers:\n" +
"\n" +
"n → n/2 (n is even)\n" +
"n → 3n + 1 (n is odd)\n" +
"\n" +
"Using the rule above and starting with 13, we generate the following sequence:\n" +
"13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1\n" +
"\n" +
"It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.\n" +
"\n" +
"Which starting number, under one million, produces the longest chain?\n" +
"\n" +
"NOTE: Once the chain starts the terms are allowed to go above one million.";
    }

    @Override
    public String solve() {
        long n = 1L, lorenzLength;
        long maxLorenzLength = 0L;
        long bestStartingNumber = 0L;
        while(n < 1000000) {
            lorenzLength = lorenzLength(n);
            if(lorenzLength > maxLorenzLength){
                bestStartingNumber = n;
                maxLorenzLength = lorenzLength;
            }
            n++;
        }
        return String.valueOf(bestStartingNumber);
        //drawLorenzSequence(bestStartingNumber);
    } 
    
    private int lorenzLength(long n) {
        int k = 0;
        while(n>1) {
            if(n%2==0) n /= 2;
            else n = 3*n+1;
            k++;
        }
        return k;
    }
    
    private void drawLorenzSequence(long n) {
        int k=0;
        while(n>1) {
            k++;
            System.out.print(n + " → ");
            if(k % 7 == 0) System.out.println();
            
            if(n%2==0) n /= 2;
            else n = 3*n+1;
        }
        System.out.print(n);
    }
    
}
