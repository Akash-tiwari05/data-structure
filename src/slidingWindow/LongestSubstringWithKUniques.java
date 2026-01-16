package slidingWindow;

public class LongestSubstringWithKUniques {
    public static void main(String[] args) {

        String s = "aabacbebebe";
        int k = 3;
        System.out.println(longestKSubstr(s,k));
    }
    public static int longestKSubstr(String s, int k) {
        // code here
        int n = s.length();
       // boolean[] visited = new boolean[26];
        int[] freq  = new int[26];
        int i =0, j = 0;
        int count = 0;
        int maxSize = -1;
        while(j < n){
            int idx = s.charAt(j) -'a';
            if(freq[idx] == 0){
                count++;
            }
            freq[idx]++;

            while(count > k && i <= j){
                int newIdx = s.charAt(i) -'a';
                freq[newIdx]--;
                if(freq[newIdx] == 0){
                    count--;
                }
                i++;
            }

            if(count == k){
                maxSize = Math.max(maxSize, j-i+1);
            }
            j++;
        }
        return maxSize;
    }
}
