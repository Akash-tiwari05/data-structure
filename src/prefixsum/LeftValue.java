package prefixsum;

import java.util.Arrays;

public class LeftValue {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(printLeft(arr)));
        System.out.println(Arrays.toString(printRight(arr)));
    }

    ///prefix sum
    public static int[] printLeft(int[] arr){
        int n= arr.length;
        int[] nums = new int[n];
        Arrays.fill(nums,0);
        for (int i = 1; i < n; i++) {
            nums[i] = nums[i-1]+arr[i-1];
        }
        return nums;
    }

    /// suffix sum
    public static int[] printRight(int[] arr){
        int n= arr.length;
        int[] nums = new int[n];
        Arrays.fill(nums,0);
        for (int i = n-2; i >= 0 ; i--) {
            nums[i] = nums[i+1]+arr[i+1];
        }
        return nums;
    }

}
