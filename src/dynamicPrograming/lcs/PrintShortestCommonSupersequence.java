package dynamicPrograming.lcs;

import java.util.Arrays;

public class PrintShortestCommonSupersequence {

    public static void main(String[] args) {

        String str1 = "abac", str2 = "cab";
        System.out.println(shortestCommonSupersequence(str1,str2));
    }

    public static String shortestCommonSupersequence(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        String[][] dp = new String[n+1][m+1];

        dp[0][0] = "";
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i-1][0]+ s1.charAt(i-1);
        }

        for (int i = 1; i <= m; i++) {
            dp[0][i] = dp[0][i-1]+ s2.charAt(i-1);;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m ; j++) {

                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+s1.charAt(i-1);
                }else{
                    dp[i][j] = (dp[i-1][j].length() <= dp[i][j-1].length())?
                            dp[i-1][j] + s1.charAt(i-1): dp[i][j-1]+s2.charAt(j-1);
                }

            }
        }

        /*for(String[] s: dp){
            System.out.println(Arrays.toString(s));
        }*/

        return dp[n][m];
    }

    ///optimize
    public static String shortestCommonSupersequence2(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();

        // LCS DP
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {

            char c1 = str1.charAt(i - 1);

            for (int j = 1; j <= m; j++) {

                char c2 = str2.charAt(j - 1);

                if (c1 == c2) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Build SCS
        StringBuilder sb = new StringBuilder();

        int i = n;
        int j = m;

        while (i > 0 && j > 0) {

            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {

                sb.append(str1.charAt(i - 1));
                i--;
                j--;

            } else if (dp[i - 1][j] > dp[i][j - 1]) {

                sb.append(str1.charAt(i - 1));
                i--;

            } else {

                sb.append(str2.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }

        return sb.reverse().toString();
    }
}
