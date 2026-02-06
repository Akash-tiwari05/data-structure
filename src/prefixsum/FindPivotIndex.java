package prefixsum;

import java.util.HashMap;

public class FindPivotIndex {

    public static void main(String[] args) {

        int[] arr = {2,1,-1};
        System.out.println(pivotIndex(arr));
    }

    public static int pivotIndex(int[] nums) {

        int n = nums.length;
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if(rightSum == leftSum){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
