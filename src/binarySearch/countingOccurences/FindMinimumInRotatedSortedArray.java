package binarySearch.countingOccurences;

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(findMin(nums));
        System.out.println(findMin2(nums));
    }

    public static int findMin(int[] nums) {

        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[high] < nums[mid]){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }

    public static int findMin2(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            int next = (mid+1)%n;
            int prev = (mid + n -1)% n;

            if(nums[mid] <= nums[next] && nums[mid] <= nums[prev]){
                return mid;
            }

            else if(nums[high] < nums[mid]){
                low = mid+1;
            }
            else{
                high = mid -1;
            }
        }
        return 0;
    }
}
