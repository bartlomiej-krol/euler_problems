package projecteuler.problems;


/**
 *
 * @author Branimir
 */
public class Problem30 implements ProjectEulerProblem {

    public Problem30() {
    }

    @Override
    public String description() {
        return "Problem 30: Digit fifth powers\n"
                + "Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:\n" +
"\n" +
"    1634 = 14 + 64 + 34 + 44\n" +
"    8208 = 84 + 24 + 04 + 84\n" +
"    9474 = 94 + 44 + 74 + 44\n" +
"\n" +
"As 1 = 14 is not a sum it is not included.\n" +
"\n" +
"The sum of these numbers is 1634 + 8208 + 9474 = 19316.\n" +
"\n" +
"Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.";
    }

    @Override
    public String solve() {
        int power = 5;
        long solution = 0;
        long max = 354294; //all numbers with 7+ digits are greater than sum of
        //fifth powers of their digits and 354294 is the maximal sum of fifth powers of digits for 6 digits numbers
        //fifth powers of digits 0-9
        long[] pows = {0, 1, 32, 243, 1024, 3125, 7776, 16807, 32768, 59049};
        for(int i = 0; i < pows.length; i++)
            pows[i] = (long)Math.pow(i, power);
        
        long sum, tmp;
        for(long i = 2; i < max; i++) {
            sum = 0;
            tmp = i;
            while(tmp > 0) {
                sum += pows[(int)tmp%10];
                tmp /= 10;
            }
            if(i == sum)
                solution += sum;
        }
        
        return String.valueOf(solution);
    }
    
    
}
