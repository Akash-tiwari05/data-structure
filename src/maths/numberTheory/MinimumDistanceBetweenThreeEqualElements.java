package maths.numberTheory;

public class MinimumDistanceBetweenThreeEqualElements {

    public static void main(String[] args) {

        int[] arr = {1,1,2,3,2,1,2};

        System.out.println(minimumDistance(arr));
    }

    //brute force
    public static int minimumDistance(int[] nums) {

        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {

                    if(nums[i] == nums[j] && nums[j] == nums[k]){
                        int sum = (j-i)+(k-j)+(k-i);
                        minDiff = Math.min(minDiff,sum);
                    }
                }
            }
        }

        if(minDiff == Integer.MAX_VALUE) return -1;

        return minDiff;
    }
}
