package dynamicPrograming.knapsack;

import java.util.Arrays;

public class SubsetSumProblem {

    public static void main(String[] args) {

        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println(isSubsetSum(arr,sum));
    }

    static Boolean isSubsetSum(int[] arr, int sum) {
        // code here
        int n = arr.length;
        Boolean[][] dp = new Boolean[n+1][sum+1];
        boolean ans =  helper(dp,arr,n-1, sum);

        for(Boolean[] row: dp){
            System.out.println(Arrays.toString(row));
        }

        return ans;
    }

    public static boolean helper(Boolean[][] dp, int[]arr, int n, int sum){
        //base case
        if(sum == 0) return true;
        if(n < 0) return false;

        //memo check
        if(dp[n][sum] != null){
            return dp[n][sum];
        }

        //skip
        boolean skip = helper(dp,arr, n-1,sum);

        //pick
        boolean pick = false;
        if(arr[n] <= sum){
            pick = helper(dp,arr, n-1,sum - arr[n]);
        }

        dp[n][sum] = pick || skip;

        return dp[n][sum];
    }

    //tabulation
    static Boolean isSubsetSum2(int[] arr, int sum) {
        // code here
        int n = arr.length;
        Boolean[][] dp = new Boolean[n+1][sum+1];
        return helper(dp,arr,n-1, sum);
    }
}
