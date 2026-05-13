package dynamicPrograming.matrixChain;

import java.util.*;

//using hashmap

public class BooleanParenthesization2{

    static Map<String, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        String s = "T|T&F^T";
        System.out.println(countWays(s));
    }

    static int countWays(String s) {
        return solve(s, 0, s.length() - 1, 1);
    }

    private static int solve(String s, int i, int j, int isTrue) {

        if (i > j) return 0;

        if (i == j) {
            if (isTrue == 1)
                return s.charAt(i) == 'T' ? 1 : 0;
            else
                return s.charAt(i) == 'F' ? 1 : 0;
        }

        String key = i + "," + j + "," + isTrue;

        if (memo.containsKey(key))
            return memo.get(key);

        int ans = 0;

        for (int k = i + 1; k < j; k += 2) {

            int lTrue = solve(s, i, k - 1, 1);
            int lFalse = solve(s, i, k - 1, 0);

            int rTrue = solve(s, k + 1, j, 1);
            int rFalse = solve(s, k + 1, j, 0);

            char op = s.charAt(k);

            if (op == '&') {

                if (isTrue == 1)
                    ans += lTrue * rTrue;
                else
                    ans += lTrue * rFalse + lFalse * rTrue + lFalse * rFalse;
            }

            else if (op == '|') {

                if (isTrue == 1)
                    ans += lTrue * rTrue + lTrue * rFalse + lFalse * rTrue;
                else
                    ans += lFalse * rFalse;
            }

            else if (op == '^') {

                if (isTrue == 1)
                    ans += lTrue * rFalse + lFalse * rTrue;
                else
                    ans += lTrue * rTrue + lFalse * rFalse;
            }
        }

        memo.put(key, ans);
        return ans;
    }
}
