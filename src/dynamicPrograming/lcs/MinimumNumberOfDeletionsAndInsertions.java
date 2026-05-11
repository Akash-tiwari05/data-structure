package dynamicPrograming.lcs;

import java.util.Arrays;

public class MinimumNumberOfDeletionsAndInsertions {

    public static void main(String[] args) {

        String s1 = "heap", s2 = "pea";

        System.out.println(minOperations(s1,s2));
        System.out.println(minOperations2(s1,s2));
    }

    public static int minOperations(String s1, String s2) {
        // Your code goes here

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n][m];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        int lcs =solve(s1,s2,n-1,m-1,dp);
        int del = n - lcs;
        int ins = m - lcs;

        return del + ins;
    }

    private static int solve(String s1, String s2, int n, int m, int[][] dp){

        if(n < 0 || m < 0) return 0;

        if(dp[n][m] != -1){
            return dp[n][m];
        }

        if(s1.charAt(n) == s2.charAt(m)){
            return dp[n][m] = 1+ solve(s1,s2,n-1,m-1,dp);
        }

        return dp[n][m] = Math.max(solve(s1,s2,n,m-1,dp),solve(s1,s2,n-1,m,dp));
    }

    //tabulations
    public static int minOperations2(String s1, String s2) {
        // Your code goes here

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <= m; j++) {

                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        int lcs = dp[n][m];
        int del = n - lcs;
        int ins = m - lcs;

        return del + ins;
    }
}
