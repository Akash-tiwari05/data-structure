package binarySearch.countingOccurences;

public class FindMinimumRotatedSortedArray2 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {

        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int mid = low + (high - low)/2;

            if(nums[mid] == nums[high]){
                high--;
            }
            else if(nums[high] < nums[mid]){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        return nums[low];
    }
}
