package dynamicPrograming.knapsack;

import java.util.Arrays;

public class MinimumSumPartition {

    public static void main(String[] args) {

        int[] arr = {3, 9, 7, 3};
        System.out.println(minDifference(arr));
        System.out.println(minDifference2(arr));
        System.out.println("BEst sol "+minDifference3(arr));
    }

    public static int minDifference(int arr[]) {
        // code here
        int total = 0;
        for (int num : arr) total += num;

        int target = total / 2;

        Integer[][] dp = new Integer[arr.length][target + 1];

        int best = solve(arr, arr.length - 1, target, dp);

        return total - 2 * best;
    }

    private static int solve(int[] arr, int i, int sum, Integer[][] dp) {

        if (i < 0 || sum == 0) return 0;

        if (dp[i][sum] != null) return dp[i][sum];

        int skip = solve(arr, i - 1, sum, dp);

        int pick = 0;
        if (arr[i] <= sum) {
            pick = arr[i] + solve(arr, i - 1, sum - arr[i], dp);
        }

        return dp[i][sum] = Math.max(pick, skip);
    }

    //tabulation
    public static int minDifference2(int[] arr) {
        // code here\
        int n = arr.length;
        int total = 0;
        for (int num : arr) total += num;

        int target = total / 2;

        int[][] dp = new int[arr.length+1][target + 1];
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = Math.max(arr[i - 1] + dp[i - 1][j - arr[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return total - 2*dp[n][target];
    }

    /// using absolute check method
    public static int minDifference3(int[] arr) {
        // code here\
        int n = arr.length;
        int total = 0;
        for (int num : arr) total += num;

        int target = total / 2;

        boolean[][] dp = new boolean[arr.length+1][target + 1];

        //base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        //check for last max
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }


        int best = 0;
        for (int j = target; j >= 0; j--) {
            if(dp[n][j]){
                best = j;
                break;
            }
        }
        return total - 2*best;
    }
}
