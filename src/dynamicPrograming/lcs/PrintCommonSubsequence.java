package dynamicPrograming.lcs;


import java.util.Arrays;

public class PrintCommonSubsequence {

    public static void main(String[] args) {

        String text1 = "abcdaf", text2 = "acbcf";
        System.out.println(lcs(text1,text2));
        System.out.println("Tabulation: "+lcs2(text1,text2));
    }

    public static String lcs (String s1, String s2){

        int n = s1.length();
        int m = s2.length();

        String[][] dp = new String[n][m];
        return solve(s1,s2, n-1, m-1,dp);

    }

    //memo
    private static String solve(String s1, String s2, int n, int m,
                             String[][] dp){
        if(n < 0 || m < 0){
            return "";
        }

        if (dp[n][m] != null){
            return dp[n][m];
        }

        if(s1.charAt(n) == s2.charAt(m)){
            return dp[n][m] = solve(s1,s2,n-1, m-1,dp)+ s1.charAt(n);
        }

        String left = solve(s1,s2,n, m-1,dp);
        String right = solve(s1,s2,n-1,m,dp);

        return dp[n][m] =left.length() >= right.length() ?left:right;
    }

    //tabulation
    public static String lcs2(String s1, String s2){

        int n = s1.length();
        int m = s2.length();

        String[][] dp = new String[n+1][m+1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = "";
        }

        for (int i = 0; i <= m; i++) {
            dp[0][i] = "";
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m ; j++) {

                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+s1.charAt(i-1);
                }else{
                    dp[i][j] = (dp[i-1][j].length() >= dp[i][j-1].length())?
                            dp[i-1][j]:dp[i][j-1];
                }

            }
        }

        for(String[] s: dp){
            System.out.println(Arrays.toString(s));
        }

        return dp[n][m];
    }
}
