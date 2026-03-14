package binarySearch.matrix;

public class AllocateMinimumPages {

    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int k = 2;
        System.out.println(findPages(arr,k));
    }

    public static int findPages(int[] arr, int k) {
        // code here
        int n = arr.length;
        if(k > n) return -1;
        int maxArr = 0;
        int maxSum = 0;
        for (int ele : arr) {
            maxArr = Math.max(maxArr,ele);
            maxSum += ele;
        }
        int low = maxArr;
        int high = maxSum;
        int res = -1;
        while(low <= high){
            int mid = low+ (high - low)/2;

            if(isValid(arr, n, k, mid)){
                res = mid;
                high = mid -1;
            }else{
                low = mid+1;
            }
        }
        return res;
    }

    public static boolean isValid(int[] arr, int n, int k, int max){
        int count = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if(sum + arr[i] > max){
                count++;
                sum = 0;
            }
            sum += arr[i];
        }
        return count <= k;
    }
}
