package twoPointers;

import java.util.Arrays;

public class TwoSumSorted {
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(arr,target)));
    }
    public static int[] twoSum(int[] arr, int target) {
        int[] ans = {-1, -1};
        int left = 0;
        int right = arr.length -1;
        while(left != right){
            if(arr[left] + arr[right] == target){
                ans[0] = left;
                ans[1] = right;
                break;
            } else if (arr[left] + arr[right] < target) {
                left++;
            }
            else{
                right--;
            }
        }
        return ans;
    }
}
