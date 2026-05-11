package dynamicPrograming.lcs;

import java.util.Arrays;

public class SubsequencePatternMatching {

    public static void main(String[] args) {

        String s1 = "axy";
        String s2 = "bacxey";
    }

    public static boolean subsequence(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }


        int lcs = solve(s1,s2, n-1, m-1,dp);
        return lcs == n;
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
}
