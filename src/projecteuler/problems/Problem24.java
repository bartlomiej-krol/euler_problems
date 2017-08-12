/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.problems;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Branimir
 */
public class Problem24 implements ProjectEulerProblem {

    public Problem24() {
    }

    @Override
    public String description() {
        return "Problem 24: Lexicographic permutations\n"
                + "A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:\n" +
"\n" +
"012   021   102   120   201   210\n" +
"\n" +
"What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?";
    }

    @Override
    public String solve() {
        int n = 1000000;
        int m = 10;
        List<Integer> digits = new ArrayList();
        String nLexicographicPermutation = "";
        n--;
        for(int i = 0; i < m; i++) digits.add(i);
        
        for(int i = 0; i < m; i++) {
            long f = factorial(digits.size() - 1);
            int k = (int) (n / f);
            nLexicographicPermutation += digits.remove(k);
            
            n -= k * f;
        }
        
        return String.valueOf(nLexicographicPermutation);
    }
    
    private long factorial(int n) {
        if(n == 0 || n == 1) return 1;
        long f = 2;
        for(int i = 3; i <= n; i++) f *= i;
        return f;
    }
    
    
}
