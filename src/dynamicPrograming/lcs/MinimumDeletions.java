package dynamicPrograming.lcs;

import java.util.Arrays;

public class MinimumDeletions {

    public static void main(String[] args) {
        String s = "aebcbda";
        System.out.println(minDeletions(s));
    }

    static int minDeletions(String s) {
        // code here
        int n = s.length();
        String s2 = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[n+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        int lcs = solve(s,s2, n-1, n-1,dp);
        return n - lcs;
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

    //tabulation
    static int minDeletions2(String s) {
        // code here
        int n = s.length();
        String s2 = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <= n; j++) {

                if(s.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        int lcs = dp[n][n];
        return n - lcs;
    }
}
