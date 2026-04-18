package dynamicPrograming;

import java.util.Arrays;

public class FriendsPairingProblem {

    public static void main(String[] args) {

        System.out.println(countFriendsPairings(3));
        System.out.println("Solve = "+countFriendsPairings2(3));
    }

    //recursion
    public static long countFriendsPairings(int n) {
        // code here
        if(n <= 2) return n;
        return countFriendsPairings(n-1)+(n-1)*countFriendsPairings(n-2);
    }

    //memo
    public static long countFriendsPairings2(int n) {
        // code here
        long[] dp = new long[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
    private static long solve(int n, long[] dp) {
        // code here
        if(n <= 2){
            dp[n] = n;
            return n;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        dp[n] = solve(n-1,dp)+(n-1)*solve(n-2,dp);
        return dp[n];
    }
}
