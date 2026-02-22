package binarySearch.countingOccurences;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {

        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }

    public static int[] searchRange(int[] nums, int target) {

        int[] ans = {-1,-1};
        int low = 0;
        int high = nums.length;
        while (low <= high){
            int mid = low + (high - low)/2;

            while (nums[mid] == target){
                if(nums[mid - 1] == nums[mid]){

                }
            }
            if(nums[low] < target){
                low = mid+1;
            }else{
                high = mid - 1;
            }
        }

        return ans;
    }
}

