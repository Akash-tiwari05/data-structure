package bitsManupulation;

import java.util.Arrays;

public class ConvertToInteger {
    public static void main(String[] args) {
        System.out.println(convertToInteger("1000"));
    }

    public static int convertToInteger(String bits){

        int n = bits.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            char c = bits.charAt(n - i - 1);

            if (c == '1') {
                ans += (1 << i); // 2^i
            }
        }

        return ans;
    }
}
