package dynamicPrograming.matrixChain;

import java.util.Arrays;

public class MatrixChainMultiplication {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 3};
        System.out.println(matrixMultiplication2(arr)); //op -30
        System.out.println(matrixMultiplication(arr)); //op -30
        System.out.println(matrixMultiplication3(arr)); //op -30
    }

    //recursive
    static int matrixMultiplication2(int[] arr) {
        // code here

        int n = arr.length;
        return solve2(arr,1,n-1);
    }

    private static int solve2(int[] arr, int i, int j){

        if(i >= j) return 0;
        int ans = (int)1e8;
        for (int k = i; k < j ; k++) {
            int cost = (arr[i-1]*arr[k]*arr[j]);
            int leftAns = solve2(arr,i,k);
            int rightAns = solve2(arr,k+1,j);

            int tempCost = cost+leftAns+rightAns;

            ans = Math.min(ans,tempCost);
        }

        return ans;
    }

    //memo
    static int matrixMultiplication(int[] arr) {
        // code here

        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(arr,1,n-1, dp);
    }

    private static int solve(int[] arr, int i, int j, int[][] dp){

        if(i >= j) return 0;

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;

        for (int k = i; k < j ; k++) {

           int cost = solve(arr,i, k,dp)+solve(arr,k+1,j,dp)+
                   arr[i-1]*arr[k]*arr[j];

            ans = Math.min(ans,cost);
        }

        return dp[i][j] = ans;
    }

    //tabulation
    static int matrixMultiplication3(int[] arr) {

        int n = arr.length;

        int[][] dp = new int[n][n];

        // length of chain (L = 2 to n-1)
        for (int len = 2; len < n; len++) {

            for (int i = 1; i < n - len + 1; i++) {

                int j = i + len - 1;

                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {

                    int cost =
                            dp[i][k]
                                    + dp[k + 1][j]
                                    + arr[i - 1] * arr[k] * arr[j];

                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[1][n - 1];
    }

}
