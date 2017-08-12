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
public class Problem9 implements ProjectEulerProblem {

    public Problem9() {
    }

    @Override
    public String description() {
        return "Problem 9: Special Pythagorean triplet\n"
                + "A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,\n"
                + "a^2 + b^2 = c^2\n"
                + "\n"
                + "For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.\n"
                + "\n"
                + "There exists exactly one Pythagorean triplet for which a + b + c = 1000.\n"
                + "Find the product abc.";
    }

    @Override
    public String solve() {
        int n = 10000;
        int a = 0; 
        int b = 1; 
        int c = 999;
        boolean found = false;
        while(!found) {
            if(a*a + b*b == c*c) {
                found = true;
            }
            else {
                if(b + 2 < c) b++;
                else {
                    a++;
                    b=a+1;
                }
                c = n - a - b;
                if(c <= b) break;
            }
        }
        
        if(found) {
            return String.valueOf(a*b*c);
        }
        else {
            return "\nSolution not found.";
        }
    }
    
}
