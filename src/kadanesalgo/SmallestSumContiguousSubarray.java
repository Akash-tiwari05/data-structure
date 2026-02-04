package kadanesalgo;

public class SmallestSumContiguousSubarray {

    public static void main(String[] args) {
        int[] arr=  {3,-4, 2,-3,-1, 7,-5};
        System.out.println(smallestSumSubarray(arr,7));
    }

    static int smallestSumSubarray(int nums[], int size) {
        // your code here
        int n = nums.length;
        int sum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < n ; i++) {
            sum = Math.min(sum+nums[i],nums[i]);
            maxSum = Math.min(sum,maxSum);
        }
        return maxSum;

    }
}
