package slidingWindow;

public class MaxSubArrayOfSizeK {
    public static void main(String[] args) {

        int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        System.out.println(maxSubarraySum(arr, 4));
    }

    public static int maxSubarraySum(int[] arr, int k) {
        // Code here
        int n = arr.length;
        int i =0, j = 0;
        int maxSum = Integer.MIN_VALUE , sum = 0;
        while(j < n){
            sum += arr[j];
            if((j - i+1) == k){
                maxSum = Math.max(sum, maxSum);
                sum -= arr[i];
                i++;
            }

            j++;
        }
        return maxSum;
    }
}
