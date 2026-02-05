package kadanesalgo;

public class MaximumSubarraySumOneDeletion {

    public static void main(String[] args) {
        int[] arr = {-1,-1,-1,-1};
        System.out.println(maximumSum(arr));
    }

    public static int maximumSum(int[] arr) {

        int n = arr.length;
        int keep = arr[0];
        int maxSum = arr[0];
        int delete = 0;
        for(int i = 1; i <n; i++){

            int prevKeep = keep;
            keep = Math.max(arr[i],arr[i]+keep);
            delete = Math.max(prevKeep, delete + arr[i]);
            maxSum = Math.max(maxSum,Math.max(keep,delete));
        }
        return maxSum;
    }
}
