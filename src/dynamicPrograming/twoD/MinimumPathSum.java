package dynamicPrograming.twoD;

import java.util.Arrays;

public class MinimumPathSum {

    public static void main(String[] args) {

        int[][] grids = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grids));
        System.out.println("Tabulation = "+minPathSum2(grids));
        System.out.println("Optimal = "+minPathSum3(grids));

    }
    public static int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(dp,grid,m-1,n-1);
    }

    public static int solve(int[][] dp, int[][] grid, int m, int n){


        if(m == 0 && n == 0){
            dp[m][n] = grid[m][n];
            return grid[m][n];
        }
        if(dp[m][n] != -1) return dp[m][n];
        // first row
        if (m == 0) {
            return dp[m][n] = grid[m][n] + solve(dp, grid, m, n - 1);
        }

        // first column
        if (n == 0) {
            return dp[m][n] = grid[m][n] + solve(dp, grid, m - 1, n);
        }


        return dp[m][n] = grid[m][n]+Math.min(solve(dp,grid,m-1,n)
                ,solve(dp, grid, m, n-1));
    }

    //tabulation
    public static int minPathSum2(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if(i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                }
                else if(i == 0 && j > 0){
                    dp[i][j] = grid[i][j]+ dp[i][j-1];
                }
                else if(j == 0 && i > 0){
                    dp[i][j] = grid[i][j]+ dp[i-1][j];
                }
                else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
                }

            }
        }

        return dp[m-1][n-1];
    }

    //optimal solution
    public static int minPathSum3(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // first row
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        // first column
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        // rest of the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[m - 1][n - 1];
    }
}
