/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler.problems;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Branimir
 */
public class Problem19 implements ProjectEulerProblem {

    public Problem19() {
    }

    @Override
    public String description() {
        return "Problem 19: Counting Sundays I\n" +
        "You are given the following information, but you may prefer to do some research for yourself.\n" +
"\n" +
"    1 Jan 1900 was a Monday.\n" +
"    Thirty days has September,\n" +
"    April, June and November.\n" +
"    All the rest have thirty-one,\n" +
"    Saving February alone,\n" +
"    Which has twenty-eight, rain or shine.\n" +
"    And on leap years, twenty-nine.\n" +
"    A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.\n" +
"\n" +
"How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?";
    }

    @Override
    public String solve() {
        int sundaysCount = 0, sundaysOnBeginingOfMonth = 0;
        Calendar from, to;
        from = Calendar.getInstance();
        from.set(Calendar.YEAR, 1901);
        from.set(Calendar.MONTH, Calendar.JANUARY);
        from.set(Calendar.DAY_OF_MONTH, 1);
        to = Calendar.getInstance();
        to.set(Calendar.YEAR, 2000);
        to.set(Calendar.MONTH, Calendar.DECEMBER);
        to.set(Calendar.DAY_OF_MONTH, 31);        
        
        System.out.println(from.getTime());
        System.out.println(to.getTime());
        
        int dayToCount = Calendar.SUNDAY;
        int additionalDay = ((from.get(Calendar.DAY_OF_WEEK) <= dayToCount && to.get(Calendar.DAY_OF_WEEK) >= dayToCount) || (from.get(Calendar.DAY_OF_WEEK) >= dayToCount && to.get(Calendar.DAY_OF_WEEK) <= dayToCount)? 1 : 0);
        int daysDiff = getDaysDiffrence(from, to);
        System.out.println(daysDiff);
        sundaysCount = daysDiff / 7 + additionalDay;
        
        System.out.println("Sundays in period: " + sundaysCount);  
        
        Calendar c = (Calendar) from.clone();
        if(c.get(Calendar.DAY_OF_MONTH) > 0) {
            c.add(Calendar.MONTH, 1);
            c.set(Calendar.DAY_OF_MONTH, 1);
        }
        while(c.before(to)) {
            if(c.get(Calendar.DAY_OF_WEEK) == dayToCount) sundaysOnBeginingOfMonth++;
            c.add(Calendar.MONTH, 1);
        }
        
        return String.valueOf(sundaysOnBeginingOfMonth);
    }
    
    private int getDaysDiffrence(Calendar date1, Calendar date2) {
        Calendar dayOne = (Calendar) date1.clone(),
            dayTwo = (Calendar) date2.clone();

        if (dayOne.get(Calendar.YEAR) == dayTwo.get(Calendar.YEAR)) {
            return Math.abs(dayOne.get(Calendar.DAY_OF_YEAR) - dayTwo.get(Calendar.DAY_OF_YEAR));
        } else {
            if (dayTwo.get(Calendar.YEAR) > dayOne.get(Calendar.YEAR)) {
                //swap them
                Calendar temp = dayOne;
                dayOne = dayTwo;
                dayTwo = temp;
            }
            int extraDays = 0;

            int dayOneOriginalYearDays = dayOne.get(Calendar.DAY_OF_YEAR);

            while (dayOne.get(Calendar.YEAR) > dayTwo.get(Calendar.YEAR)) {
                dayOne.add(Calendar.YEAR, -1);
                // getActualMaximum() important for leap years
                extraDays += dayOne.getActualMaximum(Calendar.DAY_OF_YEAR);
            }

            return extraDays - dayTwo.get(Calendar.DAY_OF_YEAR) + dayOneOriginalYearDays ;
        }
    }
    
}
