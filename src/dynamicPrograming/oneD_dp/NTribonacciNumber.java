package dynamicPrograming.oneD_dp;

import java.util.Arrays;

public class NTribonacciNumber {

    public static void main(String[] args) {

        System.out.println(tribonacci(4));
    }

    public static int tribonacci(int n) {

        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(dp,n);
    }

    public static int helper(int[] dp, int n){

        if(n <= 1){
            return dp[n] = n;
        }

        if(n == 2){
            return dp[n] = 1;
        }

        if(dp[n] != -1) return dp[n];

        return dp[n] = helper(dp,n-1)+helper(dp,n-2)+helper(dp,n-3);
    }

}
