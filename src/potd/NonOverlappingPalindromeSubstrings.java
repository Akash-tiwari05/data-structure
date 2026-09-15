package potd;

import java.util.Arrays;

public class NonOverlappingPalindromeSubstrings {

    public static void main(String[] args) {
        String s = "abaccdbbd";
        int k = 3;

        System.out.println(maxPalindromes(s,k));
        System.out.println(maxPalindromes2(s,k));
        System.out.println(maxPalindromes3(s,k));
    }

    //greedy solution
    public static int maxPalindromes(String s, int k) {

        int n = s.length();

        int count = 0;
        int lastEnd = -1;

        for (int i = 0; i < n; i++) {

            int startK = i - k + 1;
            if(startK > lastEnd && isPalindrome(s, startK, i)){
                count++;
                lastEnd = i;
                continue;
            }

            int startKPlus1 = i- k;
            if(startKPlus1 > lastEnd && isPalindrome(s,startKPlus1, i)){
                count++;
                lastEnd = i;
            }

        }

        return count;
    }

    //bottom up
    public static int maxPalindromes3(String s, int k) {
        int n = s.length();
        // dp[i] = max valid palindromes using prefix s[0 ... i-1]
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            // Choice 1: Don't end a palindrome at index i - 1
            dp[i] = dp[i - 1];

            // Choice 2a: End a palindrome of length k at index i - 1
            // Substring: s[i - k ... i - 1]
            if (i >= k && isPalindrome(s, i - k, i - 1)) {
                dp[i] = Math.max(dp[i], dp[i - k] + 1);
            }

            // Choice 2b: End a palindrome of length k + 1 at index i - 1
            // Substring: s[i - k - 1 ... i - 1]
            if (i >= k + 1 && isPalindrome(s, i - k - 1, i - 1)) {
                dp[i] = Math.max(dp[i], dp[i - k - 1] + 1);
            }
        }

        return dp[n];
    }

    //dp based solution
    private static int[] memo;

    public static int maxPalindromes2(String s, int k) {
        int n = s.length();
        memo = new int[n];
        Arrays.fill(memo, -1);

        return dfs(s, 0, k);
    }

    private static int dfs(String s, int i, int k) {
        int n = s.length();

        // Base case: not enough characters left to form a palindrome of length >= k
        if (i + k > n) {
            return 0;
        }

        // Return memoized result if already computed
        if (memo[i] != -1) {
            return memo[i];
        }

        // Option 1: Skip character at index i
        int ans = dfs(s, i + 1, k);

        // Option 2: Form a palindrome of length k starting at i
        if (isPalindrome(s, i, i + k - 1)) {
            ans = Math.max(ans, 1 + dfs(s, i + k, k));
        }

        // Option 3: Form a palindrome of length k + 1 starting at i
        if (i + k + 1 <= n && isPalindrome(s, i, i + k)) {
            ans = Math.max(ans, 1 + dfs(s, i + k + 1, k));
        }

        return memo[i] = ans;
    }

    private static boolean isPalindrome(String s, int left, int right){

        while (left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}
