package kadanesalgo;

public class MaximumSumCircularSubarray {

    public static void main(String[] args) {

        int[] arr = {1, -2, 3, -2};//3
        System.out.println(maxSubarraySumCircular(arr));
        /*{0, 1,2, 3,4, 5,6, 7} n[i] = n[i+1 % n]; 0- 4,  prev n[i] = n[i-1+n%n]
        //{1,-2,3,-2,1,-2,3,-2}
        sub array = 1,1-2,1-2-3,2,2-3,3
        i = 0 maxSum = 1, minSum = 1
        i = 1 maxSum(1-2,-2) = -1, minSum(1-2,-2) = -2 | ans(-1, -1+2) =1
        i = 2 maxSum(-1+3,3) = +3, minSum(-2+3,3) = +1 | ans(3, 3-1) =3
        i = 3 maxSum(3-2,-2) = 1, minSum(1-2,-2) = -2 | ans(1, 1+2) =3 ans = 3
         */
    }

    public static int maxSubarraySumCircular(int[] nums) {


        int max = nums[0];
        int min = nums[0];
        int maxSum = nums[0];
        int minSum = nums[0];
        int totalSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            totalSum += nums[i];
            max = Math.max(nums[i],max+nums[i]);
            min = Math.min(nums[i],min+nums[i]);

            maxSum = Math.max(maxSum,max);
            minSum = Math.min(minSum,min);
        }

        if (maxSum < 0){
            return maxSum;
        }

        return Math.max(maxSum,totalSum - minSum);
    }
}
