package dynamicPrograming.oneD_dp;

import java.util.Arrays;

public class PerfectSquares {

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    public static int numSquares(int n) {

        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);


        return solve(n,dp);
    }

    public static int solve(int n,int[] dp){

        if (n == 0) return 0;

        if (dp[n] != -1) return dp[n];

        int min = Integer.MAX_VALUE;

        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, 1 + solve(n - i * i, dp));
        }

        return dp[n] = min;
    }

}

