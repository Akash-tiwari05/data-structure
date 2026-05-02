package dynamicPrograming.knapsack;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] arr = {1,5,11,5};
        System.out.println(canPartition(arr));
        System.out.println(canPartition2(arr));
    }

    //static boolean equalPartition(int arr[]) {
        // code here

    public static boolean canPartition(int[] arr) {

        int n = arr.length;
        int sum = 0;
        for(int i : arr){
            sum += i;
        }

        if(sum % 2 != 0){
            return false;
        }

        Boolean[][] dp = new Boolean[n+1][sum/2+1];
        return helper(dp, arr, n-1, sum/2);
    }

    public static boolean helper(Boolean[][] dp, int[] arr, int n, int sum){

        if(sum == 0){
            return true;
        }
        if(n < 0) return false;

        if(dp[n][sum] != null){
            return dp[n][sum];
        }

        //skip
        boolean skip = helper(dp,arr, n-1,sum);

        //pick
        boolean pick = false;
        if(arr[n] <= sum){
            pick = helper(dp,arr, n-1, sum - arr[n]);
        }

        return dp[n][sum] = pick || skip;
    }

    //naive
    public static boolean canPartition2(int[] arr) {

        int n = arr.length;
        int sum = 0;
        for(int i : arr){
            sum += i;
        }

        if(sum % 2 != 0){
            return false;
        }

        int[][] dp = new int[n][sum/2+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return helper2(dp, arr, n-1, sum/2) ==1;
    }

    public static int helper2(int[][] dp, int[] arr, int n, int sum){

        if(sum == 0){
            return 1;
        }
        if(n < 0 || sum < 0) return 0;

        if(dp[n][sum] != -1){
            return dp[n][sum];
        }

        //skip
        int skip = helper2(dp,arr, n-1,sum);

        //pick
        int pick = helper2(dp,arr, n-1, sum - arr[n]);

        return dp[n][sum] = Math.max(pick, skip);
    }
}
