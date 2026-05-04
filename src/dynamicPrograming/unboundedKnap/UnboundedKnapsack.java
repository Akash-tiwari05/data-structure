package dynamicPrograming.unboundedKnap;

import java.util.Arrays;

public class UnboundedKnapsack {

    public static void main(String[] args) {

        int[] val = {10, 40, 50, 70};
        int[] wt = {1, 3, 4, 5};
        int cap = 8;
        System.out.println(knapsack(val,wt,cap));
        System.out.println(knapsack2(val,wt,cap));
    }

    public static int knapsack(int[] val, int[] wt, int capacity) {
        // code here
        int n = val.length;
        int[][] dp = new int[n][capacity+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(val,wt, n-1, capacity, dp);
    }

    public static int solve(int[] val, int[] wt, int n, int cap, int[][] dp){

        if(n < 0 || cap == 0){
            return 0;
        }

        if(dp[n][cap] != -1) return dp[n][cap];

        int pick = 0;
        if(wt[n] <= cap){
            pick = val[n]+solve(val,wt, n, cap - wt[n],dp);
        }

        int skip = solve(val, wt, n-1, cap, dp);

        return dp[n][cap] = Math.max(pick,skip);
    }

    //tabulation

    public static int knapsack2(int[] val, int[] wt, int capacity) {
        // code here
        int n = val.length;
        int[][] dp = new int[n+1][capacity+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {

                if(wt[i-1] <= j){
                    dp[i][j] = Math.max(val[i-1]+dp[i][j- wt[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][capacity];
    }
}
