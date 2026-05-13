package dynamicPrograming.matrixChain;

import java.util.Arrays;

public class PalindromicPartitioning2 {
    public static void main(String[] args) {

        String s = "geek";

        System.out.println(palPartition(s));
    }

    static int palPartition(String s) {

        int n = s.length();

        int[][] dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Palindrome table
        boolean[][] pal = new boolean[n][n];

        // Precompute palindrome substrings
        for (int gap = 0; gap < n; gap++) {

            for (int i = 0, j = gap; j < n; i++, j++) {

                if (gap == 0) {
                    pal[i][j] = true;
                }
                else if (gap == 1) {
                    pal[i][j] = (s.charAt(i) == s.charAt(j));
                }
                else {
                    pal[i][j] =
                            (s.charAt(i) == s.charAt(j))
                                    && pal[i + 1][j - 1];
                }
            }
        }

        return solve(s, 0, n - 1, dp, pal);
    }

    private static int solve(String s,
                             int i,
                             int j,
                             int[][] dp,
                             boolean[][] pal) {

        if (i >= j || pal[i][j])
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int ans = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {

            int left, right;

            if (dp[i][k] != -1)
                left = dp[i][k];
            else {
                left = solve(s, i, k, dp, pal);
                dp[i][k] = left;
            }

            if (dp[k + 1][j] != -1)
                right = dp[k + 1][j];
            else {
                right = solve(s, k + 1, j, dp, pal);
                dp[k + 1][j] = right;
            }

            int temp = 1 + left + right;

            ans = Math.min(ans, temp);
        }

        return dp[i][j] = ans;
    }
}
