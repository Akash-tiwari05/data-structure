package dynamicPrograming.knapsack;

import java.util.Arrays;

public class PartitionsWithGivenDifference {

    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 4};
        System.out.println(countPartitions(arr,3));
        System.out.println(countPartitions2(arr,3));
    }

    public static int countPartitions(int[] arr, int diff) {
        // code here
        int n = arr.length;
        int sum = 0;
        for(int ele: arr) sum += ele;

        if((sum + diff) % 2 != 0) return 0;
        int target = (sum + diff)/2;
        int[][] dp = new int[n+1][target+1];

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {

                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j- arr[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        /*for(int[] row: dp){
            System.out.println(Arrays.toString(row));
        }*/
        return dp[n][target];
    }

    //memo
    public static int countPartitions2(int[] arr, int diff) {
        // code here
        int n = arr.length;
        int sum = 0;
        for(int ele: arr) sum += ele;

        if((sum + diff) % 2 != 0) return 0;
        int target = (sum + diff)/2;
        int[][] dp = new int[n][target+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        int ans = solve(arr,n-1,target,dp);

        for(int[] row: dp){
            System.out.println(Arrays.toString(row));
        }
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
