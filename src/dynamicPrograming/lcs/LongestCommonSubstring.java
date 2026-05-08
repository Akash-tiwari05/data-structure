package dynamicPrograming.lcs;

import java.util.Arrays;

public class LongestCommonSubstring {

    public static void main(String[] args) {

        String s1 = "ABCDGH", s2 = "ACDGHR";
        System.out.println(longCommSubstr(s1,s2));
        System.out.println(longCommSubstr2(s1,s2));
    }

    public static int longCommSubstr(String s1, String s2) {
        // code here

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        int ans = 0;

        // check all ending positions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                ans = Math.max(ans,
                        solve(s1, s2, i, j, dp));
            }
        }

        return ans;
    }

    //memo
    private static int solve(String s1, String s2, int m, int n, int[][] dp){
        if(n < 0 || m < 0){
            return 0;
        }

        if (dp[m][n] != -1){
            return dp[m][n];
        }

        if(s1.charAt(m) == s2.charAt(n)){
            return dp[m][n] =  1 + solve(s1,s2,m-1, n-1,dp);
        }

        return dp[m][n] = 0;
    }

    //tabulation
    public static int longCommSubstr2(String s1, String s2) {
        // code here

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    ans = Math.max(ans,dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }

            }

        }

        return ans;
    }
}
