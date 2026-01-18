package slidingWindow;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s,t));
    }

    public static String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        if(m < n) return "";

        int[] freq = new int[256];
        int count = 0;
        for(char ch : t.toCharArray()){
            freq[ch]++;
            count++;
        }
        int minRight = -1;
        int minLeft = -1;
        int i = 0, j = 0;
        int minSize = Integer.MAX_VALUE;
        while(j < m){
            char ch = s.charAt(j);
            if(freq[ch] > 0){
                count--;
            }
            freq[ch]--;
            while(count == 0 ){
                int windowSize = j - i +1;

                if(minSize > windowSize){
                    minLeft = i;
                    minRight = j;
                    minSize = windowSize;
                }
                freq[s.charAt(i)]++;
                if(freq[s.charAt(i)] > 0){
                    count++;
                }

                i++;
            }
            j++;
        }
        if(minLeft == -1){
            return "";
        }
        return s.substring(minLeft, minRight + 1);
    }
}
