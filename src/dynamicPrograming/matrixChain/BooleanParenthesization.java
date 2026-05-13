package dynamicPrograming.matrixChain;

import java.util.Arrays;
import java.util.HashMap;

public class BooleanParenthesization {

    public static void main(String[] args) {

        String s = "T|T&F^T";
        System.out.println(countWays(s));
    }

    static int[][][] dp;
    static HashMap<String, Integer> map;
    static int countWays(String s) {
        // code here
        int n = s.length();
        dp = new int[n][n][2];
        for (int[][] row : dp)
            for (int[] col : row)
                Arrays.fill(col, -1);

        return solve(s, 0, n - 1, 1);
    }

    private static int solve(String s, int i, int j, int isTrue){

        if(i > j){
            return 0;
        }

        if(i == j){
            if(isTrue == 1){
                return s.charAt(i) == 'T' ? 1 : 0;
            }else{
                return s.charAt(i) == 'F' ? 1 : 0;
            }
        }

        if(dp[i][j][isTrue] != -1){
            return dp[i][j][isTrue];
        }

        int ans = 0;
        for (int k = i+1; k < j; k+=2){

            int lTrue = solve(s,i, k-1,1);
            int lFalse = solve(s,i, k-1,0);
            int rTrue = solve(s,k+1,j,1);
            int rFalse = solve(s,k+1, j,0);

            if(s.charAt(k) == '&'){
                if(isTrue == 1){
                    ans = ans+ lTrue*rTrue;
                }else{
                    ans = ans+ lTrue*rFalse+ lFalse*rTrue + lFalse*rFalse;
                }
            }

            else if(s.charAt(k) == '|'){
                if(isTrue == 1){
                    ans = ans+ lTrue*rTrue + lTrue*rFalse+ lFalse*rTrue;
                }else{
                    ans = ans + lFalse*rFalse;
                }
            }

            else {
                if(isTrue == 1){
                    ans = ans  + lTrue*rFalse+ lFalse*rTrue;
                }else{
                    ans = ans+  lTrue*rTrue + lFalse*rFalse;
                }
            }
        }
        return dp[i][j][isTrue] = ans;
    }
}
