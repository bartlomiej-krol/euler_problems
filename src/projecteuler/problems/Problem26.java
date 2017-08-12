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
public class Problem26 implements ProjectEulerProblem {

    public Problem26() {
    }

    @Override
    public String description() {
        return "Problem 26: Reciprocal cycles\n"
                + "A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:\n" +
"\n" +
"    1/2	= 	0.5\n" +
"    1/3	= 	0.(3)\n" +
"    1/4	= 	0.25\n" +
"    1/5	= 	0.2\n" +
"    1/6	= 	0.1(6)\n" +
"    1/7	= 	0.(142857)\n" +
"    1/8	= 	0.125\n" +
"    1/9	= 	0.(1)\n" +
"    1/10	= 	0.1 \n" +
"\n" +
"Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.\n" +
"\n" +
"Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.";
    }

    @Override
    public String solve() {
        int N = 1000;
        int d = 0;
        String maxCycle = "";
        String cycle;
        for(int i = 2; i < N; i++) {
            cycle = findCycle(1, i);
            if(cycle.length() > maxCycle.length()) {
                maxCycle = cycle;
                d = i;
            }
        }
        return String.valueOf(d);
    }

    private String findCycle(int numerator, int denominator) {
       String cycle = "";
       List<Integer> rList = new ArrayList();
       List<Integer> dList = new ArrayList();
       int start = 0, d, r;
       r = numerator-((int)(numerator/denominator))*denominator;
       
       while(r != 0 && !rList.contains(r)) {
           rList.add(r);
           r *= 10;
           d = r / denominator;
           dList.add(d);
           r = r - d * denominator;
       }
       
       for(int i = start; i < dList.size(); i++) cycle += dList.get(i);
       return cycle;
    }
}
