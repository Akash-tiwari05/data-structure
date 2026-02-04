package kadanesalgo;

public class MaximumSubarray {

    public static void main(String[] args) {

        int[] arr=  {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Brute force = "+ maxSubArray(arr));
        System.out.println("Optimal force = "+ maxSubArray2(arr));
    }

    //brute force
    public static int maxSubArray(int[] nums) {

        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n -1; i++) {
            int sum  = nums[i];
            for (int j = i+1; j < n; j++) {
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    //optimal solution
    public static int maxSubArray2(int[] nums) {

        int n = nums.length;
        int sum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < n ; i++) {
            sum = Math.max(sum+nums[i],nums[i]);
            maxSum = Math.max(sum,maxSum);
        }
        return maxSum;
    }
}
