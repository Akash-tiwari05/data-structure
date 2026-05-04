package dynamicPrograming.unboundedKnap;

import com.sun.security.jgss.GSSUtil;

public class RodCutting {

    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(arr));
    }

    public static int cutRod(int[] price) {
        // code here
        int n = price.length;


        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n ; j++) {

                if(i <= j){
                    dp[i][j] = Math.max(price[i-1]+dp[i][j-i],dp[i-1][j]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }

        }
        return dp[n][n];
    }
}
