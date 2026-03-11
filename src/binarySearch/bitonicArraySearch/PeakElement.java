package binarySearch.bitonicArraySearch;

public class PeakElement {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 7, 8, 3};
        System.out.println(peakElement(arr));
    }

    public static int peakElement(int[] arr) {
        // code here
        int n = arr.length;
        int low = 0;
        int high = n-1;
        while (low <= high){
            int mid = low + (high- low)/2;

            if((mid == 0 || arr[mid] >= arr[mid-1]) &&
                    (mid == n-1 || arr[mid] >= arr[mid+1])){
                return mid;
            }
            if(mid < n-1 &&arr[mid] < arr[mid +1]){
                low = mid+1;
            }else{
                high = mid -1;
            }
        }
        return -1;
    }
}
