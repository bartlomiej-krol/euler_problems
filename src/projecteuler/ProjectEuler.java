/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler;

import projecteuler.problems.*;
import java.util.ArrayList;

/**
 *
 * @author Branimir
 */
public class ProjectEuler {
    public static void main(String[] args) {
        long time;
        long sumTime = 0;
        ArrayList<ProjectEulerProblem> problems = getProblems();
        String solution = "";
        for (ProjectEulerProblem pep : problems) {
            System.out.println(pep.description());            
            for(int i = 0; i< 100; i++) {
                time = System.nanoTime();
                solution = pep.solve();
                time = System.nanoTime() - time;
                sumTime += time;
            }
            System.out.println("\nSolution: " + solution);
            System.out.println("\nProblem solved in " + (double) sumTime/100/1000000000 + " seconds.");
        }
    }    
    
    public static ArrayList<ProjectEulerProblem> getProblems() {
        ArrayList<ProjectEulerProblem> problems = new ArrayList<>();
        //problems.add(new Problem1()); //SOLVED
        //problems.add(new Problem2()); //SOLVED
        //problems.add(new Problem3()); //SOLVED
        //problems.add(new Problem4()); //SOLVED
        //problems.add(new Problem5()); //SOLVED
        //problems.add(new Problem6()); //SOLVED
        //problems.add(new Problem7()); //SOLVED
        //problems.add(new Problem8()); //SOLVED
        //problems.add(new Problem9()); //SOLVED
        //problems.add(new Problem10()); //SOLVED
        //problems.add(new Problem11()); //SOLVED
        //problems.add(new Problem12()); //SOLVED
        //problems.add(new Problem13()); //SOLVED
        //problems.add(new Problem14()); //SOLVED
        //problems.add(new Problem15()); //SOLVED
        //problems.add(new Problem16()); //SOLVED
        //problems.add(new Problem17()); //SOLVED
        //problems.add(new Problem18()); //SOLVED
        //problems.add(new Problem19()); //SOLVED
        //problems.add(new Problem20()); //SOLVED
        //problems.add(new Problem21()); //SOLVED
        //problems.add(new Problem22()); //SOLVED
        //problems.add(new Problem23()); //SOLVED
        //problems.add(new Problem24()); //SOLVED
        //problems.add(new Problem25()); //SOLVED
        //problems.add(new Problem26()); //SOLVED
        //problems.add(new Problem27()); //SOLVED
        //problems.add(new Problem28()); //SOLVED
        //problems.add(new Problem29()); //SOLVED
        //problems.add(new Problem30()); //SOLVED
        //problems.add(new Problem31()); //
        //problems.add(new Problem32()); //
        //problems.add(new Problem33()); //
        //problems.add(new Problem34()); //
        //problems.add(new Problem35()); //
        //problems.add(new Problem36()); //
        //problems.add(new Problem37()); //
        //problems.add(new Problem38()); //
        //problems.add(new Problem39()); //
        
        //problems.add(new Problem67()); //SOLVED
        
        return problems;
    }
}
