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
public class Problem17 implements ProjectEulerProblem {
    String [] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    String [] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    String [] dozens = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    String hundred = "hundred";
    String thousand = "thousand";
    
    public Problem17() {
    }
    
    @Override
    public String description() {
        return "Problem 17: Number letter counts\n"
                + "If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.\n" +
"\n" +
"If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?\n" +
"\n" +
"NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of \"and\" when writing out numbers is in compliance with British usage.";
    }

    @Override
    public String solve() {
        int sum = 0;
        String s;
        for(int i=1; i<=1000; i++) {
            s = numberToWords(i);
            sum += s.length();
            //System.out.println(s);
        }
        return String.valueOf(sum);
    }  
    
    public String numberToWords(int num) {
        String s = "";
        if (num >= 1000) {
            s = numberToWords(num/1000) + thousand + (num % 1000 == 0 ? "" : numberToWords(num % 1000));
        }
        else if (num >= 100) {
            s = numberToWords(num/100) + hundred + (num % 100 == 0 ? "" : "and" + numberToWords(num % 100));
        }
        else if (num >= 20) {
            s = dozens[num/10] + (num % 10 == 0 ? "" : numberToWords(num % 10));
        }
        else if (num >= 10) {
            s = teens[num-10];
        }
        else {
            s = digits[num];
        }
        return s;
    }
}
