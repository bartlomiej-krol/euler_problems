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
public interface ProjectEulerProblem {
    public String description();
    public String solve();
}
   
/*   

    @Override
    public void description() {
        System.out.println("Problem x: \n" +
        "");
    }

    @Override
    public void solve() {
        System.out.println("\nSolution: ");
    }  
*/