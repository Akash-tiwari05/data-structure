package potd;

import java.util.Arrays;

public class NonOverlappingPalindromeSubstrings {

    public static void main(String[] args) {
        String s = "abaccdbbd";
        int k = 3;

        System.out.println(maxPalindromes(s,k));
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

    private static boolean isPalindrome(String s, int left, int right){

        while (left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}
