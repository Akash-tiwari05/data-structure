package dynamicPrograming;

import java.util.Arrays;

public class MinCostClimbingStairs {

    public static void main(String[] args) {

        int[] arr = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(arr));
        System.out.println("Tabulation = "+solve2(arr));
        System.out.println("Two pointers = "+solve2(arr));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(solve(n-1, cost,dp), solve(n-2, cost,dp));
    }

    public static int solve(int n, int[] arr, int[] dp){
        if(n == 0 || n == 1){
            dp[n] = arr[n];
            return dp[n];
        }

        if(dp[n] != -1){
            return dp[n];
        }

        dp[n] = arr[n]+ Math.min(solve(n-2,arr,dp),
                solve(n-1,arr,dp));
        return dp[n];
    }

    //using tabulation
    public static int solve2(int[] cost){
        int n = cost.length;
        int[] dp = new int[n+1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i]+ Math.min(dp[i-2],dp[i-1]);
        }
        return Math.min(dp[n-1], dp[n-2]) ;
    }

    //using two pointers

    public static int solve3(int[] cost){
        int n = cost.length;
        int secPre = cost[0];
        int prev = cost[1];
        for (int i = 2; i < n; i++) {
            int ans = cost[i]+Math.min(prev,secPre);
            secPre = prev;
            prev = ans;
        }
        return Math.min(prev, secPre) ;
    }
}
