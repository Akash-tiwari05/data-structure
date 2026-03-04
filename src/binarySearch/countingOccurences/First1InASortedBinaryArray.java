package binarySearch.countingOccurences;

public class First1InASortedBinaryArray {

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1};
        System.out.println(firstIndex(arr));
    }

    public static long firstIndex(int arr[]) {
        // Your code goes here
        int low = 0;
        int high = arr.length-1;
        int result = -1;
        while (low <= high){
            int mid = low+ (high - low)/2;

            if(arr[mid] == 1){
                result = mid;
                high = mid -1;
            }else{
                low = mid+1;
            }
        }
        return result;
    }
}
