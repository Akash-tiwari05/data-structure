package dynamicPrograming.matrixChain;

import java.util.Arrays;

//egg dropping problems
public class SuperEggDrop {

    public static void main(String[] args) {

        int n = 2, k = 6;
        System.out.println(eggDrop(n,k));
    }

    //k == floor  and n == egg
    static int eggDrop(int n, int k) {
        // code here

        if(k == 0 || k == 1) return k;
        if(n == 1) return k;

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= k; i++) {

            int eggBreak = eggDrop(n-1,i-1);
            int notBreak = eggDrop(n,k-i);

            //worst case
            int temp = 1+ Math.max(eggBreak,notBreak);
            ans = Math.min(temp,ans);
        }
        return ans;
    }

    //mem0
    static int eggDrop2(int n, int k) {
        // code here

        int[][] dp = new int[n+1][k+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return solve(n,k,dp);
    }

    private static int solve(int n, int k, int[][] dp){

        if(k == 0 || k == 1) return k;
        if(n == 1) return k;

        if(dp[n][k] != -1){
            return dp[n][k];
        }

        int low = 1, high = k;
        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= k; i++) {

            int mid = (low + high) / 2;
            int eggBreak = solve(n - 1, mid - 1, dp);
            int notBreak = solve(n, k - mid, dp);

            //worst case
            int temp = 1+ Math.max(eggBreak,notBreak);
            ans = Math.min(temp,ans);

            // Move towards worse side
            if (eggBreak > notBreak) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return dp[n][k] = ans;
    }
}
