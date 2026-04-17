package dynamicPrograming;

import java.util.Arrays;

public class FibonacciNumber {

    public static void main(String[] args) {

        System.out.println(fib(3));
    }
//  recursion + memoization
    public static int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        int ans = solve(n,dp);
        System.out.println(Arrays.toString(dp));
        return ans;
    }

    public static int solve(int n, int[] dp){

        if(n <= 1) {
            dp[n] = n;
            return n;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        dp[n] = solve(n-1,dp)+solve(n-2,dp);
        return dp[n];
    }
}
