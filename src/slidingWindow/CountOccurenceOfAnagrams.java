package slidingWindow;

import java.util.Arrays;
import java.util.HashMap;

public class CountOccurenceOfAnagrams {
    public static void main(String[] args) {
        String txt ="forxxorfxdofr";
        String pat ="for";
    }
    //brute force solution
    public static int searchChar(String pat, String txt) {
        int n = txt.length();
        int m = pat.length();
        int count = 0;

        // try every possible starting position
        for (int i = 0; i <= n - m; i++) {
            int j = 0;

            // compare pattern with text starting at i
            while (j < m && txt.charAt(i + j) == pat.charAt(j)) {
                j++;
            }

            // if we matched the whole pattern
            if (j == m) {
                count++;
            }
        }
        return count;
    }

    public static int search(String pat, String txt) {
        // code here
        int m = pat.length(), n = txt.length();
        int[] arr = new int[26];
        for(char ch : pat.toCharArray()){
            arr[ch-'a']++;
        }

        int i = 0 , j =0, count = 0;
        int[] txtFrq = new int[26];
        while(j < n){
            char ch = txt.charAt(j);
            txtFrq[ch -'a']++;
            int sum = j-i +1;
            if(sum == m){
                if(Arrays.equals(arr,txtFrq)){
                    count++;
                }
                txtFrq[txt.charAt(i)-'a']--;
                i++;
            }
            j++;
        }
        return count;
    }
}
