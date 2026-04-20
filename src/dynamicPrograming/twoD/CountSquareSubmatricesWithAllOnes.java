package dynamicPrograming.twoD;

import java.util.Arrays;

public class CountSquareSubmatricesWithAllOnes {

    public static void main(String[] args) {

        int[][] arr = {{0,1,1,1},{1,1,1,1}, {0,1,1,1}};
        System.out.println(countSquares(arr));
        System.out.println("Tabulation "+countSquares(arr));
    }

    public static int countSquares(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += helper(dp,matrix,i,j);
            }
        }
        return total;
    }

    public static int helper(int[][] dp, int[][] matrix, int m , int n){
        if(n < 0 || m < 0) return 0;

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        if(matrix[m][n] == 0){
            return dp[m][n] = 0;
        }

        int top = helper(dp, matrix, m-1, n);
        int left = helper(dp, matrix, m, n-1);
        int dia = helper(dp, matrix, m-1, n-1);

        return dp[m][n] = 1 + Math.min(top,Math.min(left,dia));
    }

    //tabulation
    public static int countSquares2(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                if(matrix[i][j] == 1){
                    matrix[i][j] = 1+Math.min(matrix[i-1][j],
                            Math.min(matrix[i-1][j-1],matrix[i][j-1]));
                }
            }
        }

        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += matrix[i][j];
            }
        }
        return total;
    }
}
