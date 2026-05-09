package dynamicPrograming.lcs;

import java.util.Arrays;

public class ShortestCommonSupersequence {

    public static void main(String[] args) {

        String s1 = "AGGTAB", s2 = "GXTXAYB"; //op = 9
        System.out.println(minSuperSeq(s1,s2));
        System.out.println(minSuperSeq2(s1,s2));
    }

    public static int minSuperSeq(String s1, String s2) {
        // code here

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n][m];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return sol(s1,s2,n-1,m-1, dp);
    }

    private static int sol(String s1, String s2, int n, int m, int[][] dp){

        if(n < 0) return m+1;
        if(m < 0) return n+1;

        if(dp[n][m] != -1){
            return dp[n][m];
        }

        if(s1.charAt(n) == s2.charAt(m)){
            return dp[n][m] = 1+ sol(s1, s2, n-1, m-1, dp);
        }

        int left = 1+sol(s1,s2,n, m-1,dp);
        int right = 1+sol(s1,s2,n-1,m,dp);

        return dp[n][m] = Math.min(left,right);
    }

    //tabulation
    public static int minSuperSeq2(String s1, String s2) {
        // code here

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= m; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m ; j++) {

                if(s1.charAt(i-1) == s2.charAt(j-1)){
                   dp[i][j] = 1+ dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1+Math.min(dp[i-1][j],dp[i][j-1]);
                }

            }
        }

        /*for(int[] r: dp){
            System.out.println(Arrays.toString(r));
        }*/

        return dp[n][m];
    }
}
