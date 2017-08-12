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
public class Problem4 implements ProjectEulerProblem {
    int rangeA, rangeB;
    public Problem4() {
        rangeA = 100;
        rangeB = 999;
    }

    @Override
    public String description() {
        return "Problem 4: Largest palindrome product\n"
                + "A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.\n"
                + "\n"
                + "Find the largest palindrome made from the product of two 3-digit numbers.";
    }

    @Override
    public String solve() {
        int largest_palindrom = 0;
        int pi = 0, pj = rangeA;
        int tmp;
        int k = 0; //steps
        for(int i = rangeB; i >= pj; i--){            
            for(int j = i; j >= pj; j--){
                k++;
                tmp = i*j;
                if(isPalindrome(tmp) && tmp > largest_palindrom) {                    
                    largest_palindrom = tmp;
                    pi = i;
                    pj = j;
                    System.out.println("\n" + largest_palindrom + " ("+pi+" * "+pj+") "+k);
                    break;
                }
            }
        }
        
        return String.valueOf(largest_palindrom + " ("+pi+" * "+pj+") "+k);
    }
    
    private Boolean isPalindrome(int n) {
       String s = String.valueOf(n);
       int l = s.length();
       int hi = (l - 1)/2;
       for(int i = 0; i<=hi; i++) {
           if(s.charAt(i) != s.charAt(l - 1 - i))
               return false;
       }
       return true;
    }
}
