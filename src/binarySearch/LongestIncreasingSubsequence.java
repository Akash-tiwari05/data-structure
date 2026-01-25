package binarySearch;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {

    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i] > temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
            } else {
                int idx = search(0, temp.size() - 1, temp, nums[i]);
                temp.set(idx, nums[i]);
            }
        }
        return temp.size();
    }

    public static int search(int low, int high,
                             List<Integer> temp, int target) {

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if((temp.get(mid))  < target){
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        return low;
    }

}

