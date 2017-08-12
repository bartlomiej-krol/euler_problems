package projecteuler.problems;


/**
 *
 * @author Branimir
 */
public class Problem28 implements ProjectEulerProblem {

    public Problem28() {
    }

    @Override
    public String description() {
        return "Problem 28: Number spiral diagonals\n"
                + "Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:\n" +
"\n" +
"21 22 23 24 25\n" +
"20  7  8  9 10\n" +
"19  6  1  2 11\n" +
"18  5  4  3 12\n" +
"17 16 15 14 13\n" +
"\n" +
"It can be verified that the sum of the numbers on the diagonals is 101.\n" +
"\n" +
"What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?";
    }

    @Override
    public String solve() {
        int n = 501;
        long solution = 0;
        for(int i = 1; i<=n; i++) {
            solution += i * (16 * i - 28) + 16;
        }
        
        solution -= 3;
        
        return String.valueOf(solution);
    }
}
