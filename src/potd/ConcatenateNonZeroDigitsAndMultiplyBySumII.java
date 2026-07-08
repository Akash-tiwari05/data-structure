package potd;

import java.util.Arrays;

public class ConcatenateNonZeroDigitsAndMultiplyBySumII {

    public static void main(String[] args) {

        String s = "9876543210";
        //int[][] queries = {{0,7},{1,3},{4,6}};
        int[][] queries = {{0,9}};
        System.out.println(Arrays.toString(sumAndMultiply(s, queries)));
    }

    public static int[] sumAndMultiply(String s, int[][] queries) {

        int n = queries.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {

            int start = queries[i][0];
            int end = queries[i][1];

            result[i] = helper(s,start, end);
        }
        return result;
    }

    private static int helper(String s, int start, int end){
        final int modulo = 1000000007;

        long sum = 0;
        long digits = 0;
        boolean found = false;
        for (int i = start; i <= end ; i++) {

            char c = s.charAt(i);
            if(c != '0') {
                int digit = c - '0';

                found= true;
                sum += digit;

                digits = (digits * 10 + digit)% modulo;
            }
        }

        if(!found){
            return 0;
        }

        return (int) ((digits * (sum % modulo)) % modulo);
    }
}
