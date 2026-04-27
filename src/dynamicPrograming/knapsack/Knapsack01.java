package dynamicPrograming.knapsack;

import java.util.Arrays;

public class Knapsack01 {

    public static void main(String[] args) {

        int W = 4;
        int[] val = {1, 2, 3}, wt = {4, 5, 1};
        System.out.println(knapsack(W,val,wt));
        System.out.println(knapsack2(W,val,wt));
    }

    public static int knapsack(int w, int[] val, int[] wt) {
        // code here

        int n = val.length;
        int[][] dp = new int[n][w +1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int ans =  helper(w,dp,val,wt,n-1);
        for(int[] row : dp){
            System.out.println(Arrays.toString(row));
        }
        return ans;
    }

    public static int helper(int w, int[][] dp, int[] val, int[] wt, int n){

        if(n < 0 || w == 0){
            return 0;
        }

        if(dp[n][w] != -1){
            return dp[n][w];
        }

        // if w is less then wait return next element
        if (wt[n] > w) {
            return dp[n][w] = helper(w, dp, val, wt, n - 1);
        }

        int exclude = helper(w,dp,val,wt,n-1);
        int include = val[n]+helper(w-wt[n],dp,val,wt,n-1);

        return dp[n][w] =  Math.max(exclude,include);

    }

    //bottom  up approach
    public static int knapsack2(int w, int[] val, int[] wt) {
        // code here

        int n = val.length;
        int[][] dp = new int[n+1][w +1];
        int maxProfit = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                //base case
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                //wt <= w
                else if(wt[i -1] <= j) {
                    dp[i][j]  = Math.max(val[i-1]+dp[i-1][j- wt[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        for(int[] row : dp){
            System.out.println(Arrays.toString(row));
        }
        return dp[n][w];
    }

}
