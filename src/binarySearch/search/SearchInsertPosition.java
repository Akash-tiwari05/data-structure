package binarySearch.search;

public class SearchInsertPosition {

    public static void main(String[] args) {
        //           0,1,2,3
        int[] arr = {1,3,5,6};
        int target = 7; // output = 2
        System.out.println(searchInsert(arr,target));
    }

    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;

        while(start<= end){
            int mid = start + (end - start)/2 ;
            if(target == nums[mid]){
                return mid;
            }
            else if(nums[mid] < target){
                start = mid+1;
            }
            else{
                end = mid -1;
            }
        }
        return start;
    }
}
