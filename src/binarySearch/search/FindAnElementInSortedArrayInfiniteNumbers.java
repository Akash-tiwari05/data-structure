package binarySearch.search;

public class FindAnElementInSortedArrayInfiniteNumbers {

    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int target = 10;
        System.out.println(search(arr, 10));
    }

    public static int search(int[] arr, int target){

        if(arr.length == 1){
            if(arr[0] == target) return 0;
        }
        int low = 0;
        int high = 1;
        while(high < arr.length && arr[high] < target) {
            if (arr[high] < target) {
                low = high;
                high *= 2;
            }
        }

        if(high >= arr.length){
            high = arr.length -1;
        }
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                low = mid+1;
            }else{
                high = mid -1;
            }
        }
        return -1;
    }
}
