package dynamicPrograming.lcs;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {

        String text1 = "abcde", text2 = "ace";
        System.out.println(longestCommonSubsequence(text1,text2));
        System.out.println(longestCommonSubsequence2(text1,text2));
    }

    public static int longestCommonSubsequence(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return solve(s1,s2, n-1, m-1,dp);
    }

    //memo
    private static int solve(String s1, String s2, int n, int m, int[][] dp){
        if(n < 0 || m < 0){
            return 0;
        }

        if (dp[n][m] != -1){
            return dp[n][m];
        }

        if(s1.charAt(n) == s2.charAt(m)){
            return dp[n][m] =  1 + solve(s1,s2,n-1, m-1,dp);
        }

        int left = solve(s1,s2,n, m-1,dp);
        int right = solve(s1,s2,n-1,m,dp);

        return dp[n][m] = Math.max(left, right);
    }

    //tabulation
    public static int longestCommonSubsequence2(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    //space optimize
    public static int longestCommonSubsequence3(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[] dp = new int[m + 1];

        for (int i = 1; i <= n; i++) {

            int prevDiagonal = 0;

            for (int j = 1; j <= m; j++) {

                int temp = dp[j];

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[j] = 1 + prevDiagonal;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }

                prevDiagonal = temp;
            }
        }

        return dp[m];
    }
}
