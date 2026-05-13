package dynamicPrograming.matrixChain;

import java.util.Arrays;

public class PalindromicPartitioning {

    //recursive
    private static int solve2(String s, int i, int j){

        if(i >= j || isPalindrome(s,i,j)) return 0;

        int ans = Integer.MAX_VALUE;
        for (int k = i; k <j ; k++) {

            int temp = 1+ solve2(s,i,k)+solve2(s,k+1,j);
            ans = Math.min(temp,ans);

        }

        return ans;
    }
    //memo
    private static int solve3(String s, int i, int j, int[][] dp){

        if(i >= j || isPalindrome(s,i,j)) return 0;

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for (int k = i; k <j ; k++) {

            int temp = 1+ solve3(s,i,k,dp)+solve3(s,k+1,j,dp);
            ans = Math.min(temp,ans);
        }

        return dp[i][j] = ans;
    }

    public static void main(String[] args) {

        String s = "geek";
        System.out.println(palPartition(s));
    }

    static int palPartition(String s) {
        // code here

        int n = s.length();
        if(n == 0 || isPalindrome(s,0,n-1)) return 0;
        int[][] dp = new int[n][n];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return solve(s,0,n-1,dp);
    }
    //memo
    private static int solve(String s, int i, int j, int[][] dp){

        if(i >= j || isPalindrome(s,i,j)) return 0;

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for (int k = i; k <j ; k++) {
            int left = 0, right = 0;
            // Left partition
            if (dp[i][k] != -1)
                left = dp[i][k];
            else {
                left = solve(s, i, k, dp);
                dp[i][k] = left;
            }

            // Right partition
            if (dp[k + 1][j] != -1)
                right = dp[k + 1][j];
            else {
                right = solve(s, k + 1, j, dp);
                dp[k + 1][j] = right;
            }
            int temp = 1+ left+right;
            ans = Math.min(temp,ans);
        }

        return dp[i][j] = ans;
    }

    private static boolean isPalindrome(String s, int i, int j){

        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }

}
