package dynamicPrograming.knapsack;

import java.util.Arrays;

public class PerfectSumProblem {

    public static void main(String[] args) {

        int[] nums = {5, 2, 3, 10, 6, 8};
        int target = 10;
        System.out.println(perfectSum(nums,target));
    }

    public static int perfectSum(int[] nums, int target) {
        // code here
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return solve(dp,nums,n-1,target);
    }

    public static int solve(int[][] dp, int[] nums, int n, int target){

        if (n == 0) {
            if (target == 0 && nums[0] == 0) return 2;
            if (target == 0 || target == nums[0]) return 1;
            return 0;
        }

        if (dp[n][target] != -1) return dp[n][target];

        int pick = 0;
        if (nums[n] <= target)
            pick = solve(dp, nums, n - 1, target - nums[n]);

        int skip = solve(dp, nums, n - 1, target);

        return dp[n][target] = pick + skip;

    }
}
