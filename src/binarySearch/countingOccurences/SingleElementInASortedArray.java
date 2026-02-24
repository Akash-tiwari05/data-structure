package binarySearch.countingOccurences;

public class SingleElementInASortedArray {

    public static void main(String[] args) {
        int[] nums = {3,3,7,7,10,11,11};
        System.out.println(singleNonDuplicate(nums));
    }

    public static int singleNonDuplicate(int[] nums) {

        //this question solve using even and odd parity
        /*
        index = 0, 1, 2, 3, 4, 5, 6, 7, 8
        nums = [1, 1, 2, 3, 3, 4, 4, 8 ,8]

        l|h|m|num[mid]|even|odd|pair
        0,8,4,  3      y    n (3,4)


         */
        int low = 0;
        int high = nums.length -1;
        while (low < high){

            int mid = low + (high - low)/2;

            if(mid % 2 == 1){
                mid--;
            }

            if(nums[mid] == nums[mid+1]){
                low = mid + 2;
            }
            else{
                high = mid;
            }
        }
        return nums[low];
    }
}
