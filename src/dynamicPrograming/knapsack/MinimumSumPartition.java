package dynamicPrograming.knapsack;

import java.util.Arrays;

public class MinimumSumPartition {

    public static void main(String[] args) {

        int[] arr = {3, 9, 7, 3};
        System.out.println(minDifference(arr));
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


    public static int minDifference2(int[] arr) {
        // code here
        int total = 0;
        for (int num : arr) total += num;

        int target = total / 2;

        Integer[][] dp = new Integer[arr.length][target + 1];

        int best = solve(arr, arr.length - 1, target, dp);

        return total - 2 * best;
    }
}
