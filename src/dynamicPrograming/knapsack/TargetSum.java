package dynamicPrograming.knapsack;

import java.util.Arrays;

public class TargetSum {

    public static void main(String[] args) {

        int[] arr = {1,1,1,1,1};
        System.out.println(findTargetSumWays(arr,3));
    }

    public static int findTargetSumWays(int[] arr, int target) {

        int n = arr.length;
        int sum = 0;
        for(int ele: arr) sum += ele;
        if(Math.abs(target) > sum || (sum + target) % 2 != 0){
            return 0;
        }
        int totalSum = (sum + target)/2;
        int[][] dp = new int[n][totalSum +1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        int ans = solve(arr,n-1, totalSum,dp);

        return ans;
    }

    private static int solve(int[] arr, int n, int target, int[][] dp){

        if(target < 0) return 0;

        if (n == 0) {
            if (target == 0 && arr[0] == 0) return 2;
            if (target == 0 || target == arr[0]) return 1;
            return 0;
        }

        if(dp[n][target] != -1) return  dp[n][target];

        int skip = solve(arr, n-1, target, dp);

        int pick = 0;
        if(arr[n] <= target){
            pick = solve(arr, n-1, target- arr[n], dp);
        }

        return dp[n][target] = pick+ skip;

    }
}
