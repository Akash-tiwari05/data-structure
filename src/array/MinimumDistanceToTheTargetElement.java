package array;

public class MinimumDistanceToTheTargetElement {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(getMinDistance(arr,5,3));
    }

    public static int getMinDistance(int[] nums, int target, int start) {

        int minDis = 1001;
        for (int i = 0; i < nums.length; i++) {

            if(nums[i] == target){
                minDis = Math.min(minDis,Math.abs(i-start));
            }
        }
        return minDis;
    }
}
