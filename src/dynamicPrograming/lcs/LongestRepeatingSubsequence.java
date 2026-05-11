package dynamicPrograming.lcs;

import java.util.Arrays;

public class LongestRepeatingSubsequence {

    public static void main(String[] args) {
        String s = "axxxy";
        System.out.println(longestRepeatingSubsequence(s));
        System.out.println(longestRepeatingSubsequence2(s));
    }

    public static int longestRepeatingSubsequence(String s) {
        // code here

        int n = s.length();
        String s2 = s;
        int[][] dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return solve(s,s2, n-1, n-1,dp);
    }

    private static int solve(String s1, String s2, int n, int m, int[][] dp){

        if(n < 0 || m < 0) return 0;

        if(dp[n][m] != -1){
            return dp[n][m];
        }

        if(s1.charAt(n) == s2.charAt(m) && n != m){
            return dp[n][m] = 1+ solve(s1,s2,n-1,m-1,dp);
        }

        return dp[n][m] = Math.max(solve(s1,s2,n,m-1,dp),solve(s1,s2,n-1,m,dp));
    }

    //tabulation
    public static int longestRepeatingSubsequence2(String s) {
        // code here

        int n = s.length();
        String s2 = s;
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                if(s.charAt(i-1) == s2.charAt(j-1) && i != j){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[n][n];
    }
}
