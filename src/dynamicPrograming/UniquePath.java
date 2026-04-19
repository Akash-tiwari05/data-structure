package dynamicPrograming;

import java.util.Arrays;

public class UniquePath {

    public static void main(String[] args) {

        System.out.println(uniquePaths(3,7));
        System.out.println("Tabulation "+uniquePaths2(3,7));
    }

    public static int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1); // Fills every element in the row with 10
        }

        int ans = solve(dp,m-1,n-1);
        for(int[] row: dp){
            System.out.println(Arrays.toString(row));
        }

        return ans;

    }

    public static int solve(int[][] dp, int m, int n){

        if (m == 0 || n== 0){
            dp[m][n] = 1;
            return 1;
        }

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        dp[m][n] = solve(dp,m-1,n) + solve(dp,m,n-1);
        return dp[m][n];

    }

    //tabulation

    public static int uniquePaths2(int m, int n) {

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 || j == 0){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        for(int[] row: dp){
            System.out.println(Arrays.toString(row));
        }
        return dp[m-1][n-1];
    }
}
