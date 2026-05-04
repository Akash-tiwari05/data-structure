package dynamicPrograming.unboundedKnap;

import java.util.Arrays;

public class CoinChange2 {

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        System.out.println(coinChange(coins, 11));
        System.out.println("Tabulation= "+coinChange2(coins, 11));
    }

    public static int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int ans = solve(coins,n-1,amount,dp);
        return ans >= (int)1e9?-1:ans;
    }

    private static int solve(int[] coins, int n, int amount, int[][] dp){

        if(amount == 0) return 0;

        if (n < 0) {
            return (int)1e9;
        }

        if(dp[n][amount] != -1) return  dp[n][amount];

        int skip = solve(coins, n-1, amount, dp);

        int pick = (int)1e9;
        if(coins[n] <= amount){
            pick = 1+ solve(coins, n, amount- coins[n], dp);
        }

        return dp[n][amount] = Math.min(pick,skip);

    }
    //Tabulation (2D DP — Minimum Coins)
    public static int coinChange2(int[] coins, int amount) {

        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        int INF = (int) 1e9;

        // Base case: first row (only using coins[0])
        for (int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0) {
                dp[0][t] = t / coins[0];
            } else {
                dp[0][t] = INF;
            }
        }

        // Fill table
        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= amount; t++) {

                int skip = dp[i - 1][t];

                int pick = INF;
                if (coins[i] <= t) {
                    pick = 1 + dp[i][t - coins[i]];
                }

                dp[i][t] = Math.min(pick, skip);
            }
        }

        int ans = dp[n - 1][amount];
        return ans >= INF ? -1 : ans;
    }
}
