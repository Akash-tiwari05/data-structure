package dynamicPrograming.oneD_dp;

import java.util.Arrays;

public class HouseRobber {

    public static void main(String[] args) {

        int[] arr = {1,2,3,1};
        System.out.println(rob(arr));
        System.out.println("Tabultion = "+solve3(arr));
    }

    public static int rob(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(nums,dp,n-1);
    }

    //using memo
    public static int solve(int[] arr, int[] dp, int n){
        if(n < 0){
            return 0;
        }

        if (dp[n] != -1){
            return dp[n];
        }

        int pick = arr[n] + solve(arr, dp, n - 2);
        int skip = solve(arr, dp, n - 1);

        dp[n] =  Math.max(pick,skip);
        return dp[n];
    }
    //using recursion
    public static int solve2(int[] arr, int n){

        if(n < 0){
            return 0;
        }

        return Math.max(arr[n]+solve2(arr,n-2),solve2(arr,n-1));

    }

    //tabulation

    public static int solve3(int[] nums){

        int n= nums.length;
        if(n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1],nums[0]);
        for (int i = 2; i < n; i++) {
            int pick = nums[i]+dp[i-2];
            int skip = dp[i-1];
            dp[i] = Math.max(pick,skip);
        }
        return dp[n-1];
    }
}
