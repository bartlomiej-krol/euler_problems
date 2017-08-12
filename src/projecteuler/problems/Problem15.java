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
public class Problem15 implements ProjectEulerProblem {

    public Problem15() {
    }

    @Override
    public String description() {
        return "Problem 15: Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.\n" +
"Image: https://projecteuler.net/project/images/p015.gif \n\n" +
"How many such routes are there through a 20×20 grid?";
    }

    @Override
    public String solve() {
        int n = 20, m = 20;
        long [][] grid = new long[n+1][m+1];
        for(int i = 0; i<=n; i++) 
            grid[i][0] = 1L;
        for(int i = 0; i<=m; i++) 
            grid[0][i] = 1L;
        
        for(int i = 1; i<=n; i++) 
            for(int j = 1; j<=m; j++) 
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            
        return String.valueOf(grid[n][m]);
                
        //Inne rozwiązanie: 
        //Trójkąt paskala
        //50 choose 20
        
//        for(int i = 0; i<=n; i++) {
//            for(int j = 0; j<=m; j++) 
//                System.out.print(" | " + grid[i][j]);
//            System.out.println();
//        }
    }  
    
        
}
