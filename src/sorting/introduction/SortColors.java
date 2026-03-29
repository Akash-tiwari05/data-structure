package sorting.introduction;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {

        int[] arr = {2,0,2,1,1,0};
        sortColors(arr);
    }

    public static void sortColors(int[] nums) {

        int n = nums.length;
        int left = 0, right = n-1;
        int mid = 0;
        while(mid <= right){
            if(nums[mid] == 2){
                swap(mid,right,nums);
                right--;
            } else if (nums[mid] == 0) {
                swap(mid,left,nums);
                left++;
                mid++;
            }else {
                mid++;
            }
        }
    }
    private static void swap(int a, int b, int[] arr){
        int temp= arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }
}
