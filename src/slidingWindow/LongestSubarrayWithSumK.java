package slidingWindow;

public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        int[] a = {1, 2, 1,3};
        int k = 2;
        System.out.println(longestSubarrayWithSumK(a,k));
    }
    public static int longestSubarrayWithSumK(int []a, long k) {
        // Write your code here
        int n = a.length;
        int i = 0, j = 0;
        long sum = 0;
        int maxSize = 0;
        while(j < n){
            sum += a[j];

            while(sum > k && i <= j){
                sum -= a[i];
                i++;
            }
            if(sum == k){
                maxSize = Math.max(j-i+1, maxSize);
            }

            j++;
        }
        return maxSize;
    }
}
