package dynamicPrograming.unboundedKnap;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        System.out.println(count(coins, 11));
        System.out.println("Tabulation= "+coinChange2(coins, 11));
    }

    public static int count(int[] coins, int amount) {
        // code here.
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(coins,n-1,amount,dp);
    }

    private static int solve(int[] coins, int n, int amount, int[][] dp){

        if(amount == 0) return 1;

        if (n < 0) {
            return 0;
        }

        if(dp[n][amount] != -1) return  dp[n][amount];

        int skip = solve(coins, n-1, amount, dp);

        int pick = 0;
        if(coins[n] <= amount){
            pick = solve(coins, n, amount- coins[n], dp);
        }

        return dp[n][amount] = pick+ skip;

    }

    //tabulation
    public static int coinChange2(int[] coins, int amount) {

        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j <= amount; j++) {
            dp[0][j] = 0;
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {

                if(coins[i-1] <= j){
                    dp[i][j] = dp[i][j-coins[i-1]]+dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][amount];
    }
}
