package binarySearch.search;

public class MinimumLimitOfBallsInBag {

    public static void main(String[] args) {

        int[] arr = {2,4,8,2};
        int ops = 4;
        System.out.println(minimumSize(arr,ops));
    }

    public static int minimumSize(int[] nums, int maxOperations) {
        int start = 1;
        int end =0;
        for (int num: nums){
            end = Math.max(num,end);
        }

        int res = 0;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(isPossible(nums,mid,maxOperations)) {
                res = mid;
                end = mid -1;
            }
            else {
                start = mid +1;
            }
        }
        return res;
    }

    private static boolean isPossible(int[] nums,int mid,int maxOps){

        int operations = 0;
        for (int i = 0; i < nums.length; i++) {
            operations += (nums[i]- 1)/mid;
            if(operations > maxOps) return false;
        }
        return true;

    }
}
