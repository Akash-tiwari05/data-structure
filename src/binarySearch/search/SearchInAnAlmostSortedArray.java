package binarySearch.search;

public class SearchInAnAlmostSortedArray {

    public static void main(String[] args) {
        int[] arr = {10, 3, 40, 20, 50, 80, 70};
        int target = 80;
        System.out.println(findTarget(arr, target));
    }

    public static int findTarget(int arr[], int target) {
        // code here
        int n= arr.length;
        int start = 0;
        int end = n -1;
        while(start <= end){
            int mid = start + (end- start)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(mid +1 <= end && arr[mid+1] == target){
                return mid+1;
            }
            if(mid - 1 >= start && arr[mid -1] == target){
                return mid -1;
            }

            if(target > arr[mid]){
                start = mid+1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
}
