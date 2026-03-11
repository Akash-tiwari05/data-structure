package binarySearch.bitonicArraySearch;

public class BitonicPoint {

    public static void main(String[] args) {
        int[] arr= {1, 2, 4, 5, 7, 8, 3};
        System.out.println(findMaximum(arr));
    }

    public static int findMaximum(int[] arr) {
        // code here
        int n = arr.length;
        int low = 0;
        int high = n-1;
        while (low < high){
            int mid = low + (high- low)/2;
            if(arr[mid] < arr[mid +1]){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return arr[low];
    }
}
