package slidingWindow;

public class LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {1,3,5,4,7};

        System.out.println(findLengthOfLCIS(arr));
    }
    public static int findLengthOfLCIS(int[] nums) {
        int maxSize = 0;
        int j = 0;
        for(int i =1; i < nums.length; i++){
            while(nums[i - 1] > nums[i] && j < i) j++;
            maxSize = Math.max(maxSize, i - j +1);
        }
        return maxSize;
    }

}
