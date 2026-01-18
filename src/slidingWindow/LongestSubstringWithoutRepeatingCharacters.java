package slidingWindow;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    //using sliding window
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] freq = new int[256];
        int i = 0, j = 0;
        int maxSize = 0;
        while(j < n){
            char ch = s.charAt(j);
            freq[ch]++;

            while(freq[ch] > 1){
                freq[s.charAt(i)]--;
                i++;
            }
            maxSize = Math.max(maxSize,j - i +1);
            j++;
        }
        return maxSize;
    }
}
