package kadanesalgo;

public class MaximumAbsoluteSumOfAnySubarray {

    public static void main(String[] args) {

        int[] arr = {2,-5,1,-4,3,-2};
        /*
        i = 0 MaxSum = 2, MinSum = 2
        i = 1 MaxSum(2-5,-5) = -3, MinSum(2-5,-5) =-5 | Math.abs(5) | ans = 5
        i = 2 MaxSum(-3+1,1) = +1, MinSum(-5+1,1) =-4 | Math.abs(4) | ans = 5
        i = 3 MaxSum(1-4,-4) = -3, MinSum(-4-4,-4) =-8 | Math.abs(8)| ans = 8
        i = 4 MaxSum(-3+3,3) = +3, MinSum(-8+3,3) =-5 | Math.abs(5) | ans = 8
        i = 5 MaxSum(3-2,-2) = +1, MinSum(-5-2,-2) =-7 | Math.abs(4)| ans = 8
         */
        //output = 8;

        System.out.println(maxAbsoluteSum(arr));
    }

    public static int maxAbsoluteSum(int[] nums) {

        int maxSum = nums[0];
        int minSum = nums[0];
        int maxRes = Math.abs(nums[0]);

        for (int i = 1; i <nums.length ; i++) {

            maxSum = Math.max(nums[i],nums[i]+maxSum);
            minSum = Math.min(nums[i],nums[i]+minSum);
            int sum = Math.max(Math.abs(maxSum),Math.abs(minSum));
            maxRes = Math.max(maxRes,sum);
        }
        return maxRes;

    }
}
