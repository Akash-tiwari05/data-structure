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
/// optimal solution using sliding window
    public static int search(String pat, String txt) {
        // code here
        int m = pat.length(), n = txt.length();
        //step 1 - count the freq of pat string
        int[] freq = new int[26];
        for(char ch : pat.toCharArray()){
            freq[ch-'a']++;
        }

        int i = 0 , j =0;
        int count = freq.length;
        int ans = 0;
        while(j < n){
            char ch = txt.charAt(j);
            //step 2 include the current character
            freq[ch - 'a']--;
            if(freq[ch -'a'] == 0){
                count--;
            }

            int sum = j-i +1;
            if(sum == m){
                //step 3 find the solution
                if(count == 0){
                    ans++;
                }

                //step 4 slide the window
                char remChar = txt.charAt(i);

                if(freq[remChar-'a'] == 0){
                    count++;
                }
                freq[remChar -'a']++;
                i++;
            }
            j++;
        }
        return count;
    }
}
