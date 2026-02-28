package binarySearch.search;

import java.util.Stack;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = {6,7,0,1,2,4,5};
        int target = 7;
        System.out.println(search(arr, target));
    }

    public static int search(int[] nums, int target) {

        int start =0;
        int end = nums.length -1;
        while(start <= end){
            int mid = start + (end -start)/2;
            if(nums[mid] == target){
                return mid;
            }

            //if right is sorted
            if(nums[mid] <= nums[end]){
                if(target > nums[mid] && target <= nums[end]){
                    start = mid+1;
                }
                else{
                    end = mid -1;
                }
            }
            //if left is sorted
            else{
                if(target >= nums[start] && target < nums[mid]){
                    end = mid -1;
                }
                else{
                    start = mid +1;
                }
            }
        }
        return -1;
    }
}
