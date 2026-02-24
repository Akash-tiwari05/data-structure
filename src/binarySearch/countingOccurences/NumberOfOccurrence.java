package binarySearch.countingOccurences;

import java.util.Arrays;

public class NumberOfOccurrence {

    public static void main(String[] args) {

        int[] nums = {2,4,10,10,10,18,20};
        int target = 10;
        System.out.println(countFreq(nums,target));
    }

    public static int countFreq(int[] nums, int target) {


        int first = foundOccur(nums,target,true);
        int last = foundOccur(nums,target,false);


        return last - first +1;
    }

    public static int foundOccur(int[] nums, int target, boolean isFirst){
        int low = 0;
        int high = nums.length -1;
        int found = -1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                //first occurrence
                found = mid;
                if(isFirst){
                    high = mid -1;
                }else{
                    low = mid +1;
                }

            }
            else if(nums[mid] < target){
                low = mid+1;
            }else{
                high = mid -1;
            }

        }

        return found;
    }
}
