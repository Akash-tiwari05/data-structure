package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums,target));
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closestSum  = nums[0]+ nums[1]+nums[2];
        for(int i = 0; i < n -2; i++){
            int j = i +1;
            int k =n -1;
            while (j <k){
                int sum = nums[i]+ nums[j]+nums[k];

                if(Math.abs(sum -target) < Math.abs(closestSum - target)){
                    closestSum = sum;
                }
                if(sum == target){
                    return sum;
                } else if (sum < target) {
                    j++;
                }
                else {
                    k--;
                }
            }
        }
        return closestSum;
    }
}
